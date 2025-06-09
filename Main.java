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

    public static final String NAO_HA_MATERIAL = "Nao ha material na biblioteca";

    private static boolean VerificarBilioteca(HashMap<Autor, ArrayList<Material>> hashMap, String texto) {
        if (hashMap.isEmpty()) {
            System.out.println(texto);
            return false;
        }
        return true;

    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<Autor, ArrayList<Material>> biblioteca = new HashMap<>();

        int opcao = -1;
        int opcaoMenuPrimario = -1;
        boolean verificarBiblioteca = false;

        while (opcaoMenuPrimario != 5) {
            System.out.println(Menus.MENU_PRINCIPAL);
            opcaoMenuPrimario = FuncoesVerificacoes.VerificarInteiroComIntervalo(scan, "Digite sua opcao: ", 1, 5);

            switch (opcaoMenuPrimario) {
                case 1:
                    opcao = -1;
                    while (opcao != 5) {
                        System.out.println(Menus.MENU_DE_ADICAO);

                        opcao = FuncoesVerificacoes.VerificarInteiroComIntervalo(scan,"Digite sua opcao: ", 1, 5);

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
                                verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na bilioteca. " +
                                        "Use a opcao 1 ou 2 primeiro ");
                                if (verificarBiblioteca) {
                                    FuncoesGerenciamento.inserirRevista(scan, biblioteca);
                                } else {
                                    break;
                                }

                                break;

                            case 5:
                                System.out.println("Voltando ao menu anterior...");
                                break;

                            default:
                                System.out.println("Opcao invalida");


                        }

                    }

                    break;

                case 2:
                    verificarBiblioteca = VerificarBilioteca(biblioteca, NAO_HA_MATERIAL);
                    if (verificarBiblioteca) {
                        FuncoesRemocoes.excluirMaterial(biblioteca);
                    } else {
                        break;

                    }
                    break;
                case 3:
                    opcao = -1;
                    while (opcao != 5) {
                        System.out.println(Menus.MENU_DE_PESQUISA);

                        opcao = FuncoesVerificacoes.VerificarInteiroComIntervalo(scan,"Digite sua opcao: ", 1, 5);

                        switch (opcao) {
                            case 1:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha livros na biblioteca");
                                if (verificarBiblioteca) {
                                    FuncoesGerenciamento.PesquisarLivroPorTitulo((HashMap) biblioteca, scan);
                                    System.out.println("Pressione Enter para continuar...");
                                    scan.nextLine(); // Espera o usuário pressionar Enter
                                }
                                break;

                            case 2:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores na biblioteca");
                                if (verificarBiblioteca) {
                                    FuncoesGerenciamento.PesquisarLivroPorAutor((HashMap) biblioteca, scan);
                                    System.out.println("Pressione Enter para continuar...");
                                    scan.nextLine(); // Espera o usuário pressionar Enter
                                }
                                break;

                            case 3:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores ou revistas na biblioteca");
                                if (verificarBiblioteca) {
                                    FuncoesGerenciamento.PesquisarRevistaPorTitulo(biblioteca, scan);
                                    System.out.println("Pressione Enter para continuar...");
                                    scan.nextLine();
                                }
                                break;

                            case 4:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, "Nao ha autores ou revistas na biblioteca");
                                if (verificarBiblioteca) {
                                    FuncoesGerenciamento.PesquisarRevistaPorAutor(biblioteca, scan);
                                    System.out.println("Pressione Enter para continuar...");
                                    scan.nextLine();
                                }
                                break;

                            case 5:
                                System.out.println("Voltando ao menu anterior...");
                                break;

                            default:
                                System.out.println("Opcao invalida");


            }
        }
                    break;

                case 4:
                    opcao = -1;
                    while (opcao != 4) {
                        System.out.println(Menus.MENU_LISTAGEM);

                        opcao = FuncoesVerificacoes.VerificarInteiroComIntervalo(scan,"Digite sua opcao: ", 1, 4);

                        switch (opcao) {
                            case 1:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, NAO_HA_MATERIAL);
                                if (verificarBiblioteca) {
                                    FuncoesListagem.listarLivros(biblioteca);
                                }
                                break;

                            case 2:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, NAO_HA_MATERIAL);
                                if (verificarBiblioteca) {
                                    FuncoesListagem.listarRevistas(biblioteca);
                                }
                                break;

                            case 3:
                                verificarBiblioteca = VerificarBilioteca(biblioteca, NAO_HA_MATERIAL);
                                if (verificarBiblioteca) {
                                    FuncoesListagem.listarMateriais(biblioteca);
                                }
                                break;

                            case 4:
                                System.out.println("Voltando ao menu anterior...");
                                break;

                            default:
                                System.out.println("Opcao invalida");


                        }
                    }
                    break;

                case 5:
                    System.out.println("Saindo do programa...");
                    scan.close();
                    break;

                default:
                    System.out.println("Opcao invalida");

            }
        }


    }
}
