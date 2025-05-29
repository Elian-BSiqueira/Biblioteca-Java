package Funcoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Class.Autor;
import Class.Livro;

public class FuncoesGerenciamento {

    // Pesquisar livro por título
    public static void PesquisarLivroPorTitulo(HashMap<Autor, ArrayList<Livro>> biblioteca, Scanner scan) {
        System.out.print("\nDigite o título do livro: ");
        String titulo = scan.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("Busca cancelada.");
            return;
        }

        boolean encontrado = false;

        for (Autor autor : biblioteca.keySet()) {
            for (Livro livro : biblioteca.get(autor)) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("\nLivro encontrado:");
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor().getNome());
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) break;
        }

        if (!encontrado) {
            System.out.println("\nLivro não encontrado na biblioteca.");
        }
    }

    // Pesquisar livros por autor
    public static void PesquisarLivroPorAutor(HashMap<Autor, ArrayList<Livro>> biblioteca, Scanner scan) {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scan.nextLine().trim();

        if (nomeAutor.isEmpty()) {
            System.out.println("Busca cancelada.");
            return;
        }

        boolean encontrado = false;

        // Percorre todos os autores
        for (Autor autor : biblioteca.keySet()) {
            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                System.out.println("\nLivros do autor " + autor.getNome() + ":");
                if (biblioteca.get(autor).isEmpty()) {
                    System.out.println("- Este autor não possui livros cadastrados.");
                } else {
                    for (Livro livro : biblioteca.get(autor)) {
                        System.out.println("- " + livro.getTitulo());
                    }
                }
                System.out.println();  // Linha em branco para melhorar legibilidade
                encontrado = true;
                break;  // Sai do loop se encontrou
            }
        }

        if (!encontrado) {
            System.out.println("\nAutor não encontrado na biblioteca.\n");
        }
    }

    /*Pesquisar por Livro Titulo:
    Pede o título do livro ao usuário, ele percorre todos os autores e seus livro procurando pelo título, se encontrar, mostra o título e o autor, se não encontrar, avisa o usuário

    Pesquisar por Autor e mostrar livros:
    Pede o nome do autor ao usuário, percorre todos os autores procurando pelo nome, se encontrar, lista todos os livros desse autor,
    se não encontrar, avisa o usuário, ambas as funções ignoram maiúsculas/minúsculas (usando equalsIgnoreCase) para tornar a pesquisa mais flexível.*/


    // Lista autores
    private static void listarAutores(HashMap<Autor, ArrayList<Livro>> hashMap) {
        hashMap.keySet().forEach(autor -> System.out.println("- " + autor.getNome()));
    }

    // Adiciona um livro a um autor existente
    public static void adicionarLivro(Scanner scanner, HashMap<Autor, ArrayList<Livro>> hashMap) {
        listarAutores(hashMap);
        Autor autor= FuncoesVerificacoes.verificaAutor(scanner, hashMap);
        String nome;
        if (autor == null) {
            System.out.println("Operacao cancelada");
            return;
        } else {
            boolean controleDeLoop = true;

            while (controleDeLoop) {
                System.out.print("Digite o nome do livro que deseja adicionar, deixe em branco para cancelar: ");
                nome = scanner.nextLine().strip();
                if (nome.isEmpty()) {
                    return;
                } else {
                    String nomeverificar = nome;
                    boolean verificarLivro =
                            hashMap.get(autor).stream().anyMatch(titulo -> titulo.getTitulo().equalsIgnoreCase(nomeverificar));

                    if (verificarLivro) {
                        System.out.println("Livro ja esta na biblioteca");
                        controleDeLoop = false;
                    } else {
                        Livro livro = new Livro(nome, autor);
                        hashMap.get(autor).add(livro);
                        System.out.printf("Livro %s adicionado com sucesso ao autor %s %n", nome, autor.getNome());
                        controleDeLoop = false;
                    }

                }
            }


        }
    }

    /**
     * Adiciona um novo autor e um livro associado à biblioteca representada por um HashMap.
     *
     * <p>Este método interativo solicita ao usuário, via Scanner, o nome do autor que deseja adicionar.
     * Caso o autor já exista no HashMap (chaves do mapa), a operação é cancelada.
     * Se o autor não existir, ele será criado e adicionado ao mapa com uma lista vazia de livros.
     *
     * <p>Após adicionar o autor, o método solicita o nome do livro a ser associado a esse autor.
     * Caso o livro já exista na lista do autor, a operação de adição do livro é cancelada.
     * Caso contrário, solicita o ano de lançamento do livro (usando um método externo `VerificarNumeroInt`)
     * e adiciona o novo livro à lista do autor.
     *
     * <p>Em qualquer etapa, se o usuário digitar uma linha em branco, a operação é cancelada e o método retorna.
     *
     * @param scanner Scanner utilizado para entrada dos dados do usuário (nome do autor e nome do livro).
     * @param hashMap Mapa que associa objetos {@link Autor} a listas de {@link Livro}, representando a biblioteca.
     *
     * @implNote O método depende do método externo {@code VerificarNumeroInt} para validar a entrada do ano de publicação.
     *
     * @see Autor
     * @see Livro
     */
    public static void adicionarAutorELivro(Scanner scanner, HashMap<Autor, ArrayList<Livro>> hashMap) {
        String nome = null;
        boolean controleDeLoop = true;
        Autor autor = null;

        while (controleDeLoop) {
            System.out.print("Digite o nome do autor que deseja adicionar, deixe em branco para cancelar: ");
            nome = scanner.nextLine().strip();
            if (nome.isEmpty()) {
                return;
            } else {
                String nomeverificar = nome;
                boolean verificarAutor =
                        hashMap.keySet().stream().anyMatch(nomeAutor -> nomeAutor.getNome().equalsIgnoreCase(nomeverificar));
                if (verificarAutor) {
                    System.out.printf("Autor %s esta na biblioteca. %n", nome);
                    return;
                } else {
                    autor = new Autor(nome.toLowerCase());
                    hashMap.put(autor, new ArrayList<>());
                    System.out.printf("Autor %s adicionado a biblioteca %n", nome);
                    controleDeLoop = false;

                }

            }
        }

        String nomeLivro = null;
        controleDeLoop = true;

        while (controleDeLoop) {
            System.out.print("Digite o nome do livro que deseja adicionar, deixe em branco para cancelar: ");
            nome = scanner.nextLine().strip();
            if (nome.isEmpty()) {
                return;
            } else {
                String nomeverificar = nome;
                boolean verificarLivro =
                        hashMap.get(autor).stream().anyMatch(titulo -> titulo.getTitulo().equalsIgnoreCase(nomeverificar));

                if (verificarLivro) {
                    System.out.println("Livro ja esta na biblioteca");
                    controleDeLoop = false;
                } else {
                    Livro livro = new Livro(nome, autor);
                    hashMap.get(autor).add(livro);
                    System.out.printf("Livro %s adicionado com sucesso ao autor %s %n", nome, autor.getNome());
                    controleDeLoop = false;
                }

            }
        }



    }

}
