package edu.miu.cs525.finalproject.banking;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "edu.miu.cs525.finalproject")
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = "edu.miu.cs525.finalproject.banking.repository")
@EnableTransactionManagement
public class AppConfig {
}
