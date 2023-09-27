package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Double> debetArray = new ArrayList<>();
        List<Double> kreditArray = new ArrayList<>();

        CSVReader csvReader = new CSVReader();
        csvReader.ReadCSV(debetArray, kreditArray);

        Functions functions = new Functions();
        functions.CheckListsForMatches(debetArray, kreditArray);

        functions.createCSVFile("NewFile.csv", debetArray, kreditArray);
    }
}