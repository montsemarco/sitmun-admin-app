package org.sitmun.app.admin;

import org.sitmun.plugin.core.annotation.SitmunApplication;
import org.springframework.boot.SpringApplication;

@SitmunApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
