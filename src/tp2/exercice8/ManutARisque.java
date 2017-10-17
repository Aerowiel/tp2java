package tp2.exercice8;

public class ManutARisque extends Manutentionnaire implements IARisque {



    public ManutARisque(String nom, String prenom, int age, String dateEntree, double heureMensuel) {
        super(nom, prenom, age, dateEntree, heureMensuel);
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
