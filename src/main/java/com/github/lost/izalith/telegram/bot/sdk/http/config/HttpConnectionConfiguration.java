package com.github.lost.izalith.telegram.bot.sdk.http.config;

public final class HttpConnectionConfiguration {

    private HttpConnectionConfiguration() {
        // avoid implementation due util class.
    }

    public static final String GET_REQUEST_METHOD = "GET";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String APPLICATION_JSON = "application/json";
    public static final Integer CONNECTION_TIMEOUT = 5000;
    public static final Integer READ_TIMEOUT = 5000;
}
