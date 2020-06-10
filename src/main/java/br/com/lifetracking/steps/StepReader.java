package br.com.lifetracking.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
    
    public static List<CovidSaude> reader() throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader");
        List<CovidSaude> listSaude = new ArrayList<CovidSaude>();

        File excelFile = new File(fileName);
        FileInputStream is = new FileInputStream(excelFile);
        try (ReadableWorkbook wb = new ReadableWorkbook(is)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    CovidSaude saude = new CovidSaude();

                    saude.setRegiao(r.getCellAsString(0).orElse(null));
                    saude.setEstado(r.getCellAsString(1).orElse(null));
                    saude.setMunicipio(r.getCellAsString(2).orElse(null));
                    saude.setCoduf(r.getCellAsString(3).orElse(null));
                    // saude.setCodmun(r.getCellAsString(4).orElse(null));
                    // saude.setCodRegiaoSaude(r.getCellAsString(5).orElse(null));
                    // saude.setNomeRegiaoSaude(r.getCellAsString(6).orElse(null));
                    // saude.setData(r.getCellAsDate(7).orElse(null).toLocalDate());
                    // saude.setSemanaEpi(r.getCellAsNumber(8).orElse(BigDecimal.ZERO).intValue());
                    // saude.setPopulacaoTCU2019(r.getCellAsNumber(9).orElse(BigDecimal.ZERO).longValue());
                    // saude.setCasosNovos(r.getCellAsNumber(10).orElse(BigDecimal.ZERO).longValue());
                    // saude.setObitosAcumulado(r.getCellAsNumber(11).orElse(BigDecimal.ZERO).longValue());
                    // saude.setObitosNovos(r.getCellAsNumber(12).orElse(BigDecimal.ZERO).longValue());
                    // saude.setRecuperadosNovos(r.getCellAsNumber(13).orElse(BigDecimal.ZERO).longValue());
                    // saude.setEmAcompanhamentoNovos(r.getCellAsString(14).orElse(null));


                    logger.info(saude.toString());

                    listSaude.add(saude);
                });
            }
        }
        
        logger.info("Reader finalizado com sucesso");
        logger.info("******************");
        return listSaude;

    }

}