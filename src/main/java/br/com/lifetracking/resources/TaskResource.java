package br.com.lifetracking.resources;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.BrasilCovid;
import br.com.lifetracking.models.BrasilCovidEntity;
import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.models.DadosBrasilCovid;
import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
import br.com.lifetracking.steps.StepProcessor;
import br.com.lifetracking.steps.StepReader;
import br.com.lifetracking.steps.StepWriter;
import io.quarkus.hibernate.orm.panache.PanacheEntity;


@ApplicationScoped
@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    private static Logger logger = LoggerFactory.getLogger(StepReader.class);

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

    @POST
    @Path("/brasil_covid")
    @Transactional
    public Response brasilCovid(LocalDate date) {
        logger.info("\nEntrou no job \n");
        try {

            StepDownload.downloadFileByDate(date);

            List<BrasilCovid> listSaude = new ArrayList<>();
            listSaude = StepReader.readerByDAte(date);
            
            Set<BrasilCovid> saude = new HashSet<>(listSaude);
            Set<BrasilCovidEntity> casos = StepProcessor.processorByCSV(saude);
            StepWriter.writeByCSV(casos);


        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return Response.status(201).build();
    }


    @POST
    @Path("/ms_covid")
    @Transactional
    public Response covidMS(String url) {
        logger.info("\nEntrou no job \n");
        try {
            StepDownload.downloadFileByUrl(url);

            List<CovidSaude> listSaude = new ArrayList<>();
            listSaude = StepReader.readerByUrl();
            
            Set<CovidSaude> saude = new HashSet<>(listSaude);
            Set<DadosBrasilCovid> casos = StepProcessor.processor(saude);


            logger.info("******************");
            logger.info("Iniciou o Writer: " + Instant.now().toString());
            
            PanacheEntity.persist(casos);

            logger.info("Writer finalizado com sucesso: " + Instant.now().toString());
            logger.info("******************");

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
        return Response.status(201).build();
    }
}