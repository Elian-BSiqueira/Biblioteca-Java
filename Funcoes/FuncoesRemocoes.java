package Funcoes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import Class.*;

public class FuncoesRemocoes {
    private static Scanner scanner = new Scanner(System.in);

    public static void excluirMaterial(HashMap<Autor, ArrayList<Material>> biblioteca) {
        System.out.println("\n--- Excluir Material ---");
        System.out.print("Digite o título do material a ser excluído: ");
        String titulo = scanner.nextLine().trim();

        if (titulo.isEmpty()) {
            System.out.println("Operação cancelada.");
            return;
        }

        // Lista para armazenar os materiais encontrados
        List<Material> resultados = new ArrayList<>();
        List<Autor> autoresDosMateriais = new ArrayList<>();

        // Busca em todos os autores e materiais
        for (Autor autor : biblioteca.keySet()) {
            for (Material material : biblioteca.get(autor)) {
                if (material.getTitulo().equalsIgnoreCase(titulo)) {
                    resultados.add(material);
                    autoresDosMateriais.add(autor);
                }
            }
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum material encontrado com o título '" + titulo + "'.");
            return;
        }

        System.out.println("Materiais encontrados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i+1) + ". " + resultados.get(i));
        }

        System.out.print("Selecione o numero 1 para ser excluído (ou 0 para cancelar): ");
        int escolha = FuncoesVerificacoes.VerificarInteiroComIntervalo(scanner, "", 0, resultados.size());

        if (escolha == 0) {
            System.out.println("Operação cancelada.");
            return;
        }

        // Remove o material selecionado
        Material materialSelecionado = resultados.get(escolha - 1);
        Autor autorDoMaterial = autoresDosMateriais.get(escolha - 1);

        biblioteca.get(autorDoMaterial).remove(materialSelecionado);
        System.out.println("Material removido com sucesso!");

        // Se o autor não tem mais materiais, remove o autor também
        if (biblioteca.get(autorDoMaterial).isEmpty()) {
            biblioteca.remove(autorDoMaterial);
            System.out.println("Autor " + autorDoMaterial.getNome() + " foi removido por não ter mais materiais.");
        }
    }
}