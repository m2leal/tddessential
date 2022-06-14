package com.algaworks.passagem_aerea.model;

import com.algaworks.passagem_aerea.service.CalculadoraPrecoPassagem;
import com.algaworks.passagem_aerea.service.PrecoPassagemGold;
import com.algaworks.passagem_aerea.service.PrecoPassagemSilver;

public enum TipoPassageiro {
	
	GOLD(new PrecoPassagemGold()),
	SILVER(new PrecoPassagemSilver());
	
	CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	private TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem) {
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadora() {
		return calculadoraPrecoPassagem;
	}
	
}
