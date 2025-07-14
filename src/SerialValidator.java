package codes.src;

public class SerialValidator {

    /**
     * Calcula o dígito verificador para um dado bloco de 14 caracteres do número de série.
     * O dígito é a representação hexadecimal da soma dos valores ASCII
     * dos caracteres, módulo 16.
     *
     * @param serialNumberBlock O bloco de 14 caracteres do número de série.
     * @return O caractere do dígito verificador calculado.
     */
    public char calculateCheckDigit(String serialNumberBlock) {
        int sum = 0;
        // Soma os valores ASCII dos 14 primeiros caracteres.
        for (char c : serialNumberBlock.toCharArray()) {
            sum += (int) c;
        }

        // Calcula o resto da divisão da soma por 16.
        int remainder = sum % 16;

        // Converte o resto para sua representação hexadecimal.
        if (remainder < 10) {
            return (char) ('0' + remainder);
        } else {
            return (char) ('A' + (remainder - 10));
        }
    }

    /**
     * Verifica se o dígito verificador de um número de série completo está correto.
     *
     * @param completeSerialNumber Um número de série completo com o dígito verificador (ex: 2122BRAXXA3348-F).
     * @return true se o dígito verificador estiver correto, false caso contrário.
     */
    public boolean verify(String completeSerialNumber) {
        // Divide a string para separar o bloco de 14 caracteres e o dígito verificador.
        String[] parts = completeSerialNumber.split("-");
        if (parts.length != 2) {
            return false; // Formato inválido
        }

        String serialNumberBlock = parts[0];
        char givenCheckDigit = parts[1].charAt(0);

        char calculatedCheckDigit = calculateCheckDigit(serialNumberBlock);

        // Compara o dígito calculado com o dígito fornecido no número de série.
        return calculatedCheckDigit == givenCheckDigit;
    }
}