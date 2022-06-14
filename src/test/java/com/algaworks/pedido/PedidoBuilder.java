package com.algaworks.pedido;

import com.algaworks.pedido.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.algaworks.pedido.desconto.CalculadoraDescontoSegundaFaixa;
import com.algaworks.pedido.desconto.CalculadoraDescontoTerceiraFaixa;
import com.algaworks.pedido.desconto.CalculadoraFaixaDesconto;
import com.algaworks.pedido.desconto.SemDesconto;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto =
			new CalculadoraDescontoTerceiraFaixa(
				new CalculadoraDescontoSegundaFaixa(
					new CalculadoraDescontoPrimeiraFaixa(
						new SemDesconto(null))));
		
		instancia = new Pedido(calculadoraFaixaDesconto);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));
		return this;
	}
	
	public Pedido construir() {
		return instancia;
	}
}
