package co.kozao.calculatricescientifique.service;

import co.kozao.calculatricescientifique.model.ResultatCalcul;

public class CalculatriceService {
	public ResultatCalcul additionner(double a, double b) {
		return new ResultatCalcul(a + b, "addition");
	}
	
	public ResultatCalcul soustraire(double a, double b) {
		return new ResultatCalcul(a - b, "addition");
	}
	
	public ResultatCalcul multiplier(double a, double b) {
		return new ResultatCalcul(a * b, "multiplication");
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
	
	   public ResultatCalcul factorielle(int n) {
	        if (n < 0) {
	            return new ResultatCalcul("Erreur : Factorielle d'un nombre négatif");
	        }
	        long resultat = 1;
	        for (int i = 2; i <= n; i++) {
	            resultat *= i;
	        }
	        return new ResultatCalcul((double) resultat, "Factorielle");
	    }
	
	/*public static void main(String[] args) {
		CalculatriceService cal = new CalculatriceService();
		
		System.out.println(cal.additionner(2, 3).getValue());
	}*/
}
