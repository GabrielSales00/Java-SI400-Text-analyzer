import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyzerController {
    public void processFile(String inputFileName, String outputFileName) {
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

