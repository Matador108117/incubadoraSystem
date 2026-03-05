package app;
import java.util.Properties;
import helpers.ConfigLoader;
import server.Server;
import models.DTOS.DepencyDto;

public class app {
    public static void main(String[] args) {
         Properties props = ConfigLoader.load();
        int port = Integer.parseInt(props.getProperty("server.port"));
        int delay = Integer.parseInt(props.getProperty("server.delay"));
        int cycles = Integer.parseInt(props.getProperty("server.cycles"));
        String host = props.getProperty("server.host");
        DepencyDto depency = new DepencyDto(port, host, delay, cycles);
        Server server = new Server(depency);
        server.start();

    }
}
