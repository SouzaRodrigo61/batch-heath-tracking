package br.com.lifetracking.batch;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
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
    @Scheduled(cron = "0 01 01 * * ?")
    void schedule() {
        Task task = new Task();
        task.persist();

        try {
            logger.info("Entrou no job \n");
            
            StepDownload.downloadFile();
            StepReader.readerCSV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}