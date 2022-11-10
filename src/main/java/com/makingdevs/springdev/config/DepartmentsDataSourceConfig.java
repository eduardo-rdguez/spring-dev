package com.makingdevs.springdev.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
  basePackages = "com.makingdevs.springdev.repository.departments",
  entityManagerFactoryRef = "departmentsEntityManagerFactory",
  transactionManagerRef = "departmentsTransactionManager"
)
public class DepartmentsDataSourceConfig {

  @Bean
  @ConfigurationProperties("spring.datasource.departments")
  public DataSource departmentsDataSource() {
    return DataSourceBuilder.create().type(HikariDataSource.class).build();
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean departmentsEntityManagerFactory(
    EntityManagerFactoryBuilder builder
  ) {
    return builder
      .dataSource(departmentsDataSource())
      .packages("com.makingdevs.springdev.domain.departments")
      .build();
  }

  @Bean
  PlatformTransactionManager departmentsTransactionManager(
    @Qualifier("departmentsEntityManagerFactory") LocalContainerEntityManagerFactoryBean departmentsEntityManagerFactory
  ) {
    return new JpaTransactionManager(
      Objects.requireNonNull(departmentsEntityManagerFactory.getObject())
    );
  }

}
