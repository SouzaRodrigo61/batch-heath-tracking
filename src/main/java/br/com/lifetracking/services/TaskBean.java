package br.com.lifetracking.services;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.lifetracking.batch.Task;
import io.quarkus.scheduler.Scheduled;

@ApplicationScoped
public class TaskBean {

    @Transactional
    @Scheduled(every = "10s")
    void schedule() {
        Task task = new Task();
        task.persist();
    }
}