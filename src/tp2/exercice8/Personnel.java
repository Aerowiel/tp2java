package tp2.exercice8;

import tp2.service.Asker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static tp2.service.Saver.serializeObject;

public class Personnel implements Serializable {

    private List<Employe> employes = new ArrayList<Employe>();
    private static String[] classes = { "tp2.exercice8.Vendeur",
                                        "tp2.exercice8.Representant",
                                        "tp2.exercice8.Technicien",
                                        "tp2.exercice8.Manutentionnaire",
                                        "tp2.exercice8.TechnARisque",
                                        "tp2.exercice8.ManutARisque"};



    public int tailleEmployes(){
        return employes.size();
    }

    public void creerEmploye(){

        int choix = 0;
        boolean nombreCorrect = false;

        System.out.println("Quel type d'employe souhaitez-vous créer ? :");
        System.out.println("1 pour créer un vendeur");
        System.out.println("2 pour créer un représentant");
        System.out.println("3 pour créer un Technicien");
        System.out.println("4 pour créer un Manutentionnaire");
        System.out.println("5 pour créer un Technicien à risque");
        System.out.println("6 pour créer un Manutentionnaire à risque");

        System.out.println("Votre choix : ");

        // J'ai pas trouvé comment faire autrement, "if it works it ain't stupid"
        choix = Asker.askChoiceForMenu();

        Object[] attributes = Asker.askForEmployeAttributes();

        try {
            Employe e = (Employe) Class.forName(classes[choix - 1])
                                       .getConstructor(String.class, String.class, int.class, String.class, double.class)
                                       .newInstance((String)attributes[0], (String)attributes[1], (int)attributes[2], (String)attributes[3], (Double)attributes[4]);
            ajouterEmploye(e);
            serializeObject("personnel.ser", this);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void ajouterEmploye(Employe e){
        employes.add(e);
    }

    public void calculerSalaires(){
        for (Employe emp : employes) {
            System.out.println(emp.getNom() + " gagne " + emp.calculerSalaire() + " €");
        }
    }

    public double salaireMoyen(){
        double salaireTotal = 0;
        int nombreEmploye = employes.size();
        for (Employe emp : employes) {
            salaireTotal += emp.calculerSalaire();
        }
        return salaireTotal / nombreEmploye;
    }
}
