package nl.mawoo.wcmmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * This class is responsible to run the Manager
 * This is build with the Spring framework
 *
 * @author Bob van der Valk
 */
@SpringBootApplication(exclude = MongoRepositoriesAutoConfiguration.class)
public class Manager {
    public static void main(String[] args) {
        SpringApplication.run(Manager.class, args);
    }
}
