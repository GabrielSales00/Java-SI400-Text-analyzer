public class AnalyzerStart {
    public static void main(String[] args) {

        if (args.length != 2) {
            // Print an error message
            System.err.println("Uso incorreto. O programa requer dois argumentos: nome do arquivo de entrada e nome do arquivo de saída.");
            // Exit the program with a non-zero status code (indicating an error)
            System.exit(1);
        }

        // Extract the input and output file names from command-line arguments
        String inputFileName = args[0];
        String outputFileName = args[1];

        // Create an instance of the AnalyzerController class
        AnalyzerController controller = new AnalyzerController();

        // Call the processFile method of the AnalyzerController to perform file processing
        controller.processFile(inputFileName, outputFileName);
    }
}

