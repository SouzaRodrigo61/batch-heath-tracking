package br.com.lifetracking.resources;

import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.models.DadosBrasilCovid;
import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
import br.com.lifetracking.steps.StepProcessor;
import br.com.lifetracking.steps.StepReader;


@ApplicationScoped
@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    Set<DadosBrasilCovid> casos = new HashSet<>();


    @Inject UserTransaction userTransaction;

    @PostConstruct
    void init() {
        //set a timeout as high as you need
        try {
			userTransaction.setTransactionTimeout(10000);
		} catch (SystemException e) {
			e.printStackTrace();
		}
    }

    @GET
    public List<Task> listAll() {
        return Task.listAll();
    }


    @GET
    @Path("/batch")
    @Transactional
    public void batch() {
        Set<CovidSaude> saude = new HashSet<>();
        System.out.println("Entrou no job");
        try {
            StepDownload.downloadFile();
            saude = StepReader.reader();
            casos = StepProcessor.processor(saude);


            logger.info("******************");
            logger.info("Iniciou o Writer: " + Instant.now().toString());
            casos.forEach(action -> {
                logger.info(action.toString());
                action.persist();
            });

            

            logger.info("Writer finalizado com sucesso: " + Instant.now().toString());
            logger.info("******************");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}