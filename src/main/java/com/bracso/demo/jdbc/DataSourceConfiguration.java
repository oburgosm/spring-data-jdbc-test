package com.bracso.demo.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@Configuration
public class DataSourceConfiguration {

  @Bean
  @Primary
  @ConfigurationProperties("datasource.ds1")
  public DataSource ds1() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @ConfigurationProperties("datasource.ds2")
  public DataSource ds2() {
    return DataSourceBuilder.create().build();
  }

  @Bean
  @Primary
  public NamedParameterJdbcOperations ds1JdbcOperations(@Qualifier("ds1") DataSource sqlServerDs) {
    return new NamedParameterJdbcTemplate(sqlServerDs);
  }

  @Bean
  public NamedParameterJdbcOperations ds2JdbcOperations(@Qualifier("ds2") DataSource sqlServerDs) {
    return new NamedParameterJdbcTemplate(sqlServerDs);
  }

  @Bean
  public DataSourceScriptDatabaseInitializer ds1Initializer() {
    DatabaseInitializationSettings settings = new DatabaseInitializationSettings();
    List<String> schemaLocations = new ArrayList<>(1);
    schemaLocations.add("classpath:/schema-ds1.sql");
    settings.setSchemaLocations(schemaLocations);
    return new DataSourceScriptDatabaseInitializer(ds1(), settings);
  }

  @Bean
  public DataSourceScriptDatabaseInitializer ds2Initializer() {
    DatabaseInitializationSettings settings = new DatabaseInitializationSettings();
    List<String> schemaLocations = new ArrayList<>(1);
    schemaLocations.add("classpath:/schema-ds2.sql");
    settings.setSchemaLocations(schemaLocations);
    return new DataSourceScriptDatabaseInitializer(ds2(), settings);
  }

}
