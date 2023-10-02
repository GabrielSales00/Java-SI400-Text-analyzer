/*                  Atividade em grupo: Text Analyzer

AnalyzerWriter: escrita em um arquivo do dígrafo carregado pela classe anterior 
em umaestrutura de dados e tratamento de exceções */

import java.io.*;
import java.util.*;

public class AnalyzerWriter {
    private String outputFileName;

    public AnalyzerWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void writeCSV(Map<String, List<String>> digraph) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Map.Entry<String, List<String>> entry : digraph.entrySet()) {
                String sourceWord = entry.getKey();
                List<String> destinationWords = entry.getValue();

                StringBuilder destinations = new StringBuilder();
                for (String destination : destinationWords) {
                    if (destinations.length() > 0) {
                        destinations.append(", "); // Use a comma to separate destinations
                    }
                    destinations.append(destination);
                }

                // Write in the Gephi format (comma-separated)
                String line = sourceWord + ", " + destinations.toString();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
