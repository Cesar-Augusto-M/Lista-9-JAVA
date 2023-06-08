import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ProgramaDeViagem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha pendente

        System.out.print("Digite seu CPF: ");
        String cpf = scanner.nextLine();

        System.out.println("\nDestinos disponíveis:");
        System.out.println("1. São Paulo");
        System.out.println("2. Nova York");
        System.out.println("3. Berlim");
        System.out.print("Escolha o número do destino desejado: ");
        int destino = scanner.nextInt();
        scanner.close();

        String nomeDestino;
        int valorPassagem;
        switch (destino) {
            case 1:
                nomeDestino = "São Paulo";
                valorPassagem = 250;
                break;
            case 2:
                nomeDestino = "Nova York";
                valorPassagem = 2400;
                break;
            case 3:
                nomeDestino = "Berlim";
                valorPassagem = 3800;
                break;
            default:
                System.out.println("Opção inválida. Saindo do programa.");
                return;
        }

        int numeroPoltrona = gerarNumeroPoltrona();

        System.out.println("\nRecibo de Viagem:");
        System.out.println("-----------------");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("CPF: " + cpf);
        System.out.println("Destino: " + nomeDestino);
        System.out.println("Valor da passagem: $" + valorPassagem);
        System.out.println("Número da poltrona: " + numeroPoltrona);

        // Escrever os dados no arquivo recibo_viagem.txt
        try {
            FileWriter fileWriter = new FileWriter("recibo_viagem.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Recibo de Viagem:");
            printWriter.println("-----------------");
            printWriter.println("Nome: " + nome);
            printWriter.println("Idade: " + idade);
            printWriter.println("CPF: " + cpf);
            printWriter.println("Destino: " + nomeDestino);
            printWriter.println("Valor da passagem: $" + valorPassagem);
            printWriter.println("Número da poltrona: " + numeroPoltrona);
            printWriter.close();
            System.out.println("\nRecibo salvo no arquivo recibo_viagem.txt");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo. " + e.getMessage());
        }
    }

    public static int gerarNumeroPoltrona() {
        Random random = new Random();
        return random.nextInt(20) + 1;
    }
}
