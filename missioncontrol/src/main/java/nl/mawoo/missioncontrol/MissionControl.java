package nl.mawoo.missioncontrol;

import nl.mawoo.missioncontrol.services.Workspace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

public class MissionControl implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MissionControl.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MissionControl.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Workspace workspace = Workspace.init();
        LOGGER.info("Confirmed: "+ workspace.getFolder());
    }
}
