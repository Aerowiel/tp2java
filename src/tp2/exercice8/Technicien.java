package tp2.exercice8;

public class Technicien extends Employe {

    private double uniteProduite;

    public Technicien(String nom, String prenom, int age, String dateEntree, double uniteProduite) {
        super(nom, prenom, age, dateEntree);
        this.uniteProduite = uniteProduite;
    }

    @Override
    double calculerSalaire() {
        salaire = uniteProduite * 5;
        return salaire;
    }

    @Override
    String getNom() {
        return "Le technicien " + nom + " " + prenom;
    }
}
