package com.gft.service;

import com.gft.model.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {

	@Override
	public double calcular(Voo voo) {
		if (voo.getPreco() > 700.0)
			return calcularValorAcimaDoLimite(voo);
		return calculaValorAbaixoDoLimite(voo);
	}

	protected double calculaValorAbaixoDoLimite(Voo voo) {
		return voo.getPreco() * 0.94;
	}

	protected double calcularValorAcimaDoLimite(Voo voo) {
		return voo.getPreco() * 0.9;
	}

}
