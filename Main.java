import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Funcoes.*;
import Class.*;

/**
 * Classe principal do sistema de gerenciamento de biblioteca.
 * Permite adicionar, remover, listar e pesquisar livros através de uma interface de console.
 */


public class Main {
    private static boolean VerificarBilioteca(HashMap<Autor, ArrayList<Material>> hashMap, String texto) {
        if (hashMap.isEmpty()) {
            System.out.println(texto);
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String menu = "=".repeat(30) +
                "\nSistema De Biblioteca\n" +
                "=".repeat(30) +
                """
                
                1) Adicionar autor e livro
                2) Adicionar livro
                3) Adiconar autoria e revista
                4) Adicionar Revista
                5) Remover material
                6) Pesquisar livro por titulo
                7) Pesquisar livros por autor
                8) Listar livros
                9) Listar Revistas
                10) Listar tudo
                11) Sair
                """;

        HashMap<Autor, ArrayList<Material>> biblioteca = new HashMap<>();

        int opcao = -1;
        boolean verificarBiblioteca = false;
        while (opcao != 11) {
            System.out.println(menu);

            opcao = FuncoesVerificacoes.VerificarInteiroComIntervalo("Digite sua opcao: ", 1, 11);

            switch (opcao) {
                case 1:
                    FuncoesGerenciamento.adicionarAutorELivro(scan, biblioteca);
                    break;
                case 2:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na bilioteca. Use a opcao 1 " +
                            "primeiro");
                    if (verificarBiblioteca) {
                        FuncoesGerenciamento.inserirLivroNaLista(scan, biblioteca);
                    } else {
                        break;
                    }

                    break;

                case 3:
                    FuncoesGerenciamento.adicionarAutoriaERevista(scan, biblioteca);
                    break;

                case 4:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na bilioteca. Use a opcao 1 " +
                            "primeiro");
                    if (verificarBiblioteca) {
                        FuncoesGerenciamento.inserirRevista(scan, biblioteca);
                    } else {
                        break;
                    }

                    break;

                case 5:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha livros na biblioteca");
                    if (verificarBiblioteca) {
                        // FuncoesGerenciamento.RemoverLivro(biblioteca, scan);
                    } else {
                        break;

                    }

                    break;

                case 6:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha livros na biblioteca");
                    if (verificarBiblioteca) {
                        //FuncoesGerenciamento.PesquisarLivroPorTitulo(biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine(); // Espera o usuário pressionar Enter
                    }
                    break;

                case 7:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na biblioteca");
                    if (verificarBiblioteca) {
                        //FuncoesGerenciamento.PesquisarLivroPorAutor(biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine(); // Espera o usuário pressionar Enter
                    }
                    break;

                case 8:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores ou livros na biblioteca");
                    if (verificarBiblioteca) {
                        // FuncoesGerenciamento.ListarLivros(biblioteca, scan);
                    } else {
                        break;
                    }

                    break;

                // case 9:
                    // adicionar verificacao para caso a biblioteca esteja vazia
                    // Funcao de listar Revistar
                // case 10:
                    // Adicionar verificacao para caso a biblioteca esteja vazia
                    // Funcao de Listar tudo -> revistas e livros

                case 11:
                    System.out.println("Saindo do programa...");
                    scan.close();
                    break;

                default:
                    System.out.println("Opcao invalida");

            }
        }


    }
}
