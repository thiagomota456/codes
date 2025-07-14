package codes.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    private static final String INPUT_FILE = "serieSemDV.txt";
    private static final String OUTPUT_FILE = "serieComDV.txt";
    private final FileManager fileManager = new FileManager();
    private final SerialValidator serialValidator = new SerialValidator();

    public void run() throws IOException {
        List<String> inputLines = fileManager.readLines(INPUT_FILE);
        List<String> outputLines = new ArrayList<>();
        for (String line : inputLines) {
            String serialBlock = line.trim();
            if (serialBlock.isEmpty()) continue;
            // Os 14 primeiros caracteres formam o bloco a ser usado para o cálculo.
            char checkDigit = serialValidator.calculateCheckDigit(serialBlock.substring(0, 14));
            // Adiciona o hífen e o dígito verificador calculado.
            outputLines.add(serialBlock + "-" + checkDigit);
        }
        fileManager.writeLines(OUTPUT_FILE, outputLines);
        System.out.println("Tarefa 1 concluída. Saída escrita em " + OUTPUT_FILE);
    }
}