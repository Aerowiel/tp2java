package tp2.exercice8;

public class TechnARisque extends Technicien implements IARisque {

    public TechnARisque(String nom, String prenom, int age, String dateEntree, double uniteProduite) {
        super(nom, prenom, age, dateEntree, uniteProduite);
    }



    @Override
    double calculerSalaire() {
        return super.calculerSalaire() + getPrime();
    }

    @Override
    public double getPrime() {
        return 200;
    }
}
