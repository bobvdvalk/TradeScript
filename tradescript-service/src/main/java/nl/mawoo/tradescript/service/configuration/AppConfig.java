package nl.mawoo.tradescript.service.configuration;

import nl.mawoo.tradescript.service.services.Workspace;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:tradescript.properties")
public class AppConfig {

    /**
     * Read the configured workspace to load scripts from
     */
    @Value("${workspace}")
    private String workspace;
    
    @Bean
    public void RunWorkspace() {
        Workspace workspace = new Workspace(this.workspace);
        workspace.scanWorkspace();
    }

    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
