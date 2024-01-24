package org.example.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ConnectionHelper {
    public static HttpURLConnection openConnection(String url) {
        URL responseObject = null;
        try {
            responseObject = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) responseObject.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
