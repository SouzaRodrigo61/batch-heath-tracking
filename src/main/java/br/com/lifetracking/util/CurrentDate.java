package br.com.lifetracking.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {
    
    public static LocalDate currentDate() {

        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = dateFormatter();
        String dateString = agora.format(formatter);
        LocalDate dateTime = LocalDate.parse(dateString);

        return dateTime;
    }
    
    public static DateTimeFormatter dateFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return formatter;
    }
}