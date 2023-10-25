package modelo;

public class Retangulo {
	public float calcPerimetro(float base, float altura) {
        return 2 * (base + altura);
    }

    public float calcArea(float base, float altura) {
        return base * altura;
    }
}
