package com.github.lost.izalith.telegram.bot.sdk;

import com.github.lost.izalith.telegram.bot.sdk.http.client.SimpleHttpClient;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class Main {
    public static void main(final String... args) {
        System.out.println("# telegram-bot-sdk");

        final String token = "bottoken";
        final String urlString = "https://api.telegram.org/" + token + "/getMe";

        final SimpleHttpClient httpClient = new SimpleHttpClient(urlString);
        final String content = httpClient.getRequest();

        System.out.println(content);

        final JsonReader reader = Json.createReader(new StringReader(content));

        final JsonObject jsonObject = reader.readObject();

        System.out.println(jsonObject);
        System.out.println(jsonObject.get("ok").toString());
    }
}
