package codes.src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Executando a Tarefa 1...");
            Task1 task1 = new Task1();
            task1.run();
            System.out.println("\nExecutando a Tarefa 2...");
            Task2 task2 = new Task2();
            task2.run();
            System.out.println("\nExecutando a Tarefa 3...");
            Task3 task3 = new Task3();
            task3.run();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro durante as operações de arquivo: " + e.getMessage());
        }
    }
}