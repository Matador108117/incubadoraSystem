package app;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;
import server.Server;
import models.DTOS.DepencyDto;

public class app {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = app.class
                .getClassLoader()
                .getResourceAsStream("app.properties")) {

            if (input == null) {
                System.out.println("No se encontró app.properties");
                return;
            }

            properties.load(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
        DepencyDto depency = new DepencyDto(Integer.parseInt(properties.getProperty("server.port")),
                properties.getProperty("server.host"),
                Integer.parseInt(properties.getProperty("server.delay")),
                Integer.parseInt(properties.getProperty("server.cycles")));
        Server server = new Server(depency);
        server.start();

    }
}
