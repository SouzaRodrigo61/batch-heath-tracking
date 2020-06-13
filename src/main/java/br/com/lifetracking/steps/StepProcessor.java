package br.com.lifetracking.steps;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.BrasilCovid;
import br.com.lifetracking.models.BrasilCovidEntity;
import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.models.DadosBrasilCovid;

public class StepProcessor {
    
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);

    public static Set<DadosBrasilCovid> processor(Set<CovidSaude> saude) {

        logger.info("******************");
        logger.info("Iniciou o Processador: " + Instant.now().toString());

        Set<DadosBrasilCovid> casos = new HashSet<>();

        saude.parallelStream().forEach(obj -> {
            DadosBrasilCovid caso = new DadosBrasilCovid();
            caso.rowIndex = obj.getRowIndex();
            caso.regiao = obj.getRegiao();
            caso.estado = obj.getEstado();
            caso.municipio = obj.getMunicipio();
            caso.coduf = (obj.getCoduf());
            caso.codmun = (obj.getCodmun());
            caso.codRegiaoSaude = (obj.getCodRegiaoSaude());
            caso.data = (obj.getData());
            caso.nomeRegiaoSaude = obj.getNomeRegiaoSaude();
            caso.semanaEpi = (obj.getSemanaEpi());
            caso.populacaoTCU2019 = (obj.getPopulacaoTCU2019());
            caso.casosNovos = (obj.getCasosNovos());
            caso.obitosAcumulado = (obj.getObitosAcumulado());
            caso.obitosNovos = obj.getObitosNovos();
            caso.recuperadosNovos = obj.getRecuperadosNovos();
            caso.emAcompanhamentoNovos = obj.getEmAcompanhamentoNovos();
            casos.add(caso);
        });

        logger.info("Processador finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");

        return casos;
    }
    
    public static Set<BrasilCovidEntity> processorByCSV(Set<BrasilCovid>saude) {

        logger.info("******************");
        logger.info("Iniciou o Processador: " + Instant.now().toString());

        Set<BrasilCovidEntity> casos = new HashSet<>();

        saude.parallelStream().forEach(obj -> {
            
            BrasilCovidEntity caso = new BrasilCovidEntity();

            caso.epidemiological_week = obj.getEpidemiological_week();
            caso.date = obj.getDate();
            caso.order_for_place = obj.getOrder_for_place();
            caso.state = obj.getState();
            caso.city = obj.getCity();
            caso.city_ibge_code = obj.getCity_ibge_code();
            caso.place_type = obj.getPlace_type();
            caso.last_available_confirmed = obj.getLast_available_confirmed();
            caso.last_available_confirmed_per_100k_inhabitants = obj.getLast_available_confirmed_per_100k_inhabitants();
            caso.new_confirmed = obj.getNew_confirmed();
            caso.last_available_deaths = obj.getLast_available_deaths();
            caso.new_deaths = obj.getNew_deaths();
            caso.last_available_death_rate = obj.getLast_available_death_rate();
            caso.estimated_population_2019 = obj.getEstimated_population_2019();
            caso.is_last = obj.getIs_last();
            caso.is_repeated = obj.getIs_repeated();

            casos.add(caso);

        });

        logger.info("Processador finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");

        return casos;

    }
}