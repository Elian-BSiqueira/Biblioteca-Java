package Funcoes;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import Class.*;

public class FuncoesListagem {

    public static void listarMateriais(HashMap<Autor, ArrayList<Material>> biblioteca) {
        System.out.println("\n--- Todos os Materiais ---");
        if (biblioteca.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }

        boolean hasMaterials = false;
        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                System.out.println(material);
                hasMaterials = true;
            }
        }

        if (!hasMaterials) {
            System.out.println("Nenhum material cadastrado.");
        }
    }

    public static void listarLivros(HashMap<Autor, ArrayList<Material>> biblioteca) {
        System.out.println("\n--- Livros Cadastrados ---");
        boolean hasBooks = false;

        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                if (material instanceof Livro) {
                    System.out.println(material);
                    hasBooks = true;
                }
            }
        }

        if (!hasBooks) {
            System.out.println("Nenhum livro cadastrado.");
        }
    }

    public static void listarRevistas(HashMap<Autor, ArrayList<Material>> biblioteca) {
        System.out.println("\n--- Revistas Cadastradas ---");
        boolean hasMagazines = false;

        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                if (material instanceof Revista) {
                    System.out.println(material);
                    hasMagazines = true;
                }
            }
        }

        if (!hasMagazines) {
            System.out.println("Nenhuma revista cadastrada.");
        }
    }
}
