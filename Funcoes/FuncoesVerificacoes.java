package Funcoes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import Class.*;

public class FuncoesVerificacoes {

    public static int VerificarInteiroComIntervalo(Scanner scanner, String texto, int minimo, int maximo) {
        boolean controleDeLoop = true;
        int numero = 0;
        do {
            System.out.print(texto);
            try {
                numero = scanner.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    controleDeLoop = false;
                } else {
                    System.out.printf("Opcao Invalida. Digite um numero entre %d e %d %n", minimo, maximo);
                }

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        scanner.nextLine();
        return numero;
    }

    public static int VerificarNumeroInt(Scanner scanner, String texto) {
        boolean controleDeLoop = true;
        int numero = 0;

        while (controleDeLoop) {
            System.out.print(texto);
            try {
                numero = scanner.nextInt();
                controleDeLoop = false;

            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }

        }
        return numero;
    }

    public static Autor verificaAutor(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap) {
        String nome = " ";
        boolean controleDeLoop = true;
        Autor autor = null;

        while (controleDeLoop) {
            System.out.print("Digite o nome do autor que deseja adicionar, deixe em branco para cancelar: ");
            nome = scanner.nextLine().strip();
            if (nome.isEmpty()) {
                return null;
            }
            String finalNome = nome;
            autor = hashMap.keySet().stream().
                    filter(NomeDoautor -> NomeDoautor.getNome().equalsIgnoreCase(finalNome)).findFirst().orElse(null);

            if (autor != null) {
                System.out.println("Autor esta na biblioteca");
                controleDeLoop = false;
            } else {
                System.out.println("Digite um autor da biblioteca ou deixe em branco");
            }

        }
        return autor;
    }


}
