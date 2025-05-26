package Funcoes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncoesVerificacoes {
    /**
     * Solicita um número inteiro dentro de um intervalo específico.
     *
     * @param texto  Mensagem de entrada a ser exibida.
     * @param minimo Valor mínimo permitido (inclusive).
     * @param maximo Valor máximo permitido (inclusive).
     * @return Um número inteiro dentro do intervalo definido.
     */
    public static int VerificarInteiroComIntervalo(String texto, int minimo, int maximo) {
        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        int numero = 0;
        do {
            System.out.print(texto);
            try {
                numero = scan.nextInt();
                if (numero >= minimo && numero <= maximo) {
                    controleDeLoop = false;
                } else {
                    System.out.printf("Opcao Invalida. Digite um numero entre %d e %d %n", minimo, maximo);
                }

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }
        } while (controleDeLoop);

        return numero;
    }

    public static int VerificarNumeroInt(String texto) {
        Scanner scan = new Scanner(System.in);
        boolean controleDeLoop = true;
        int numero = 0;

        while (controleDeLoop) {
            System.out.print(texto);
            try {
                numero = scan.nextInt();
                controleDeLoop = false;

            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Entrada invalida. Digite um numero");
            }

        }
        return numero;
    }

}
