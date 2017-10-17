package tp2.exercice8;

import java.io.*;
import java.util.Scanner;

import static tp2.service.Saver.deserializeObject;

public class exercice8 {

    //J'ai repris mon exercice et non votre correction, je ne voyais pas d'interêt à partir du code d'un autre.
    //De plus à l'inverse des exercices 1 à 7 du package précédent mes classes sont en français car j'avais suivi votre consigne
    //dans laquelle les classes étaient en français, les nouvelles classes/instructions seront en anglais.

    public static void main(String[] args){
        Personnel p = new Personnel();

        if(new File("src/saves/personnel.ser").exists()){
            Object deserialized = deserializeObject("src/saves/personnel.ser");
            if(deserialized != null){
                p = (Personnel) deserialized;
            }
        }
        else{
            System.out.println("Il n'y a pas de sauveguardes...");
        }

        Scanner scanner = new Scanner(System.in);
        boolean wantToQuit = false;

        while(!wantToQuit){

            System.out.println("s/S : permets de saisir les paramètres pour un nouvel employé");
            System.out.println("c/C : permets de lancer le calcul des salaires");
            System.out.print("Que voulez-vous faire ? (q/Q to quit) ");
            String reponse =scanner.nextLine();

            if(reponse.toLowerCase().equals("s")){
                p.creerEmploye();
            }
            else if(reponse.toLowerCase().equals("c")){
                p.calculerSalaires();
            }
            else if(reponse.toLowerCase().equals("q")){
                wantToQuit = true;
            }
        }

        System.out.println("Personnel contient " + p.tailleEmployes() + " employés.");




    }

}
