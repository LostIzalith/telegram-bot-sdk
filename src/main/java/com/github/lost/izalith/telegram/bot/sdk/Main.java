package com.github.lost.izalith.telegram.bot.sdk;

import com.github.lost.izalith.telegram.bot.sdk.http.client.SimpleHttpClient;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.StringReader;

public class Main {
    public static void main(final String... args) {
        System.out.println("# telegram-bot-sdk");

        final String content = apiGetMe();
        System.out.println(content);

        final JsonReader reader = Json.createReader(new StringReader(content));

        final JsonObject jsonObject = reader.readObject();

        System.out.println(jsonObject);
        System.out.println(jsonObject.get("ok").toString());

        System.out.println(apiGetMe());

        System.out.println(apiSendMessage("some message"));
    }

    private static String apiGetMe() {
        final String token = "token";
        final String getMe = "/getMe";
        final String urlString = "https://api.telegram.org/" + token + getMe;

        final SimpleHttpClient httpClient = new SimpleHttpClient(urlString);

        return httpClient.getRequest();
    }

    private static String apiSendMessage(final String message) {
        final String token = "token";
        final String sendMessage = "/sendMessage";
        final String urlString = "https://api.telegram.org/" + token + sendMessage + "?chat_id=86782202&text=" + message;

        final SimpleHttpClient httpClient = new SimpleHttpClient(urlString);

        return httpClient.getRequest();
    }
}
