package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {
    public void ReadCSV(List<Double> debetArray, List<Double> kreditArray) {
        String csvFile = "test.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Read the header line to determine the column indices
            String header = br.readLine();
            String[] headers = header.split(";");
            int debetIndex = -1;
            int kreditIndex = -1;

            // Find the indices of the desired columns
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equalsIgnoreCase("Debet")) {
                    debetIndex = i;
                } else if (headers[i].equalsIgnoreCase("Kredit")) {
                    kreditIndex = i;
                }
            }

            if (debetIndex == -1 || kreditIndex == -1) {
                System.err.println("Columns 'Debet' and 'Kredit' not found in the CSV file.");
                return;
            }

            // Read and save the specified columns into array
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length > debetIndex && data.length > kreditIndex) {
                    String debet = data[debetIndex].trim();
                    String kredit = data[kreditIndex].trim();

                    Functions functions = new Functions();
                    functions.CleanNumbers(debetArray, debet);
                    functions.CleanNumbers(kreditArray, kredit);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
