import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * A classe AnalyzerController é responsável por controlar o processo de pré-processamento de texto
 * para análise como um dígrafo no formato Gephi. Ela lê o arquivo de entrada, cria um dígrafo a partir
 * das palavras sucessoras e escreve o resultado em um arquivo CSV.
 * @author  Grupo A4
 * @version 1.0
 */
public class AnalyzerController {

    /**
     * Inicia o processo de pré-processamento do arquivo de entrada e geração do dígrafo em formato CSV.
     *
     * @param inputFileName  O nome do arquivo de entrada a ser processado.
     * @param outputFileName O nome do arquivo de saída onde o dígrafo será gravado no formato CSV.
     * @since 1.0
     * @exception IOException Lançada se ocorrer um erro durante a leitura ou escrita do arquivo.
     */
    public void processFile(String inputFileName, String outputFileName) {
        // Implementação do processamento do arquivo e geração do dígrafo
        AnalyzerReader reader = new AnalyzerReader();
        AnalyzerWriter writer = new AnalyzerWriter(outputFileName);

        try {
            // Processar o arquivo de entrada
            reader.processText(inputFileName); // Correct method name
            Map<String, List<String>> digraph = reader.getDygraph(); // Correct method name

            // Escrever o dígrafo no arquivo CSV de saída
            writer.writeCSV(digraph);

            System.out.println("Processamento concluído. O arquivo CSV foi gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante o processamento do arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
