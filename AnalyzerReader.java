/*                  Atividade em grupo: Text Analyzer

AnalyzerReader: leitura e tokenização de um arquivo de entrada, carga de uma estrutura de
dados que represente internamente o dígrafo gerado a partir do texto e tratamentos de
exceções; */

import java.io.*;
import java.util.*;


public class AnalyzerReader {
    //Estruturas de dados pedidas
    private Map<String, List<String>> dygraph;

    public AnalyzerReader() {
        this.dygraph = new HashMap<>();
    }

    public void ProcessarTexto(String Nome) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(Nome))) {
            String currentLine;
            String formerLine = null;

            while ((currentLine = br.readLine()) != null) {
                currentLine = currentLine.toLowerCase().replaceAll("[^a-zA-Z ]", ""); 
                StringTokenizer tokenizer = new StringTokenizer(currentLine);

                while (tokenizer.hasMoreTokens()) {
                    String element = tokenizer.nextToken();
                    formerLine = element;
                }
            }
        }
    }
    public Map<String, List<String>> getdygraph() {
        return dygraph;
    }
}
