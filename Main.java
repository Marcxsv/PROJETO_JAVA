import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[4];

        String opcao = "";
        int index = 0;

        while (!opcao.equalsIgnoreCase("Sair") && index < produtos.length) {
            Produto novoProduto = cadastrarProduto(scanner);
            produtos[index] = novoProduto;
            index++;

            System.out.println("Produto cadastrado");
            System.out.println("Pré-visualização do produto:");
            System.out.println(novoProduto.toString());

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
        scanner.nextLine(); // Consumir a quebra de linha pendente

        if (tipoEscolhido == 1) {
            return cadastrarProdutoComum(scanner, nome);
        } else if (tipoEscolhido == 2) {
            return cadastrarProdutoPerecivel(scanner, nome);
        } else {
            System.out.println("Opção inválida. Criando produto comum por padrão.");
            return cadastrarProdutoComum(scanner, nome);
        }
    }

    private static Produto cadastrarProdutoComum(Scanner scanner, String nome) {
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
        scanner.nextLine(); // Consumir a quebra de linha pendente
        return new ProdutoComum(nome, preco, "Comum", peso, codigoBarras, codigoIdentificacao, marca);
    }

    private static Produto cadastrarProdutoPerecivel(Scanner scanner, String nome) {
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
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Digite a data de validade do produto:");
        String dataValidade = scanner.nextLine();
        return new ProdutoPerecivel(nome, preco, "Perecível", peso, codigoBarras, codigoIdentificacao, marca, dataValidade);
    }
}

