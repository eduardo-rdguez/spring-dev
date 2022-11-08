package com.makingdevs.springdev.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.makingdevs.springdev.domain.courses.repository",
  entityManagerFactoryRef = "coursesEntityManagerFactory",
  transactionManagerRef = "coursesTransactionManager"
)
public class CoursesDataSourceConfig {

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource.courses")
  public DataSource coursesDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean coursesEntityManagerFactory(
    EntityManagerFactoryBuilder builder
  ) {
    return builder
      .dataSource(coursesDataSource())
      .packages("com.makingdevs.springdev.domain.courses.entity")
      .build();
  }

  @Bean
  @Primary
  PlatformTransactionManager coursesTransactionManager(
    @Qualifier("coursesEntityManagerFactory") LocalContainerEntityManagerFactoryBean coursesEntityManagerFactory
  ) {
    return new JpaTransactionManager(
      Objects.requireNonNull(coursesEntityManagerFactory.getObject())
    );
  }

}
