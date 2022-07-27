package com.bracso.demo.jdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@Configuration
@EnableJdbcRepositories(basePackages = "com.bracso.demo.jdbc.repo2", jdbcOperationsRef = "ds2JdbcOperations")
public class Repo2Configuration {

}
