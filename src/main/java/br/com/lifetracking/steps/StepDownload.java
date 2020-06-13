package br.com.lifetracking.steps;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.lifetracking.util.CurrentDate;


//
public class StepDownload {

    private static Logger logger = LoggerFactory.getLogger(StepReader.class);

    public static void downloadFileByUrl(String url) throws MalformedURLException, IOException {

        logger.info("******************");
        logger.info("Inicio do download");

        LocalDateTime agora = LocalDateTime.now();

        logger.info("Data processamento: " + agora);

        final URL urlDownload = new URL(url);
        final File file = new File("/tmp/brasil_covid.xlsx");

        FileUtils.copyURLToFile(urlDownload, file);

        logger.info("Download realizado com sucesso");
        logger.info("******************");
        return;
    }

    public static void downloadFile() throws MalformedURLException, IOException {

        logger.info("******************");
        logger.info("Inicio do download");

        LocalDate dateTime = CurrentDate.currentDate();
        logger.info("Data formatada: " + dateTime);

        final URL urlDownload = new URL("https://brasil.io/dataset/covid19/caso_full/?date=" + dateTime + "&format=csv");
        final File file = new File("/Users/rodrigo/Documents/Rodrigo/batch-life-tracking/src/main/resources/tmp/brasil_" + dateTime + ".csv");
        
        FileUtils.copyURLToFile(urlDownload, file);

        logger.info("Download realizado com sucesso");
        logger.info("******************");
    }

}