package app;

import app.server.Server;
import models.DTOS.DepencyDto;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ServidorIncubadoraTCP {

    public static void main(String[] args) {
        Properties properties = new Properties();

        try (InputStream input = ServidorIncubadoraTCP.class
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

        DepencyDto depency = new DepencyDto(Integer.parseInt(properties.getProperty("server.port")));

        Server server = new Server(depency);
        server.start();
    }

}
