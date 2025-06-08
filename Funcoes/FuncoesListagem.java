import java.util.ArrayList;
public class FuncoesListagem{
 
private static void listarMateriais() {
        System.out.println("\n--- Todos os Materiais ---");
        List<Material> materiais = biblioteca.listarTodos();
        
        if (materiais.isEmpty()) {
            System.out.println("Nenhum material cadastrado.");
        } else {
            for (Material material : materiais) {
                System.out.println(material);
            }
        }
    }
    
    private static void listarLivros() {
        System.out.println("\n--- Livros Cadastrados ---");
        List<Livro> livros = biblioteca.listarLivros();
        
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }
    
    private static void listarRevistas() {
        System.out.println("\n--- Revistas Cadastradas ---");
        List<Revista> revistas = biblioteca.listarRevistas();
        
        if (revistas.isEmpty()) {
            System.out.println("Nenhuma revista cadastrada.");
        } else {
            for (Revista revista : revistas) {
                System.out.println(revista);
            }
        }
    }
}
