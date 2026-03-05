package app.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import services.serverService;
import models.DTOS.DepencyDto;


public class Server {
    int port;
    public Server(DepencyDto depency) {
        this.port = depency.getPort();
    }
    
    
    public  void start(){
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Servidor de Incubadora iniciado...");

            while (true) {

                Socket cliente = serverSocket.accept();
                System.out.println("Cliente conectado: " + cliente.getInetAddress());

                new Thread(() -> serverService.manejarCliente(cliente)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
