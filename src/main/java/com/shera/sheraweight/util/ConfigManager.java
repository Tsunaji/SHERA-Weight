package main.java.com.shera.sheraweight.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private String serverAPI;
    private String clientIP;

    public ConfigManager() {
        File configFile = new File("src/main/resources/config/config.properties");

        try {
            FileReader reader = new FileReader(configFile);
            Properties props = new Properties();
            props.load(reader);

            this.serverAPI = props.getProperty("server.api");
            this.clientIP = props.getProperty("client.ip");

            reader.close();
        } catch (FileNotFoundException ex) {
            // file does not exist
            System.out.println(ex);
        } catch (IOException ex) {
            // I/O error
            System.out.println(ex);
        }
    }

    public String getServerAPI() {
        return serverAPI;
    }

    public String getClientIP() {
        return clientIP;
    }
}
