package com.anup.pollingApp.springBootPollingApplication.util;

import org.springframework.http.HttpStatus;

/**
 * Created by Anup Kumar Singh - 2025
 */

public class ErrorInfo {
    private final HttpStatus status;
    private final int code;
    private final String url;
    private final String errorMessage;

    public ErrorInfo(HttpStatus status, String url, String errorMessage) {
        this.status = status;
        this.code = status.value();
        this.url = url;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getCode() {
        return code;
    }
}
