package com.algaworks.passagem_aerea.service;

import com.algaworks.passagem_aerea.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if(voo.getPreco() > 700.00)
			return voo.getPreco() * 0.9;
		return voo.getPreco() * 0.94;
	}

}
