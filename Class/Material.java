package Class;

public abstract class Material {
    private String titulo;
    private Autor autor;

    public Material(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters
    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    // Metodo abstrato (será implementado por Livro e Revista)
    @Override
    public abstract String toString();
}

/*
Classe Material:
É a classe base (abstrata) para representar um material da biblioteca, como livros e revistas.
Contém atributos comuns: título e autor.
Define o metodo toString básico para exibir essas informações.
Serve como base para que Livro e Revista possam herdar esses atributos e comportamentos.
*/


