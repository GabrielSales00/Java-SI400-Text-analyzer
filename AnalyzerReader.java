/*                  Text Analyzer

AnalyzerReader: reads and tokenizes an entry file, loads a data structure that represents a dygraph generated from its text and handles exceptions. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AnalyzerReader {
    private Map<String, List<String>> dygraph;

    public AnalyzerReader() {
        this.dygraph = new TreeMap<>();
    }

    public void processText(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String currentLine;

            while ((currentLine = br.readLine()) != null) {
                currentLine = currentLine.toLowerCase().replaceAll("[^a-záãàéíóúñ ]", "");
                String[] words = currentLine.split("\\s+");

                for (int i = 0; i < words.length - 1; i++) {
                    String source = words[i];
                    String destination = words[i + 1];

                    dygraph.putIfAbsent(source, new ArrayList<>());

                    if (!dygraph.get(source).contains(destination)) {
                        dygraph.get(source).add(destination);
                        Collections.sort(dygraph.get(source)); // Sorts the destinations alphabetically
                    }
                }
            }
        }
    }

    public Map<String, List<String>> getDygraph() {
        return dygraph;
    }
}
