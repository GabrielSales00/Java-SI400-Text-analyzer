public class AnalyzerStart {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso incorreto. O programa requer dois argumentos: nome do arquivo de entrada e nome do arquivo de saída.");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        AnalyzerController controller = new AnalyzerController();
        controller.processarArquivo(inputFileName, outputFileName);
    }
}
