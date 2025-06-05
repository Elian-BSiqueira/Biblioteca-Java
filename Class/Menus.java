package Class;

public class Menus {
    public static final String MENU_PRINCIPAL = "=".repeat(30) +
            "\nSistema De Biblioteca\n" +
            "=".repeat(30) +
            """

            1) Opcoes de Adicionar
            2) Remover material
            3) Opcoes de Pesquisar material
            4) Listagem
            5) Sair
            """;

    public static final String MENU_DE_PESQUISA = "=".repeat(30) +
            """

            1) Pesquisar livro por titulo
            2) Pesquisar livros por autor
            3) Pesquisar Revista por titulo
            4) Pesquisar Revista por autor
            5) Voltar
            """;

    public static final String MENU_DE_ADICAO = "=".repeat(30) +
            """

            1) Adicionar autor e livro
            2) Adicionar livro
            3) Adiconar autoria e revista
            4) Adicionar Revista
            5) Voltar
            """;

    public static final String MENU_LISTAGEM = "=".repeat(30) +
            """

            1) Listar livros
            2) Listar Revistas
            3) Listar tudo
            4) Voltar
            """;
}
