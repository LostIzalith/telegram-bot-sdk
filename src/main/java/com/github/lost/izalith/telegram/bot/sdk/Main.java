package com.github.lost.izalith.telegram.bot.sdk;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(final String... args) {
        System.out.println("# telegram-bot-sdk");

        final String token = "bottoken";
        final String urlString = "https://api.telegram.org/" + token + "/getMe";
        final String getRequestMethod = "GET";
        final String contentType = "Content-Type";
        final String applicationJson = "application/json";
        final Integer connectionTimeOut = 5000;
        final Integer readTimeOut = 5000;

        try {
            final URL url = new URL(urlString);

            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(getRequestMethod);
            connection.setRequestProperty(contentType, applicationJson);
            connection.setConnectTimeout(connectionTimeOut);
            connection.setReadTimeout(readTimeOut);

            final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            connection.disconnect();

            System.out.println(content.toString());

            final JsonReader reader = Json.createReader(new StringReader(content.toString()));

            final JsonObject jsonObject = reader.readObject();

            System.out.println(jsonObject);
            System.out.println(jsonObject.get("ok").toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
