package br.com.lifetracking.resources;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.controllers.BrasilCovidRepository;
import br.com.lifetracking.models.BrasilCovidEntity;

@Path("/covid")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "Covid", description = "Retorna os dados detalhados sobre a covid")
public class BrasilCovidResource {

    private static Logger logger = LoggerFactory.getLogger(BrasilCovidResource.class);

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
    public Response listAll() {
        logger.info("Listagem de todas as listas");
        List<BrasilCovidEntity> covid = BrasilCovidRepository.listaMunicipios();
        return Response.ok(covid).status(200).build();
    }

    @GET
    @Path("/{uf}")
    public Response uf(@PathParam String uf) {
        logger.info("Expecifico estado");
        BrasilCovidEntity covid = BrasilCovidRepository.especificoEstado(uf);
        return Response.ok(covid).status(200).build();
    }

    @GET
    @Path("/especifico/{city}")
    public Response expecificoCidade(@PathParam String city) {
        logger.info("Expecifico cidade");
        BrasilCovidEntity covid = BrasilCovidRepository.especificoCidade(city);
        return Response.ok(covid).status(200).build();
    }

    @GET
    @Path("/relatorio/{city}")
    public Response relatorioCidade(@PathParam String city) {
        logger.info("Relatorio da cidade");
        List<BrasilCovidEntity> covid = BrasilCovidRepository.relatorioCidade(city);
        return Response.ok(covid).status(200).build();
    }

}