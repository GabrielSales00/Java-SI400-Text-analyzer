/**
 * A classe AnalyzerStart é a classe de ponto de entrada para iniciar o programa de pré-processamento de texto
 * para análise como dígrafo no formato Gephi. Ela verifica os argumentos da linha de comando e inicia o processo
 * de pré-processamento do arquivo de entrada.
 */
public class AnalyzerStart {
    
    /**
     * O método principal é o ponto de entrada do programa.
     *
     * @param args Os argumentos da linha de comando. Deve conter dois argumentos: o nome do arquivo de entrada
     *             e o nome do arquivo de saída.
     * @since 1.0
     */
    public static void main(String[] args) {
        // Implementação do início do programa
        if (args.length != 2) {
            System.err.println("Uso incorreto. O programa requer dois argumentos: nome do arquivo de entrada e nome do arquivo de saída.");
            System.exit(1);
        }

        String inputFileName = args[0];
        String outputFileName = args[1];

        AnalyzerController controller = new AnalyzerController();
        controller.processFile(inputFileName, outputFileName);
    }
}
