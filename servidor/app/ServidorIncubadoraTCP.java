package app;

import app.server.Server;
import models.DTOS.DepencyDto;

import java.util.Properties;
import helpers.ConfigLoader;

public class ServidorIncubadoraTCP {

    public static void main(String[] args) {
        Properties props = ConfigLoader.load();
        int port = Integer.parseInt(props.getProperty("server.port"));
        DepencyDto depency = new DepencyDto(port);

        Server server = new Server(depency);
        server.start();
    }

}
