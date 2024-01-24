package org.example.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringHelper {
    public static String urlToCB = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    public static String formatCurrentDateForRequest() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dateTimeFormatter.format(now);
        return currentDate;
    }

    public static String buildFilename() {
        DateTimeFormatter dateTimeFormatterForFile = DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String currentDateForFile = dateTimeFormatterForFile.format(now);
        final String FILE_NAME = "src/main/files/" + "request-" + currentDateForFile + ".json";
        return FILE_NAME;
    }
}
