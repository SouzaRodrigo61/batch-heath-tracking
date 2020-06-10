package br.com.lifetracking.batch;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
import br.com.lifetracking.steps.StepReader;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class TaskBean {

    @Transactional
    @Scheduled(cron = "0 24 19 * * ?")
    void schedule() {
        Task task = new Task();
        task.persist();

        try {
            System.out.println("Entrou no job");
            StepDownload.downloadFile();
            StepReader.reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}