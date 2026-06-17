package co.kozao.calculatricescientifique.model;

public class ResultatCalcul {

    private double valeur;
    private String erreur;
    private String operation;
    private boolean aErreur;

    // Constructeur succès
    public ResultatCalcul(double valeur, String operation) {
        this.valeur = valeur;
        this.operation = operation;
        this.aErreur = false;
    }

    // Constructeur erreur
    public ResultatCalcul(String erreur) {
        this.erreur = erreur;
        this.aErreur = true;
    }

    public double getValeur() {
        return valeur;
    }

    public String getErreur() {
        return erreur;
    }

    public String getOperation() {
        return operation;
    }

    public boolean isAErreur() {
        return aErreur;
    }
}