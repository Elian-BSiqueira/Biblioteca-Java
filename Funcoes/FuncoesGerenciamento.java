package Funcoes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import Class.Autor;
import Class.Livro;

public class FuncoesGerenciamento {

    // Pesquisar livro por título
    public static void PesquisarLivroPorTitulo(HashMap<Autor, ArrayList<Livro>> biblioteca, Scanner scan) {
        System.out.print("Digite o título do livro: ");
        String titulo = scan.nextLine();

        boolean encontrado = false;

        // Percorre todos os autores e seus livros
        for (Autor autor : biblioteca.keySet()) {
            for (Livro livro : biblioteca.get(autor)) {
                if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("Livro encontrado:");
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor().getNome());
                    encontrado = true;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado na biblioteca.");
        }
    }

    // Pesquisar livros por autor
    public static void PesquisarLivroPorAutor(HashMap<Autor, ArrayList<Livro>> biblioteca, Scanner scan) {
        System.out.print("Digite o nome do autor: ");
        String nomeAutor = scan.nextLine();

        boolean encontrado = false;

        // Percorre todos os autores
        for (Autor autor : biblioteca.keySet()) {
            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
                System.out.println("Livros do autor " + autor.getNome() + ":");
                for (Livro livro : biblioteca.get(autor)) {
                    System.out.println("- " + livro.getTitulo());
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Autor não encontrado na biblioteca.");
        }
    }
}

/*Pesquisar por Livro Titulo:Pede o título do livro ao usuário, ele percorre todos os autores e seus livro procurando pelo título, se encontrar, mostra o título e o autor, se não encontrar, avisa o usuário

Pesquisar por Autor e mostrar livros: Pede o nome do autor ao usuário, percorre todos os autores procurando pelo nome, se encontrar, lista todos os livros desse autor,
se não encontrar, avisa o usuário, ambas as funções ignoram maiúsculas/minúsculas (usando equalsIgnoreCase) para tornar a pesquisa mais flexível.*/
