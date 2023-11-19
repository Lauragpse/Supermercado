package Programa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrinho {
	List<Produto> produtos;

	Carrinho() {
		produtos = new ArrayList<>();
	}

	void adicionarProduto(Produto produto) {
		produtos.add(produto);
	}

	void removerProduto(Produto produto) {
		produtos.remove(produto);
	}

	void mostrarCarrinho() {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	void mostrarCarrinhoOrdenadoPorPreco() {
		produtos.stream().sorted(Comparator.comparingDouble(produto -> produto.preco)).forEach(System.out::println);
	}

	double calcularTotal() {
		return produtos.stream().mapToDouble(produto -> produto.preco).sum();
	}
}