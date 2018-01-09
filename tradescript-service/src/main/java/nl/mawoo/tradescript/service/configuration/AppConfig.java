package nl.mawoo.tradescript.service.configuration;

import nl.mawoo.tradescript.service.storage.ScriptDao;
import nl.mawoo.tradescript.service.workspace.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:tradescript.properties")
public class AppConfig {

    @Autowired
    private ScriptDao scriptDao;

    /**
     * Read the configured workspace to load scripts from
     */
    @Value("${workspace}")
    private String workspace;

    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Workspace runWorkspace() {
        scriptDao.deleteAll(); // delete existing data in the script table;
        Workspace workspace = new Workspace(scriptDao, this.workspace);
        workspace.scanWorkspace();
        workspace.save();
        return workspace;
    }
}
