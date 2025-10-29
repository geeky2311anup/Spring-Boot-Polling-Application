package com.anup.pollingApp.springBootPollingApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Anup Kumar Singh - 2025
 */

@SpringBootApplication
@EnableCaching
public class SpringBootPollingApplication {

    public static void main(String[] args) {
      SpringApplication.run(SpringBootPollingApplication.class, args);
    }
}
