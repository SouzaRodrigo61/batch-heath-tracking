package br.com.lifetracking.steps;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.models.DadosBrasilCovid;

public class StepProcessor {
    
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);

    public static Set<DadosBrasilCovid> processor(Set<CovidSaude> saude) {

        logger.info("******************");
        logger.info("Iniciou o Processador: " + Instant.now().toString());

        Set<DadosBrasilCovid> casos = new HashSet<>();

        saude.parallelStream().forEach( obj -> {
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
}