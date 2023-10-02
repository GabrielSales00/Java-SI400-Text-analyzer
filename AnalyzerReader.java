/*                  Atividade em grupo: Text Analyzer

AnalyzerReader: leitura e tokenização de um arquivo de entrada, carga de uma estrutura de
dados que represente internamente o dígrafo gerado a partir do texto e tratamentos de
exceções; */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
                        Collections.sort(dygraph.get(source)); // Sort the destinations alphabetically
                    }
                }
            }
        }
    }

    public Map<String, List<String>> getDygraph() {
        return dygraph;
    }
}
