import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Array para armazenar os itens
        String[] itens = new String[10];
        double[] valores = new double[10];

        // Leitura dos itens e valores
        for (int i = 0; i < 10; i++) {
            System.out.print("Digite o nome do item " + (i + 1) + ": ");
            itens[i] = scanner.nextLine();

            System.out.print("Digite o valor do item " + (i + 1) + ": ");
            valores[i] = scanner.nextDouble();
            scanner.nextLine(); // Consumir a quebra de linha pendente
        }

        // Salvando os itens e valores no arquivo
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("itens_supermercado.txt"));

            for (int i = 0; i < 10; i++) {
                writer.write(itens[i] + "," + valores[i]);
                writer.newLine();
            }

            writer.close();
            System.out.println("Itens de supermercado salvos com sucesso no arquivo itens_supermercado.txt!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os itens de supermercado: " + e.getMessage());
        }

        scanner.close();
    }
}
