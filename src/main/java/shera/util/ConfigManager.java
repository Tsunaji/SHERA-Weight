package main.java.shera.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private String hostServerAPI;

    public ConfigManager() {
        File configFile = new File("src/main/resources/config/config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            this.hostServerAPI = props.getProperty("host.server.api");

            reader.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            System.out.println(ex);
        } catch (IOException ex) {
            // I/O error
            System.out.println(ex);
        }
    }

    public String getHostServerAPI() {
        return hostServerAPI;
    }

}
