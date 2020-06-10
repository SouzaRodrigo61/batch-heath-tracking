package br.com.lifetracking.steps;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//
public class StepDownload {

    private static Logger logger = LoggerFactory.getLogger(StepReader.class);
    public static void downloadFile() throws MalformedURLException, IOException {
        
        logger.info("******************");
        logger.info("Inicio do download");
        final URL url = new URL("https://mobileapps.saude.gov.br/esus-vepi/files/unAFkcaNDeXajurGB7LChj8SgQYS2ptm/174da8da1ebd9a50098ac3293a2bd85f_HIST_PAINEL_COVIDBR_09jun2020.xlsx");
        final File file = new File("/tmp/brasil_covid.xlsx");

        FileUtils.copyURLToFile(url, file);
        
        logger.info("Download realizado com sucesso");
        logger.info("******************");
        return;
    }
}