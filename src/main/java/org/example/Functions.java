package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Functions {
    public void CleanNumbers(List<Double> kreditArray, String input) {
        if (!input.isEmpty()) {
            if (input.contains(".")) {
                input = input.replace(".", "");
            }
            if (input.contains(",")) {
                input = input.replace(",", ".");
            }
            kreditArray.add(Double.parseDouble(input));
        }
    }

    public void CheckListsForMatches(List<Double> list1, List<Double> list2) {
        List<Double> toRemove1 = new ArrayList<>(list2);
        List<Double> toRemove2 = new ArrayList<>(list2);

        for (double num : list1) {
            if (list2.contains(num)) {
                toRemove1.add(num);
                toRemove2.add(num);
            }
        }

        list1.removeAll(toRemove1);
        list2.removeAll(toRemove2);
    }

    public boolean createCSVFile(String filename, List<Double> debet, List<Double> kredit) {
        try {
            // Create a FileWriter for the specified filename
            FileWriter csvWriter = new FileWriter(filename);

            // Write the header row
            csvWriter.append("Debet; Kredit\n");

            // Write data from both lists to the CSV file
            for (int i = 0; i < debet.size(); i++) {
                csvWriter.append(debet.get(i).toString())
                        .append(";");
                if (i < kredit.size()) {
                    csvWriter.append(kredit.get(i).toString());
                } else {
                    csvWriter.append("0");
                }
                csvWriter.append("\n");
            }

            // Close the FileWriter
            csvWriter.flush();
            csvWriter.close();

            System.out.println("CSV file '" + filename + "' created successfully.");
            return true;
        } catch (IOException e) {
            System.err.println("Error creating CSV file: " + e.getMessage());
            return false;
        }
    }
}