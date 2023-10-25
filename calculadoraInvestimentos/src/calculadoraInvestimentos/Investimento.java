package calculadoraInvestimentos;

public class Investimento {
	private int meses;
	private double juros;
	private double deposito_mensal;

	public Investimento(int numMes, double dJurosMes, double dDepMen) {
		meses = numMes;
		juros = dJurosMes / 100;
		deposito_mensal = dDepMen;
	}

	public double calculaTotal(int depMen, double jurosMes, double jurosMes2) {
		int num_pagamentos = meses;
		double total = 0;
		for (int i = 0; i < num_pagamentos; i++) {
			total = total + deposito_mensal;
			total = total + total * juros;
		}
		return total;
	}
}
