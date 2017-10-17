package tp2.exercice8;

import java.io.Serializable;

public class Manutentionnaire extends Employe {

    private double heureMensuel;

    public Manutentionnaire(String nom, String prenom, int age, String dateEntree, double heureMensuel) {
        super(nom, prenom, age, dateEntree);
        this.heureMensuel = heureMensuel;
    }

    @Override
    double calculerSalaire() {
        salaire = heureMensuel * 65;
        return salaire;
    }

    @Override
    String getNom() {
        return "Le manutentionnaire " + nom + " " + prenom;
    }
}
