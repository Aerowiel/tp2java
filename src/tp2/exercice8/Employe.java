package tp2.exercice8;

import java.io.Serializable;

public abstract class Employe implements Serializable {

    protected String nom;
    protected String prenom;
    private int age;
    private String dateEntree;
    protected double salaire;

    public Employe(String nom, String prenom, int age, String dateEntree){
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.dateEntree = dateEntree;
    }

    abstract double calculerSalaire();

    abstract String getNom();


}
