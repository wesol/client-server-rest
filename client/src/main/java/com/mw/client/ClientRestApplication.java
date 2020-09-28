package com.mw.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:config.properties")
@SpringBootApplication
public class ClientRestApplication {

  public static void main(String[] args) {
    SpringApplication.run(ClientRestApplication.class, args);
  }

}
