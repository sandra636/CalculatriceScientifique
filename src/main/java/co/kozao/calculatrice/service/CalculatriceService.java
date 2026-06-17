package co.kozao.calculatrice.service;

import co.kozao.calculatricescientifique.model.ResultatCalcul;

public class CalculatriceService {
	
	public ResultatCalcul additionner(double a, double b) {
		return new ResultatCalcul(a + b, "addition");
	}
	
	public ResultatCalcul soustraire(double a, double b) {
		return new ResultatCalcul(a - b, "addition");
	}
	
	public ResultatCalcul multiplier(double a, double b) {
		return new ResultatCalcul(a * b, "addition");
	}
	
	public ResultatCalcul diviser(double a, double b) {
		if(b == 0) {
			return new ResultatCalcul("Erreur, impossible de diviser par zero");
		}
		return new ResultatCalcul(a / b, "division");
	}
	
	public ResultatCalcul puissance(double a, double b) {
		return new ResultatCalcul(Math.pow(a, b), "puissance");
	}
	
	public ResultatCalcul racine(double a) {
		if (a < 0) {
			return new ResultatCalcul ("Erreur, la racine carre n'admet pas de nombre négatif");
		}
		return new ResultatCalcul(Math.sqrt(a), "racine carée");
		
	}
	
	/*public static void main(String[] args) {
		CalculatriceService cal = new CalculatriceService();
		
		System.out.println(cal.additionner(2, 3).getValue());
	}*/
}


