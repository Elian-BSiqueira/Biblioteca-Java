package Funcoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;


import Class.*;

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
                    return;
                }
            }
            if (encontrado) return;
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

    //Pesquisa revistas por título
    public static void PesquisarRevistaPorTitulo(HashMap<Autor, ArrayList<Material>> biblioteca, Scanner scan) {
        System.out.print("\nDigite o título da revista: ");
        String titulo = scan.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("Busca cancelada.");
            return;
        }

        boolean encontrado = false;
        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                if (material instanceof Revista && material.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("\nRevista encontrada:");
                    System.out.println(material);
                    encontrado = true;
                    return;
                }
            }
        }
        if (!encontrado) {
            System.out.println("\nRevista não encontrada na biblioteca.");
        }
    }

    public static void PesquisarRevistaPorAutor(HashMap<Autor, ArrayList<Material>> biblioteca, Scanner scan) {
        System.out.print("\nDigite o nome do autor: ");
        String nomeAutor = scan.nextLine().trim();

        if (nomeAutor.isEmpty()) {
            System.out.println("Busca cancelada.");
            return;
        }

        boolean encontrado = false;
        for (Autor autor : biblioteca.keySet()) {
            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                System.out.println("\nRevistas do autor " + autor.getNome() + ":");
                for (Material material : biblioteca.get(autor)) {
                    if (material instanceof Revista) {
                        System.out.println(material);
                        encontrado = true;
                    }
                }
                if (!encontrado) {
                    System.out.println("Este autor não possui revistas cadastradas.");
                }
                return;
            }
        }
        if (!encontrado) {
            System.out.println("\nAutor não encontrado na biblioteca.");
        }
    }


    /*Pesquisar por Livro Titulo:
    Pede o título do livro ao usuário, ele percorre todos os autores e seus livro procurando pelo título, se encontrar, mostra o título e o autor, se não encontrar, avisa o usuário

    Pesquisar por Autor e mostrar livros:
    Pede o nome do autor ao usuário, percorre todos os autores procurando pelo nome, se encontrar, lista todos os livros desse autor,
    se não encontrar, avisa o usuário, ambas as funções ignoram maiúsculas/minúsculas (usando equalsIgnoreCase) para tornar a pesquisa mais flexível.*/

    // Lista autores
    private static void listarAutores(HashMap<Autor, ArrayList<Material>> hashMap) {
        hashMap.keySet().forEach(autor -> System.out.println("- " + autor.getNome()));
    }

    private static Revista criarRevista(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap, Autor autoria) {
        String nomeRevista = null;
        boolean controleDeLoop = true;
        int numeroDaRevista = 0;

        while (controleDeLoop) {
            System.out.print("Digite o nome da revista que deseja adicionar, deixe em branco para cancelar: ");

            nomeRevista = scanner.nextLine().strip();
            if (nomeRevista.isEmpty()) {
                return null;
            } else {
                String nomeverificar = nomeRevista;
                boolean verificarLivro =
                        hashMap.get(autoria).stream().anyMatch(titulo -> titulo.getTitulo().equalsIgnoreCase(nomeverificar));

                if (verificarLivro) {
                    System.out.println("Revista ja esta na biblioteca");
                    return null;
                } else {
                    numeroDaRevista = FuncoesVerificacoes.VerificarNumeroInt(scanner,"Digite o numero da revista: ");
                    controleDeLoop = false;
                }

            }
        }
        return new Revista(nomeRevista, autoria, numeroDaRevista);
    }

    public static void inserirRevista(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap) {
        listarAutores(hashMap);
        Autor autoria= FuncoesVerificacoes.verificaAutor(scanner, hashMap);
        if (autoria == null) {
            System.out.println("Operacao cancelada");
            return;
        } else {
            Revista revista = criarRevista(scanner, hashMap, autoria);
            if (revista == null) {
                System.out.println("Operacao cancelada");
            } else {
                hashMap.get(autoria).add(revista);
                System.out.printf("Revista %s adicionada com sucesso ao autor(a) %s %n", revista.getTitulo(),
                        autoria.getNome());
            }


        }
    }

    public static void adicionarAutoriaERevista(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap) {
        Autor autoria = adicionarAutor(scanner, hashMap);
        if (autoria == null) {
            return;
        }

        Revista revista = criarRevista(scanner,hashMap, autoria);
        if (revista == null) {
            return;
        }
        hashMap.get(autoria).add(revista);
        System.out.printf("Revista %s adicionada com sucesso ao autor %s %n", revista.getTitulo(), autoria.getNome());
    }

    // Adiciona um livro a um autor existente
    public static void inserirLivroNaLista(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap) {
        listarAutores(hashMap);
        Autor autor= FuncoesVerificacoes.verificaAutor(scanner, hashMap);
        if (autor == null) {
            System.out.println("Operacao cancelada");
            return;
        } else {
            Livro livro = criarLivro(scanner, hashMap, autor);
            if (livro == null) {
                System.out.println("Operacao cancelada");
            } else {
                hashMap.get(autor).add(livro);
                System.out.printf("Livro %s adicionado com sucesso ao autor(a) %s %n", livro.getTitulo(), autor.getNome());
            }


        }
    }

    private static Genero selecionarGenero(Scanner scanner) {
        Genero generoSelecionado = null;
        Genero[] generos = Genero.values();

        IntStream.rangeClosed(1, generos.length)
                .forEach(contador -> System.out.printf("%d - %s%n", contador, generos[contador - 1]));
        int codigoDoGenero = FuncoesVerificacoes.VerificarInteiroComIntervalo(scanner,"Digite o codigo " +
                "correspondente ao genero do livro. Digite 0 para cancelar: ", 0, 4);
        if (codigoDoGenero == 0) {
            return null;
        }

        switch (codigoDoGenero) {
            case 1:
                generoSelecionado = Genero.ROMANCE;
                break;
            case 2:
                generoSelecionado = Genero.FANTASIA;
                break;
            case 3:
                generoSelecionado = Genero.TERROR;
                break;
            case 4:
                generoSelecionado = Genero.HISTORIA;
                break;
            default:
                System.out.println("Entrada invalida");
        }
        return generoSelecionado;
    }

    public static Livro criarLivro(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap, Autor autor) {
        String nomeLivro = null;
        boolean controleDeLoop = true;
        Genero generoDoLivro = null;

        while (controleDeLoop) {
            System.out.print("Digite o nome do livro que deseja adicionar, deixe em branco para cancelar: ");

            nomeLivro = scanner.nextLine().strip();
            if (nomeLivro.isEmpty()) {
                return null;
            } else {
                String nomeverificar = nomeLivro;
                boolean verificarLivro =
                        hashMap.get(autor).stream().anyMatch(titulo -> titulo.getTitulo().equalsIgnoreCase(nomeverificar));

                if (verificarLivro) {
                    System.out.println("Livro ja esta na biblioteca");
                    return null;
                } else {
                    generoDoLivro = selecionarGenero(scanner);
                    controleDeLoop = false;
                }

            }
        }
        return new Livro(nomeLivro, autor, generoDoLivro);
    }

    public static Autor adicionarAutor(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap) {
        String nome = null;
        boolean controleDeLoop = true;
        Autor autor = null;

        while (controleDeLoop) {
            System.out.print("Digite o nome do autor/autoria que deseja adicionar, deixe em branco para cancelar: ");
            nome = scanner.nextLine().strip();
            if (nome.isEmpty()) {
                return null;
            } else {
                String nomeverificar = nome;
                boolean verificarAutor =
                        hashMap.keySet().stream().anyMatch(nomeAutor -> nomeAutor.getNome().equalsIgnoreCase(nomeverificar));
                if (verificarAutor) {
                    System.out.printf("Autor/Autoria %s esta na biblioteca. %n", nome);
                    return null;
                } else {
                    autor = new Autor(nome.toLowerCase());
                    hashMap.put(autor, new ArrayList<>());
                    System.out.printf("Autor/Autoria %s adicionado a biblioteca %n", nome);
                    controleDeLoop = false;

                }
            }
        }
        return autor;
    }

    public static void adicionarAutorELivro(Scanner scanner, HashMap<Autor, ArrayList<Material>> hashMap){
        Autor autor = adicionarAutor(scanner, hashMap);
        if (autor == null) {
            return;
        }

        Livro livro = criarLivro(scanner,hashMap, autor);
        if (livro == null) {
            return;
        }
        hashMap.get(autor).add(livro);
        System.out.printf("Livro %s adicionado com sucesso ao autor %s %n", livro.getTitulo(), autor.getNome());

    }

}
