package Class;

import java.util.ArrayList;

public enum Genero {
    ROMANCE,
    FANTASIA,
    TERROR,
    HISTORIA;

    @Override
    public String toString() {
        // Converte para formato legível
        return this.name().charAt(0) +
                this.name().substring(1).toLowerCase();
    }

}

/*
Enum Genero:
Define os gêneros literários possíveis para um livro.
Usado na classe Livro para classificar e padronizar os tipos de livros cadastrados.
O metodo toString foi sobrescrito para exibir o nome de forma mais amigável (ex: FICCAO → Ficcao).
*/
