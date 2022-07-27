package com.bracso.demo.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "com.bracso.demo.jdbc.repo1", jdbcOperationsRef = "ds1JdbcOperations")
public class Repo1Configuration {

}
