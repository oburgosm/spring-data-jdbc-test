# spring-data-jdbc-test

Project to test spring-data-jdbc with several datasources

You can test the project running `mvn clean install `

There are two repositories, each one configured with a different datasource, but the test fail, because one repository is using the other datasource, not the datasource configured for it in *jdbcOperationsRef*  attribute from `@EnableJdbcRepositories`
