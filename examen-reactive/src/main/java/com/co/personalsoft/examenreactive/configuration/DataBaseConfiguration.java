package com.co.personalsoft.examenreactive.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;

@Configuration
@EnableR2dbcRepositories(basePackages = "com.co.personalsoft.examenreactive.models")
public class DataBaseConfiguration extends AbstractR2dbcConfiguration {
    @Override
    @Bean
    public ConnectionFactory connectionFactory() {
    	 return new H2ConnectionFactory(
                 H2ConnectionConfiguration.builder()
                         .url("mem:testdb;DB_CLOSE_DELAY=-1;TRACE_LEVEL_FILE=4")
                         .username("sa")
                         .build());
    }
    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
    	R2dbcTransactionManager r2dbcTransactionManager = new R2dbcTransactionManager(connectionFactory);
    	return r2dbcTransactionManager;
    }
}
