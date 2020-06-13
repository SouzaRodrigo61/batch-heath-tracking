package br.com.lifetracking.steps;

import java.time.Instant;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.BrasilCovidEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

public class StepWriter {
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    
    public static void writeByCSV(Set<BrasilCovidEntity> casos) {
        logger.info("******************");
        logger.info("Iniciou o Writer: " + Instant.now().toString());
        
        PanacheEntity.persist(casos);

        logger.info("Writer finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");
    }
}