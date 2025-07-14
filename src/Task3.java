package codes.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    private static final String SERIAL_FILE = "arquivos_entrada_e_saida/serieParaRelatorio.txt";
    private static final String COUNTRIES_FILE = "arquivos_entrada_e_saida/paises.txt";
    private static final String OUTPUT_FILE = "arquivos_entrada_e_saida/listaTotais.txt";
    private final FileManager fileManager = new FileManager();

    public void run() throws IOException {
        // Lê e analisa o arquivo de países em um mapa
        Map<String, String> countryMap = new HashMap<>();
        List<String> countryLines = fileManager.readLines(COUNTRIES_FILE);
        // A primeira linha é um cabeçalho e é ignorada.
        for (int i = 1; i < countryLines.size(); i++) {
            String line = countryLines.get(i);
            String[] parts = line.split(";");
            if (parts.length >= 2) {
                countryMap.put(parts[0], parts[1]);
            }
        }

        // Lê e processa o arquivo de números de série
        Map<String, Integer> carCounts = new HashMap<>();
        List<String> serialLines = fileManager.readLines(SERIAL_FILE);
        for (String line : serialLines) {
            String serialBlock = line.substring(0, 14);
            char vehicleType = serialBlock.charAt(9);
            if (vehicleType == 'A') {
                // O código do país é um bloco de três caracteres a partir do índice 4.
                String countryCode = serialBlock.substring(4, 7);
                // Incrementa a contagem para o código do país correspondente.
                carCounts.put(countryCode, carCounts.getOrDefault(countryCode, 0) + 1);
            }
        }

        // Gera as linhas do relatório
        List<String> reportLines = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : carCounts.entrySet()) {
            String countryCode = entry.getKey();
            Integer count = entry.getValue();
            reportLines.add(countryCode + "-" + count);
        }

        Collections.sort(reportLines);

        // Escreve no arquivo de saída
        fileManager.writeLines(OUTPUT_FILE, reportLines);
        System.out.println("Tarefa 3 concluída. Saída escrita em " + OUTPUT_FILE);
    }
}