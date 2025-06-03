
package Class;

public class Revista extends Material {
    private int numero;

    public Revista(String titulo, Autor autor, int numero) {
        super(titulo, autor); // Chama o construtor da classe Material
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "REVISTA | Título: " + getTitulo() +
                " | Autor: " + getAutor().getNome() +
                " | Número: " + numero;
    }
}

/*
Classe Revista:
Representa uma revista da biblioteca.
Herdando de Material, adiciona um atributo específico: o número da edição.
Sobrescreve o metodo toString para mostrar o número da revista junto com título e autor.
Útil para diferenciar revistas com o mesmo nome, mas de edições diferentes.
*/
/*
A sobrescrita do metodo toString facilita a exibição clara das revistas cadastradas, incluindo o número da edição.
Isso ajuda a diferenciar visualmente revistas com o mesmo título, mas edições distintas, ao listá-las no sistema.
*/
