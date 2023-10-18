package model;

public class CalcValorPrato {
	public float calcValorPrato(float precoKg, float pesoPt) {
        
		Float valorPrato = precoKg*pesoPt;
		/*Float valorPrato = pesoPt*9.95f;*/
		return valorPrato;
    }
}
