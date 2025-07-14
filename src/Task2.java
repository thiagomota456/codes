package codes.src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final String INPUT_FILE = "serieParaVerificar.txt";
    private static final String OUTPUT_FILE = "serieVerificada.txt";
    private final FileManager fileManager = new FileManager();
    private final SerialValidator serialValidator = new SerialValidator();

    public void run() throws IOException {
        List<String> inputLines = fileManager.readLines(INPUT_FILE);
        List<String> outputLines = new ArrayList<>();
        for (String line : inputLines) {
            String completeSerial = line.trim();
            if (completeSerial.isEmpty()) continue;
            // Usa o método verify para verificar a validade do dígito verificador.
            boolean isValid = serialValidator.verify(completeSerial);
            String result = isValid ? "verdadeiro" : "falso";
            outputLines.add(completeSerial + " " + result);
        }
        fileManager.writeLines(OUTPUT_FILE, outputLines);
        System.out.println("Tarefa 2 concluída. Saída escrita em " + OUTPUT_FILE);
    }
}