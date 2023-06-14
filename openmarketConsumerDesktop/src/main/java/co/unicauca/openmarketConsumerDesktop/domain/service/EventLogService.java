package co.unicauca.openmarketConsumerDesktop.domain.service;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
public class EventLogService implements IEventLogService {
    private final File logFile;

    public EventLogService() {
        this.logFile = new File("productActionsCSV.csv");
        initializeFile();
    }

    public void initializeFile() {
        try {
            if (this.logFile.exists()) {
                System.out.println("El archivo productActionsCSV ya existe.");
            } else {
                this.logFile.createNewFile();
                System.out.println("Archivo productActionsCSV creado correctamente.");

                // Agrega las cabeceras al archivo recién creado
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile, true), StandardCharsets.UTF_8));
                CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("ACTION", "IDPRODUCT", "PRODUCT NAME", "PRICE", "DESCRIPTION");
                CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);
                csvPrinter.flush();
                csvPrinter.close();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String[] parseMessage(String message) {
        if (message.isEmpty()) {
            return null;
        }
        return message.split(",");
    }

    @Override
    public void appendRow(String[] processedMessage) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile, true), StandardCharsets.UTF_8));
            // Utiliza CSVFormat.DEFAULT sin cabeceras
            CSVFormat csvFormat = CSVFormat.DEFAULT;
            CSVPrinter csvPrinter = new CSVPrinter(writer, csvFormat);

            csvPrinter.printRecord(processedMessage[0], processedMessage[1], processedMessage[2], processedMessage[3], processedMessage[4]);

            csvPrinter.flush();
            csvPrinter.close();
            System.out.println("Datos almacenados correctamente en el archivo CSV");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
