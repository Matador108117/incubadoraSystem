package services;

import models.SensorData;
import models.IncubadoraEstado;
import validation.*;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.List;

public class serverService {

    private static final ValidationChain validationChain =
            new ValidationChain(List.of(
                    new TemperatureValidator(),
                    new HumidityValidator(),
                    new OxygenValidator()
            ));

    public static void manejarCliente(Socket socket) {

        try (
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())
        ) {

            Object obj = in.readObject();

            // Validación de tipo
            new TypeValidator().validate(obj);

            SensorData data = (SensorData) obj;

            // Cadena de validaciones
            validationChain.validate(data);

            IncubadoraEstado estado = IncubadoraService.evaluar(data);

            System.out.println("IP: " + socket.getInetAddress());
            System.out.println("Fecha: " + LocalDateTime.now());
            System.out.println("Datos: " + data);
            System.out.println("Estado: " + estado);
            System.out.println("--------------------------------");

            out.writeObject(estado);

        } catch (ValidationException e) {

            System.out.println("Error de validación: " + e.getMessage());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}