package com.emma.gaviria.bankapp.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
        "com.emma.gaviria.bankapp.infrastructure.adapters.output.persistence.*"
})
@ComponentScan(basePackages = { "com.emma.gaviria.bankapp.*" })
@EntityScan("com.emma.gaviria.bankapp.*")
@PropertySource("classpath:application-integrationtest.properties")
@EnableTransactionManagement
public class H2JpaConfig {

    @Bean
    @Profile("test")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("sa");
        dataSource.setPassword("sa");

        return dataSource;
    }
}