package br.com.lifetracking.resources;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lifetracking.models.Task;
import br.com.lifetracking.steps.StepDownload;
import br.com.lifetracking.steps.StepReader;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource {

    @GET
    public List<Task> listAll() {
        return Task.listAll();
    }


    @GET
    @Path("/batch")
    public void batch() {
        System.out.println("Entrou no job");
        try {
            StepDownload.downloadFile();
            StepReader.reader();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }
}