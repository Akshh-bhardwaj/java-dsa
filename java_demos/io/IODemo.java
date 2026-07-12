import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) {
        System.out.println("--- Java File I/O Demo ---");
        String filename = "notes_io_demo.txt";

        // 1. Writing to a File using Try-With-Resources (automatically closes resource)
        System.out.println("\nWriting payload to file: " + filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Line 1: Java File I/O Tutorial");
            writer.newLine();
            writer.write("Line 2: Demonstrating buffered operations.");
            writer.newLine();
            writer.write("Line 3: Finished writing.");
            System.out.println("Success! Write complete.");
        } catch (IOException e) {
            System.out.println("Error occurred during writing: " + e.getMessage());
        }

        // 2. Reading from the File
        System.out.println("\nReading payload from file: " + filename);
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read [" + (lineNumber++) + "]: " + line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred during reading: " + e.getMessage());
        }
    }
}
