import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nomes = new String[5];
        double[] notas = new double[5];

        // Leitura dos nomes e notas
        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o nome do aluno " + (i + 1) + ": ");
            nomes[i] = scanner.nextLine();

            System.out.print("Digite a nota final do aluno " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            scanner.nextLine(); // Limpar o buffer do scanner
        }

        // Salvar os dados no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("alunos_universidade.txt"))) {
            for (int i = 0; i < 5; i++) {
                writer.write(nomes[i] + "," + notas[i]);
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso no arquivo alunos_universidade.txt!");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao salvar os dados no arquivo.");
            e.printStackTrace();
            scanner.close();
        }
    }
}
