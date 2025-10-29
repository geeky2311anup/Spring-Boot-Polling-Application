package com.anup.pollingApp.springBootPollingApplication.util.exceptions;

import org.springframework.lang.NonNull;

/**
 * Created by Anup Kumar Singh - 2025
 */

public class IllegalRequestDataException extends RuntimeException {
    public IllegalRequestDataException(@NonNull String msg) {
        super(msg);
    }
}