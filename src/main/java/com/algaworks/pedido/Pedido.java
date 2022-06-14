package com.algaworks.pedido;

import java.util.ArrayList;
import java.util.List;

import com.algaworks.pedido.desconto.CalculadoraFaixaDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<ItemPedido>();
	private CalculadoraFaixaDesconto calculadoraFaixaDesconto;
	
	public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
		this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
	}
	
	private void validarQuantidadeItens(ItemPedido itemPedido) {
		if(itemPedido.getQuantidade() < 0)
			throw new QuantidadeItensInvalidaException();
	}
	
	public void adicionarItem(ItemPedido itemPedido) {
		validarQuantidadeItens(itemPedido);
		
		itens.add(itemPedido);
	}
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValorUnitario() * i.getQuantidade()).sum();
		double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, desconto);
	}
}
