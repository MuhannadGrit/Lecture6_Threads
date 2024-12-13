import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class FileLoggingExample {
    private static final Logger logger = Logger.getLogger(FileLoggingExample.class.getName());

    public static void main(String[] args) {
        try {
            // Skapa en FileHandler som loggar till en specifik fil
            FileHandler fileHandler = new FileHandler("application.log", true); // 'true' för att lägga till i filen istället för att skriva över

            // Använd en enkel formatterare för att formatera loggmeddelanden
            fileHandler.setFormatter(new SimpleFormatter());

            // Lägg till FileHandler till logger
            logger.addHandler(fileHandler);

            // Logga olika meddelanden
            logger.info("Programmet startade.");
            logger.warning("En varning! Något kan vara fel.");
            logger.severe("Ett allvarligt fel inträffade.");
            logger.info("Programmet avslutades.");

        } catch (IOException e) {
            System.out.println("Kunde inte skapa FileHandler: " + e.getMessage());
        }
    }
}
