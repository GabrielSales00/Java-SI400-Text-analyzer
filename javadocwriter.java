import java.io.*;
import java.util.*;

/**
 * A classe AnalyzerWriter é responsável por escrever os dados de um dígrafo em um arquivo CSV no formato Gephi.
 * Ela recebe o dígrafo gerado e cria um arquivo de saída com as relações entre as palavras.
 * @author  Grupo A4
 * @version 1.0
 */
public class AnalyzerWriter {
    private String outputFileName;

    /**
     * Cria uma instância de AnalyzerWriter com o nome do arquivo de saída especificado.
     *
     * @param outputFileName O nome do arquivo de saída onde os dados do dígrafo serão escritos no formato Gephi.
     * @since 1.0
     */
    public AnalyzerWriter(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    /**
     * Escreve os dados do dígrafo em um arquivo CSV no formato Gephi, indicando a sucessão de palavras.
     *
     * @param digraph Um mapa que representa um dígrafo, onde as chaves são as palavras de origem
     *                e os valores são listas de palavras de destino que seguem a palavra de origem.
     * @since 1.0
     * @exception IOException Lançada se ocorrer um erro durante a escrita do arquivo.
     */
    public void writeCSV(Map<String, List<String>> digraph) {
        // Implementação da escrita dos dados do dígrafo no arquivo CSV
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

                // Escreve no formato Gephi (separado por vírgula)
                String line = sourceWord + ", " + destinations.toString();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
