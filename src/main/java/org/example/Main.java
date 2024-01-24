package org.example;

import org.example.utils.ConnectionHelper;
import org.example.utils.FileHelper;
import org.example.utils.JSONHelper;
import org.example.utils.StringHelper;
import org.json.JSONObject;
import org.json.XML;

import java.net.HttpURLConnection;

public class Main {
    public static void main(String[] args) {
        FileHelper.createFolderForFiles();

        String currentDate = StringHelper.formatCurrentDateForRequest();
        String url = StringHelper.urlToCB + currentDate;

        HttpURLConnection connection = ConnectionHelper.openConnection(url);

        StringBuffer response = FileHelper.writeXMLToString(connection);

        JSONObject jsonObject = XML.toJSONObject(response.toString());

        String prettyJson = JSONHelper.prettifyJSON(jsonObject);


        String fileName = StringHelper.buildFilename();
        FileHelper.createFile(fileName);

        FileHelper.writeJSONToFile(fileName, prettyJson);
    }

}
