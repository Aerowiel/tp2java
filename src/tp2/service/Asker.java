package tp2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asker {
    static Scanner scanner = new Scanner(System.in);

    public static String askForUrl(String... suffix){
        String systemOutPrefix = "";
        if(suffix.length > 0){
            systemOutPrefix = suffix[0];
        }

        System.out.println("Quelle est l'url " + systemOutPrefix + " ? :");
        return scanner.nextLine();
    }

    public static int askChoiceForMenu(){
        int choix;
        boolean nombreCorrect = false;
        do{
            while(!scanner.hasNextInt()){
                System.out.println("Ceci n'est pas un nombre ...");
                System.out.print("Votre choix : ");
                scanner.next();
            }

            choix = scanner.nextInt();

            if(choix >= 1 && choix <= 6){
                nombreCorrect = true;
            }else{
                System.out.println("Le nombre doit être compris entre 1 & 6 !");
                System.out.print("Votre choix : ");
            }

        }while(!nombreCorrect);

        return choix;
    }

    public static Object[] askForEmployeAttributes(){
        List<Object> attributes = new ArrayList<>();


        System.out.println("Nom : ");
        attributes.add(scanner.next());

        System.out.println("Prenom : ");
        attributes.add(scanner.next());

        System.out.println("Age : ");
        while(!scanner.hasNextInt()){
            System.out.println("Veuillez rentrer un nombre : ");
            System.out.println("Age :");
            scanner.next();
        }
        attributes.add(scanner.nextInt());

        System.out.println("Année d'entrée :");
        attributes.add(scanner.next());

        System.out.println("Unité : ");
        while(!scanner.hasNextDouble()){
            System.out.println("Veuillez rentrer un nombre : ");
            System.out.println("Unité : ");
            scanner.next();
        }
        attributes.add(scanner.nextDouble());

        return attributes.toArray();
    }

    public static boolean askIfRecursive(){

        System.out.println("Recursive ? (Y/y N/n)");
        while(!scanner.hasNext("Y|y|N|n")){
            System.out.println("Recursive ? (Y/y N/n)");
            scanner.nextLine();
        }

        if(scanner.nextLine().toLowerCase().equals("y")){
            return true;
        }
        else{
            return false;
        }

    }
}
