package Class;

public class Livro extends Material {
    private Genero genero;

    public Livro(String titulo, Autor autor, Genero genero) {
        super(titulo, autor); // Chama o construtor da classe Material
        this.genero = genero;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "LIVRO | Título: " + getTitulo() +
                " | Autor: " + getAutor().getNome() +
                " | Gênero: " + genero;
    }
}

/*
Classe Livro:
Representa um livro da biblioteca.
Herdando de Material, adiciona um atributo específico: o gênero (usando o enum Genero).
Sobrescreve o metodo toString para exibir o gênero junto com o título e autor.
Permite que cada livro tenha uma categoria definida, como Romance ou Fantasia.
*/

/*
A sobrescrita do metodo toString permite que cada livro seja exibido com detalhes específicos (título, autor e gênero).
Isso facilita a leitura e compreensão quando os livros são listados no console pela classe Biblioteca.
*/
