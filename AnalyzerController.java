import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyzerController {
    public void processFile(String inputFileName, String outputFileName) {
        // Create an instance of AnalyzerReader to read the input file
        AnalyzerReader reader = new AnalyzerReader();

        // Create an instance of AnalyzerWriter to write the output file
        AnalyzerWriter writer = new AnalyzerWriter(outputFileName);

        try {
             // Read and process the input text file
            reader.processText(inputFileName);
            Map<String, List<String>> digraph = reader.getDygraph();  // Get the digraph from the reader in order to pass to the writer

            // Write the digraph data to a CSV file
            writer.writeCSV(digraph);

            System.out.println("Processamento concluído. O arquivo CSV foi gerado com sucesso.");
        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante o processamento do arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
