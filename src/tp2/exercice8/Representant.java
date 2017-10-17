package tp2.exercice8;

public class Representant extends Employe {


    private double chiffreAffaire;

    public Representant(String nom, String prenom, int age, String dateEntree, double chiffreAffaire) {
        super(nom, prenom, age, dateEntree);
        this.chiffreAffaire = chiffreAffaire;
    }

    @Override
    double calculerSalaire() {
        salaire = (chiffreAffaire * 0.20) + 800;
        return salaire;
    }

    @Override
    String getNom() {
        return "Le representant " + nom + " " + prenom;
    }
}
