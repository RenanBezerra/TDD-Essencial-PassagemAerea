package com.gft.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Passageiro;
import com.gft.model.TipoPassageiro;
import com.gft.model.Voo;

public class PrecoPassagemServiceTest {

	private PrecoPassagemService precoPassagemService;

	@Before
	public void setup() {
		precoPassagemService = new PrecoPassagemService();
	}

	protected void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);

		assertEquals(esperado, valor, 0.001);
	}

	@Test
	public void deveCalcularValorPassagemParaPassageiroGoldComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("JOAO", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);

	}

	@Test
	public void deveCalcularValorPassagemParaPassageiroGoldComvalorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("JOAO", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);


	}

	@Test
	public void deveCalcularValorPassagemParaPassageiroSilverComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("JOAO", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);
		
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilverComValorAcimaDoLimite() throws Exception{
		
		Passageiro passageiro = new Passageiro("JOAO", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);
	
		
	
	}
	

}
