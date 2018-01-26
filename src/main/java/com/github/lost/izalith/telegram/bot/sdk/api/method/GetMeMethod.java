package com.github.lost.izalith.telegram.bot.sdk.api.method;

import com.github.lost.izalith.telegram.bot.sdk.api.TelegramBotApiMethods;
import com.github.lost.izalith.telegram.bot.sdk.api.URLBuilder;
import com.github.lost.izalith.telegram.bot.sdk.http.client.SimpleHttpClient;

public class GetMeMethod {

    public String getMe() {
        final String token = System.getenv("TELEGRAM_BOT_API_TOKEN");
        final URLBuilder urlBuilder = new URLBuilder(token);
        final String uri = urlBuilder.getUri();

        final String urlString = uri + TelegramBotApiMethods.GET_ME;

        final SimpleHttpClient httpClient = new SimpleHttpClient(urlString);

        return httpClient.getRequest();
    }
}
