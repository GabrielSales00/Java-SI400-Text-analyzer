import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * A classe AnalyzerReader é responsável por ler e tokenizar um arquivo de entrada, criar e manter
 * uma estrutura de dados interna que representa um dígrafo gerado a partir do texto e tratar exceçõeselacionadas à leitura.
 */
public class AnalyzerReader {
    private Map<String, List<String>> dygraph;

    /**
     * Cria uma instância de AnalyzerReader com uma estrutura de dados vazia para representar o dígrafo.
     */
    public AnalyzerReader() {
        this.dygraph = new TreeMap<>();
    }

    /**
     * Lê e pré-processa o arquivo de entrada de texto simples para construir um dígrafo que representa
     * a sucessão de palavras no texto.
     *
     * @param fileName O nome do arquivo de entrada contendo o texto a ser pré-processado.
     * @throws IOException Lançada se ocorrer um erro durante a leitura do arquivo.
     */
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
                        Collections.sort(dygraph.get(source)); // Ordena os destinos em ordem alfabética
                    }
                }
            }
        }
    }

    /**
     * Obtém a estrutura de dados que representa o dígrafo gerado a partir do texto.
     *
     * @return Um mapa onde as chaves são as palavras de origem e os valores são listas de palavras de destino
     *         que seguem a palavra de origem.
     */
    public Map<String, List<String>> getDygraph() {
        return dygraph;
    }
}
