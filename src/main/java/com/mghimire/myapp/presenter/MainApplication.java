package com.mghimire.myapp.presenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
  "com.mghimire.myapp.presenter",
  "com.mghimire.myapp.data.db.jpa"
})
public class MainApplication {

  public static void main(String[] args) {

    SpringApplication.run(MainApplication.class, args);

  }
}
