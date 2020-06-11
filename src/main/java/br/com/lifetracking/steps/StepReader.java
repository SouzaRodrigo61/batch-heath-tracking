package br.com.lifetracking.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import com.poiji.bind.Poiji;
import com.poiji.exception.PoijiExcelType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.models.CovidSaude;


public class StepReader {
    
    
    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    private static final String fileName = "/tmp/brasil_covid.xlsx";
    
    public static List<CovidSaude> reader() throws IOException {

        logger.info("******************");
        logger.info("Iniciou o Reader: " + Instant.now().toString());
                
        File excelFile = new File(fileName);
        InputStream stream = new FileInputStream(excelFile);
        List<CovidSaude> listSaude = Poiji.fromExcel(stream, PoijiExcelType.XLSX, CovidSaude.class);
        
        
        logger.info("Reader finalizado com sucesso: " + Instant.now().toString());
        logger.info("******************");
        return listSaude;

    }

}