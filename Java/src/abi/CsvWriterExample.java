package abi;

import java.io.FileWriter;
import java.io.IOException;

public class CsvWriterExample {

    public static void main(String[] args) {
        String csvFile = "C:\\\\Users\\\\khari\\\\eclipse-workspace\\\\Java\\\\src\\\\example.csv";
        String[] headers = {"Name", "Age", "City"};
        String[] row1 = {"John", "30", "New York"};
        String[] row2 = {"Alice", "25", "Los Angeles"};
        String[] row3 = {"Bob", "35", "Chicago"};

        try (FileWriter writer = new FileWriter(csvFile)) {
            // Write CSV headers
            for (String header : headers) {
                writer.append(header);
                writer.append(",");
            }
            writer.append(System.lineSeparator());

            // Write CSV rows
            writeRow(writer, row1);
            writeRow(writer, row2);
            writeRow(writer, row3);

            System.out.println("CSV file has been written successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeRow(FileWriter writer, String[] row) throws IOException {
        for (String cell : row) {
            writer.append(cell);
            writer.append(",");
        }
        writer.append(System.lineSeparator());
    }
}