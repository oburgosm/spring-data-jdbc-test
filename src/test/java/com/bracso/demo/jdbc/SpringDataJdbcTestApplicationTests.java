package com.bracso.demo.jdbc;

import com.bracso.demo.jdbc.repo1.PersonRepository;
import com.bracso.demo.jdbc.repo2.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringDataJdbcTestApplicationTests {

  @Autowired
  PersonRepository personRepository;
  
  @Autowired
  ProductRepository productRepository;

  @Test
  void contextLoads() {
  }
  
  @Test
  void testPersonRepository() {
    this.personRepository.count();
  }
  
  @Test
  void testProductRepository() {
    this.productRepository.count();
  }

}
