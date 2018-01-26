package com.github.lost.izalith.telegram.bot.sdk.api;

public class URLBuilder {

    private static final String TELEGRAM_API_URL = "https://api.telegram.org/";

    private final String uri;

    public URLBuilder(final String token) {
        this.uri = TELEGRAM_API_URL + token;
    }

    public String getUri() {
        return uri;
    }
}
