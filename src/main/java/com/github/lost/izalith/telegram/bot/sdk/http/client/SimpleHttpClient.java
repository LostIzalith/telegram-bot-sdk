package com.github.lost.izalith.telegram.bot.sdk.http.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.github.lost.izalith.telegram.bot.sdk.http.config.HttpConnectionConfiguration.APPLICATION_JSON;
import static com.github.lost.izalith.telegram.bot.sdk.http.config.HttpConnectionConfiguration.CONNECTION_TIMEOUT;
import static com.github.lost.izalith.telegram.bot.sdk.http.config.HttpConnectionConfiguration.CONTENT_TYPE;
import static com.github.lost.izalith.telegram.bot.sdk.http.config.HttpConnectionConfiguration.GET_REQUEST_METHOD;
import static com.github.lost.izalith.telegram.bot.sdk.http.config.HttpConnectionConfiguration.READ_TIMEOUT;

public class SimpleHttpClient {

    private final String urlString;

    public SimpleHttpClient(final String urlString) {
        this.urlString = urlString;
    }

    public String getRequest() {
        try {
            final URL url = new URL(this.urlString);
            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(GET_REQUEST_METHOD);
            connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);

            final InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String inputLine;
            final StringBuilder content = new StringBuilder();
            while ((inputLine = bufferedReader.readLine()) != null) {
                content.append(inputLine);
            }
            bufferedReader.close();

            connection.disconnect();

            return content.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
