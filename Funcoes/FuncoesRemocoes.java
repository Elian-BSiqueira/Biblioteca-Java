 private static void excluirMaterial() {
        System.out.println("\n--- Excluir Material ---");
        System.out.print("Digite o título do material a ser excluído: ");
        String titulo = scanner.nextLine();
        
        List<Material> resultados = biblioteca.pesquisarPorTitulo(titulo);
        
        if (resultados.isEmpty()) {
            System.out.println("Nenhum material encontrado com o título '" + titulo + "'.");
            return;
        }
        
        System.out.println("Materiais encontrados:");
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println((i+1) + ". " + resultados.get(i));
        }
        
        System.out.print("Selecione o número do material a ser excluído: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        
        if (escolha < 1 || escolha > resultados.size()) {
            System.out.println("Opção inválida!");
            return;
        }
   
