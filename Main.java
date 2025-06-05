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
                
                1) Opcoes de Adicionar
                2) Remover material
                3) Opcoes de Pesquisar material
                4) Listagem
                5) Sair
                """;

        String menuDePesquisa = """
                1) Pesquisar livro por titulo
                2) Pesquisar livros por autor
                3) Pesquisar Revista por titulo
                4) Pesquisar Revista por autor
                """;

        String menuDeAdicicao = """
                1) Adicionar autor e livro
                2) Adicionar livro
                3) Adiconar autoria e revista
                4) Adicionar Revista
                """;

        String menuListagem = """
                1) Listar livros
                2) Listar Revistas
                3) Listar tudo
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
                        FuncoesGerenciamento.PesquisarLivroPorTitulo((HashMap) biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine(); // Espera o usuário pressionar Enter
                    }
                    break;

                case 7:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na biblioteca");
                    if (verificarBiblioteca) {
                        FuncoesGerenciamento.PesquisarLivroPorAutor((HashMap) biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine(); // Espera o usuário pressionar Enter
                    }
                    break;

                case 8:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores ou revistas na biblioteca");
                    if (verificarBiblioteca) {
                        FuncoesGerenciamento.PesquisarRevistaPorTitulo(biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine();
                    }
                    break;

                case 9:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores ou revistas na biblioteca");
                    if (verificarBiblioteca) {
                        FuncoesGerenciamento.PesquisarRevistaPorAutor(biblioteca, scan);
                        System.out.println("Pressione Enter para continuar...");
                        scan.nextLine();
                    }
                    break;

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
