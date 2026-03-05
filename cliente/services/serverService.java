package services;

import models.IncubadoraEstado;
import models.SensorData;
import java.io.*;

public class serverService {
    public static void  generateData(ObjectOutputStream out, ObjectInputStream in, int i) throws IOException, ClassNotFoundException, InterruptedException {
        SensorData data = SensorFactory.generarLectura();

                out.writeObject(data);
                out.flush();

                IncubadoraEstado respuesta = (IncubadoraEstado) in.readObject();

                System.out.println("Envío #" + (i + 1));
                System.out.println("Datos enviados: " + data);
                System.out.println("Respuesta servidor: " + respuesta);
                System.out.println("--------------------------");
    }
}
