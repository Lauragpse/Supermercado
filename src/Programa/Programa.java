package Programa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcao;
		Carrinho carrinho = new Carrinho();
		List<Produto> listaProdutos = new ArrayList<>(
				Arrays.asList(new Produto("Arroz ", 5.0), new Produto("Feijão ", 9.0), new Produto("Macarrão", 3.50),
						new Produto("Leite", 4.50), new Produto("Ovos", 18.0), new Produto("Carne", 53.0),
						new Produto("Cenoura", 3.50), new Produto("Tomate", 4.0), new Produto("Cebola", 7.0)));

		do {
			System.out.println("Menu Cliente:");
			System.out.println("1. Lista de Produtos");
			System.out.println("2. Carrinho");
			System.out.println("3. Sair");
			System.out.print("Digite uma opção: ");
			opcao = scanner.nextInt();

			switch (opcao) {
			case 1:
				int produtoEscolhido;
				do {
					System.out.println("1. Adicionar novo produto");
					System.out.println("Lista de Produtos:");
					for (int i = 0; i < listaProdutos.size(); i++) {
						System.out.println((i + 2) + ". " + listaProdutos.get(i));
					}
					System.out.print(
							"Digite 1 para adicionar um novo produto, o número do produto para adicioná-lo ao carrinho, ou 0 para voltar: ");
					produtoEscolhido = scanner.nextInt();
					if (produtoEscolhido == 1) {
						System.out.print("Digite o nome do produto: ");
						scanner.nextLine(); // Consume newline left-over
						String nome = scanner.nextLine();
						System.out.print("Digite o preço do produto: ");
						double preco = scanner.nextDouble();
						listaProdutos.add(new Produto(nome, preco));
						System.out.println("Produto adicionado à lista de produtos.");
					} else if (produtoEscolhido > 1 && produtoEscolhido <= listaProdutos.size() + 1) {
						carrinho.adicionarProduto(listaProdutos.get(produtoEscolhido - 2));
						System.out.println("Produto adicionado ao carrinho.");
					}
				} while (produtoEscolhido != 0);
				break;
			case 2:
				int opcaoCarrinho;
				do {
					System.out.println("1. Adicionar mais produtos");
					System.out.println("2. Remover produto");
					System.out.println("3. Mostrar ordem dos itens");
					System.out.println("4. Mostrar ordem por preço");
					System.out.println("5. Finalizar a compra");
					System.out.println("0. Voltar ao menu anterior");
					System.out.print("Digite uma opção: ");
					opcaoCarrinho = scanner.nextInt();
					switch (opcaoCarrinho) {
					case 1:
						System.out.println("1. Adicionar novo produto");
						System.out.println("Lista de Produtos:");
						for (int i = 0; i < listaProdutos.size(); i++) {
							System.out.println((i + 2) + ". " + listaProdutos.get(i));
						}
						System.out.print(
								"Digite 1 para adicionar um novo produto, o número do produto para adicioná-lo ao carrinho, ou 0 para voltar: ");
						int produtoAdicionar = scanner.nextInt();
						if (produtoAdicionar == 1) {
							System.out.print("Digite o nome do produto: ");
							scanner.nextLine(); // Consume newline left-over
							String nome = scanner.nextLine();
							System.out.print("Digite o preço do produto: ");
							double preco = scanner.nextDouble();
							listaProdutos.add(new Produto(nome, preco));
							System.out.println("Produto adicionado à lista de produtos.");
						} else if (produtoAdicionar > 1 && produtoAdicionar <= listaProdutos.size() + 1) {
							carrinho.adicionarProduto(listaProdutos.get(produtoAdicionar - 2));
							System.out.println("Produto adicionado ao carrinho.");
						}
						break;
					case 2:
						System.out.print("Digite o número do produto para removê-lo do carrinho ou 0 para voltar: ");
						int produtoRemover = scanner.nextInt();
						if (produtoRemover > 0 && produtoRemover <= carrinho.produtos.size()) {
							carrinho.removerProduto(carrinho.produtos.get(produtoRemover - 1));
							System.out.println("Produto removido do carrinho.");
						}
						break;
					case 3:
						System.out.println("Ordem dos itens no carrinho:");
						carrinho.mostrarCarrinho();
						break;
					case 4:
						System.out.println("Ordem por preço dos itens no carrinho:");
						carrinho.mostrarCarrinhoOrdenadoPorPreco();
						break;
					case 5:
						System.out.println(
								"Sua compra foi finalizada. O preço total dos itens é " + carrinho.calcularTotal());
						carrinho.produtos.clear();
						break;
					case 0:
						System.out.println("Voltando ao menu anterior...");
						break;
					default:
						System.out.println("Opção inválida. Por favor, tente novamente.");
						break;
					}
				} while (opcaoCarrinho != 0);
				break;
			case 3:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida. Por favor, tente novamente.");
				break;
			}
		} while (opcao != 3);

		scanner.close();
	}
}
