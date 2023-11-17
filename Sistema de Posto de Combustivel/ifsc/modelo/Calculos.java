package modelo;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Calculos {
	public Float totPagComb(float digiQntL, Combustiveis combusSelecinada, float digiDisel, float digiGCom,
			float digiGAdd, float digiEtanol) {
		Float tcomb = (float) 0.0;
		String nomeCombustivel = combusSelecinada.getNome();
		if (nomeCombustivel.equals("Oleo Disel")) {
			tcomb = digiQntL * digiDisel;
		} else if (nomeCombustivel.equals("Gas. Comum")) {
			tcomb = digiQntL * digiGCom;
		} else if (nomeCombustivel.equals("Gas. Aditivada")) {
			tcomb = digiQntL * digiGAdd;
		} else if (nomeCombustivel.equals("Etanol")) {
			tcomb = digiQntL * digiEtanol;
		}
		return tcomb;
	}

	public Float[] totPagOleo(float digiFrasco1L, float digiFrasco500ml, float digiQntFrasco1L,
			float digiQntFrasco500mL) {
		Float F500leo = digiFrasco500ml * digiQntFrasco500mL;
		Float F1oleo = digiFrasco1L * digiQntFrasco1L;
		Float toleo = F1oleo + F500leo;

		return new Float[] { F500leo, F1oleo, toleo };
	}

	public Float totPag(float totalComb, Float valoresOleo, JRadioButton rdbtn_Vista, JRadioButton rdbtn_Prazo,
			int digiDias) {
		float Total = (float) 0.0;
		Total = totalComb + valoresOleo;
		if (rdbtn_Prazo.isSelected()) {
			if (digiDias <= 30) {
				// nada acontece
			} else {
				Total = (float) (Total + (Total * 0.1));
			}
		} else if (rdbtn_Vista.isSelected()) {
			Total = (float) (Total - (Total * 0.1));
		}

		return Total;
	}
}
