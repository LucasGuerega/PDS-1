package modelo;

import java.text.DecimalFormat;

public class Calcular {
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int sub(int num1, int num2) {
		return num1 - num2;
	}

	public int multi(int num1, int num2) {
		return num1 * num2;
	}

	public String divi(int num1, int num2) {
		float num1F = Float.valueOf(num1);
		float num2F = Float.valueOf(num2);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		float divi = num1F / num2F;
		String txtresultado = decimalFormat.format(divi);

		return txtresultado;
	}

}
