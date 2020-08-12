package com.mghimire.myapp.presenter.config;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.mghimire.myapp.data.db.jpa.entities"})
@EnableJpaRepositories(basePackages = {"com.mghimire.myapp.data.db.jpa.repositories"})
public class DBConfig {

  @Bean
  public DataSource dataSource() {
    String dbUrl = System.getenv("PG_DB_URL");
    String dbUserName = System.getenv("PG_DB_USERNAME");
    String dbPassword = System.getenv("PG_DB_PASSWORD");

    if (dbUrl == null || dbUserName == null || dbPassword == null)
      throw new IllegalArgumentException(
          "Invalid configuration for database!" +
              " Check PG_DB_URL, PG_DB_USERNAME, PG_DB_PASSWORD" +
              " environment variables"
      );

    return DataSourceBuilder.create()
        .url(dbUrl)
        .username(dbUserName)
        .password(dbPassword)
        .build();
  }
}
