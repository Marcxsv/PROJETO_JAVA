import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[4];

        String opcao = "";
        int index = 0;

        while (!opcao.equalsIgnoreCase("Sair") && index < produtos.length) {
            produtos[index] = cadastrarProduto(scanner);
            index++;

            System.out.println("Produto cadastrado");
            System.out.println("Pré-visualização do produto:");
            System.out.println(produtos[index - 1].toString());

            System.out.println("Digite 'Sair' para encerrar o programa, 'Editar' para modificar o último produto ou qualquer outra tecla para cadastrar outro produto:");
            opcao = scanner.nextLine();

            if (opcao.equalsIgnoreCase("Editar")) {
                index--;
            }
        }


        for (Produto produto : produtos) {
            if (produto != null) {
                System.out.println(produto.toString());
                System.out.println();
            }
        }
    }

    private static Produto cadastrarProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Escolha o tipo do produto:");
        System.out.println("1 - Comum");
        System.out.println("2 - Perecível");
        int tipoEscolhido = scanner.nextInt();
        scanner.nextLine();

        if (tipoEscolhido == 1) {
            return cadastrarProdutoEspecifico(scanner, nome, "Comum");
        } else if (tipoEscolhido == 2) {
            return cadastrarProdutoEspecifico(scanner, nome, "Perecível");
        } else {
            System.out.println("Opção inválida. Criando produto comum por padrão.");
            return cadastrarProdutoEspecifico(scanner, nome, "Comum");
        }
    }

    private static Produto cadastrarProdutoEspecifico(Scanner scanner, String nome, String tipo) {
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        System.out.println("Digite o peso do produto:");
        double peso = scanner.nextDouble();
        System.out.println("Digite o código de barras do produto:");
        String codigoBarras = scanner.next();
        System.out.println("Digite o código de identificação do produto:");
        String codigoIdentificacao = scanner.next();
        System.out.println("Digite a marca do produto:");
        String marca = scanner.next();
        scanner.nextLine();

        if (tipo.equalsIgnoreCase("Perecível")) {
            System.out.println("Digite a data de validade do produto:");
            String dataValidade = scanner.nextLine();
            return new ProdutoPerecivel(nome, preco, tipo, peso, codigoBarras, codigoIdentificacao, marca, dataValidade);
        } else {
            return new ProdutoComum(nome, preco, tipo, peso, codigoBarras, codigoIdentificacao, marca);
        }
    }
}