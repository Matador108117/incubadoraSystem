package helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    public static Properties load() {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream("resources/app.properties")) {

            props.load(input);

        } catch (Exception e) {
            System.out.println("No se encontró app.properties");
            e.printStackTrace();
        }

        return props;
    }
}