package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import  models.DTOS.DepencyDto;
import services.serverService;
public class Server {
    private int port;
    private String host;
    private int delay;
    private int cycles;

    public Server(DepencyDto depency) {
        this.port = depency.getPort();
        this.host = depency.getHost();
        this.delay = depency.getDelay();
        this.cycles = depency.getCycles();
    }
    public void start(){
        for (int i = 0; i < cycles; i++) {

            try (
                    Socket socket = new Socket(host, port);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
            ) {
                serverService.generateData(out, in, i);

                Thread.sleep(delay);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
