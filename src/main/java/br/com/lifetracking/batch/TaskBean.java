package br.com.lifetracking.batch;

import java.io.IOException;
import java.time.Instant;
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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.models.DadosBrasilCovid;
import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
import br.com.lifetracking.steps.StepProcessor;
import br.com.lifetracking.steps.StepReader;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class TaskBean {


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

    @Transactional
    @Scheduled(cron = "0 44 12 * * ?")
    void schedule() {
        Task task = new Task();
        task.persist();

        logger.info("Entrou no job \n");
        try {
            StepDownload.downloadFile();

            List<CovidSaude> listSaude = new ArrayList<>();
            listSaude = StepReader.reader();
            
            Set<CovidSaude> saude = new HashSet<>(listSaude);
            Set<DadosBrasilCovid> casos = new HashSet<>();
            casos = StepProcessor.processor(saude);


            logger.info("******************");
            logger.info("Iniciou o Writer: " + Instant.now().toString());
            casos.forEach(action -> {
                action.persist();
            });

            logger.info("Writer finalizado com sucesso: " + Instant.now().toString());
            logger.info("******************");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}