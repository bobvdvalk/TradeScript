package nl.mawoo.tradescript.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
public class Service {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Service.class, args);
        // Read scripts that are found in the database
        //context.getBean(AppConfig.class).runWorkspace();
    }
}
