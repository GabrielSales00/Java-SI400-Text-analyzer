/*                  Atividade em grupo: Text Analyzer

AnalyzerReader: leitura e tokenização de um arquivo de entrada, carga de uma estrutura de
dados que represente internamente o dígrafo gerado a partir do texto e tratamentos de
exceções; */

import java.io.*;
import java.util.*;


public class AnalyzerReader {
    //Estruturas de dados pedidas
    private Map<String, List<String>> digrafo;

    public AnalyzerReader() {
        this.digrafo = new HashMap<>();
    }

    public void ProcessarTexto(String Nome) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(Nome))) {
            String linhaAtual;
            String anterior = null;

            while ((linhaAtual = br.readLine()) != null) {
                linhaAtual = linhaAtual.toLowerCase().replaceAll("[^a-zA-Z ]", ""); 
                StringTokenizer tokenizer = new StringTokenizer(linhaAtual);

                while (tokenizer.hasMoreTokens()) {
                    String elemento = tokenizer.nextToken();
                    anterior = elemento;
                }
            }
        }
    }
    public Map<String, List<String>> getdigrafo() {
        return digrafo;
    }
}