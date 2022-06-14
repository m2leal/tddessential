package com.algaworks.passagem_aerea;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.algaworks.passagem_aerea.model.Passageiro;
import com.algaworks.passagem_aerea.model.TipoPassageiro;
import com.algaworks.passagem_aerea.model.Voo;
import com.algaworks.passagem_aerea.service.PrecoPassagemService;

public class PrecoPassagemServiceTest {
	
	PrecoPassagemService precoPassagemService;
	
	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}
	
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroGoldComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 90.0);
	}
	
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroGoldComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		
		assertValorPassagem(passageiro, voo, 510.0);
	}
	
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroSilverComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		
		assertValorPassagem(passageiro, voo, 94.0);
	}
	
	@Test
	public void deveCalcularValorDaPassagemParaPassageiroSilverComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("João", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		
		assertValorPassagem(passageiro, voo, 720.0);
	}
	
}
