package model;

public class ConversaoTemperatura {
	public float convFtC(float tempF){
		float tempC=(tempF-32f)*5f/9f;
		return tempC;
	}
}
