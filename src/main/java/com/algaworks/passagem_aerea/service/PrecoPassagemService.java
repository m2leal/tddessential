package com.algaworks.passagem_aerea.service;

import com.algaworks.passagem_aerea.model.Passageiro;
import com.algaworks.passagem_aerea.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		return passageiro.getTipo().getCalculadora().calcular(voo);
	}
	
}
