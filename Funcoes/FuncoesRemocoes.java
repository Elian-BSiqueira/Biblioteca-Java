package Funcoes;

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import Class.*;

public class FuncoesRemocoes {

    public static void excluirMaterial(Scanner scanner, HashMap<Autor, ArrayList<Material>> biblioteca) {
        System.out.println("\n--- Excluir Material ---");
        System.out.print("Digite o título do material a ser excluído: ");
        String titulo = scanner.nextLine();

        ArrayList<Material> resultados = new ArrayList<>();
        Autor autorParaRemover = null;

        // Buscar materiais com o título informado
        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                if (material.getTitulo().equalsIgnoreCase(titulo)) {
                    resultados.add(material);
                    autorParaRemover = autor;
                }
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum material encontrado com o título '" + titulo + "'.");
            return;
        }

        System.out.println("Materiais encontrados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i + 1) + ". " + resultados.get(i));
        }
    }
}
