package br.com.lifetracking.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.BrasilCovidEntity;
import br.com.lifetracking.resources.BrasilCovidResource;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class BrasilCovidRepository implements PanacheRepository<BrasilCovidEntity> {
    
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

    //* Retorna uma lista com todos os dados dos municipios (cidades) com casos do covid *\\
    public static List<BrasilCovidEntity> listaMunicipios() {
        logger.info("Retorna uma lista com todos os dados dos municipios (cidades) com casos do covid");

        StringBuilder filters = new StringBuilder();

        filters.append(" 1=1 ");

        filters.append("and is_last = 'True' ");
        filters.append("and place_type <> 'state' ");
        filters.append("order by date, state ");

        return BrasilCovidEntity.list(filters.toString());

    }

    //* Retorna o dado do estado expecifico *\\
    public static BrasilCovidEntity especificoEstado(String estado) {
        logger.info("Retorna uma lista com todos os dados dos municipios (cidades) com casos do covid");

        Map<String, Object> params = new HashMap<>();
        StringBuilder filters = new StringBuilder();

        filters.append(" 1=1 ");

        filters.append("and place_type = 'state' ");
        filters.append("and state = :state ");
        params.put("state", estado);

        filters.append("order by date desc ");

        return BrasilCovidEntity.find(filters.toString(), params).firstResult();

    }

    //* Retorna o dados por cidade [ que e o ultimo registro preenchido na tabela ] *\\

    //* Retorna uma lista de dados para analise de uma cidade *\\







}