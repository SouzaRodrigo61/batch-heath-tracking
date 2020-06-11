package br.com.lifetracking.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.CovidSaude;


public class StepReader {
    
    
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    private static final String fileName = "/tmp/brasil_covid.xlsx";
    
    public static Set
    <CovidSaude> reader() throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader: " + Instant.now().toString());
                

        Set<CovidSaude> listSaude = new HashSet<>();

        File excelFile = new File(fileName);
        FileInputStream is = new FileInputStream(excelFile);
        try (ReadableWorkbook wb = new ReadableWorkbook(is)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    CovidSaude saude = new CovidSaude();

                    saude.setRegiao(r.getCellText(0));
                    saude.setEstado(r.getCellText(1));
                    saude.setMunicipio(r.getCellText(2));
                    saude.setCoduf(r.getCellText(3));
                    saude.setCodmun(r.getCellText(4));
                    saude.setCodRegiaoSaude(r.getCellText(5));
                    saude.setNomeRegiaoSaude(r.getCellText(6));
                    saude.setData(r.getCellText(7));
                    saude.setSemanaEpi(r.getCellText(8));
                    saude.setPopulacaoTCU2019(r.getCellText(9));
                    saude.setCasosNovos(r.getCellText(10));
                    saude.setObitosAcumulado(r.getCellText(11));
                    saude.setObitosNovos(r.getCellText(12));
                    saude.setRecuperadosNovos(r.getCellText(13));
                    saude.setEmAcompanhamentoNovos(r.getCellText(14));

                    listSaude.add(saude);
                });
            }
        }
        
        logger.info("Reader finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");
        return listSaude;

    }

}