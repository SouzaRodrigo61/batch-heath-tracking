package br.com.lifetracking.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.BrasilCovid;
import br.com.lifetracking.models.CovidSaude;
import br.com.lifetracking.util.ColumnStrategy;
import br.com.lifetracking.util.CurrentDate;


public class StepReader {
    
    
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    private static final String fileName = "/tmp/brasil_covid.xlsx";
    
    public static List<CovidSaude> readerByUrl() throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader: " + Instant.now().toString());
                
        File excelFile = new File(fileName);
        InputStream stream = new FileInputStream(excelFile);
        List<CovidSaude> listSaude = Poiji.fromExcel(stream, PoijiExcelType.XLSX, CovidSaude.class);
        
        
        logger.info("Reader finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");
        return listSaude;

    }

    @SuppressWarnings({"unchecked"})
    public static List<BrasilCovid> readerCSV() throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader: " + Instant.now().toString());

        LocalDate dateTime = CurrentDate.currentDate();
        logger.info("Data formatada: " + dateTime);
        String dir = "/Users/rodrigo/Documents/Rodrigo/batch-life-tracking/src/main/resources/tmp/brasil_" + dateTime
                + ".csv";

        CsvToBeanBuilder<BrasilCovid> csvToBeanBuilder = new CsvToBeanBuilder<BrasilCovid>(new FileReader(dir));

        List<BrasilCovid> casos = csvToBeanBuilder.withMappingStrategy(ColumnStrategy.setColumMapping()).build()
                .parse();

        logger.info("Reader finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");

        return casos;
    }
    
    @SuppressWarnings({"unchecked"})
    public static List<BrasilCovid> readerByDAte(LocalDate date) throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader: " + Instant.now().toString());

        LocalDate dateTime = date;
        logger.info("Data formatada: " + dateTime);
        String dir = "/Users/rodrigo/Documents/Rodrigo/batch-life-tracking/src/main/resources/tmp/brasil_" + dateTime + ".csv";
                
        CsvToBeanBuilder<BrasilCovid> csvToBeanBuilder = new CsvToBeanBuilder<BrasilCovid>(
                new FileReader(dir));
            
        List<BrasilCovid> casos = csvToBeanBuilder
                .withMappingStrategy(ColumnStrategy.setColumMapping()).build().parse();
                

        logger.info("Reader finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");

        return casos;
    }


}