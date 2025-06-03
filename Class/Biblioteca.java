package Class;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Material> materiais = new ArrayList<>();

    // Adiciona qualquer material (Livro ou Revista)
    public void adicionarMaterial(Material material) {
        materiais.add(material);
        System.out.println("Novo material cadastrado com sucesso!");;
    }

    // Remove por título
    public void removerMaterial(String titulo) {
        Material material = pesquisarPorTitulo(titulo);
        if (material != null) {
            materiais.remove(material);
            System.out.println("Material excluído com sucesso!");
        } else {
            System.out.println("Material não encontrado.");
        }
    }

    // Pesquisa por título (ignora maiúsculas/minúsculas)
    public Material pesquisarPorTitulo(String titulo) {
        for (Material material : materiais) {
            if (material.getTitulo().equalsIgnoreCase(titulo)) {
                return material;
            }
        }
        return null;
    }

    // Lista todos os materiais
    public void listarTodos() {
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
            return;
        }
        System.out.println("=".repeat(50));
        System.out.println("MATERIAIS CADASTRADOS:");
        materiais.forEach(System.out::println);
    }

    // Lista materiais de um autor específico
    public void listarPorAutor(String nomeAutor) {
        List<Material> materiaisAutor = new ArrayList<>();
        for (Material material : materiais) {
            if (material.getAutor().getNome().equalsIgnoreCase(nomeAutor)) {
                materiaisAutor.add(material);
            }
        }

        if (materiaisAutor.isEmpty()) {
            System.out.println("Nenhum material encontrado para o autor.");
        } else {
            System.out.println("=".repeat(50));
            System.out.println("MATERIAIS DO AUTOR " + nomeAutor.toUpperCase() + ":");
            materiaisAutor.forEach(System.out::println);
        }

    }

    // Getter para a lista de materiais (útil para validações)
    public List<Material> getMateriais() {
        return materiais;
    }
}

/*
Classe Biblioteca:
Gerencia a coleção de materiais da biblioteca usando uma lista do tipo Material.
Permite:
- Adicionar novos livros ou revistas.
- Pesquisar materiais pelo título (ignorando maiúsculas/minúsculas).
- Remover materiais pelo título.
- Listar todos os materiais cadastrados (livros e revistas juntos).

Aproveita o uso de polimorfismo: trata livros e revistas como "materiais" genéricos.
Gera mensagens de feedback para avisar o usuário sobre o sucesso ou falha das operações.
*/
