package tp2.exercice8;

public class Vendeur extends Employe {


    private double chiffreAffaire;

    public Vendeur(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
        super(nom, prenom, age, dateEntree);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    double calculerSalaire() {
        salaire = (chiffreAffaire * 0.20) + 400;
        return salaire;

    }

    @Override
    String getNom() {
        return "Le vendeur " + nom + " " + prenom;
    }
}
