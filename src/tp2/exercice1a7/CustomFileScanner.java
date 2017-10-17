package tp2.exercice1a7;

import java.io.File;
import java.util.Scanner;

public class CustomFileScanner {

    private Scanner scanner = new Scanner(System.in);

    // Cette fonction retourne uniquement le 'File' si c'est un dossier
    public File askFolderUri(){
        System.out.println("Folder uri :");
        File file = new File(scanner.nextLine());

        // Si le fichier n'existe pas ou qu'il c'est un dossier
        while(!file.exists() || !file.isDirectory()){

            if(!file.exists()){  // Si le fichier n'existe pas
                System.out.println("Uri is pointing on nothing, please enter a valid folder path !");
            }
            else if (!file.isDirectory()){ // Si ce n'est pas un dossier
                System.out.println("Uri is pointing on a file, please enter a folder path !");

            }
            System.out.println("Folder uri :");
            file = new File(scanner.nextLine());
        }
        return file;

    }

    // Fonction qui demande l'extension
    public String askExtension(){
        System.out.println("Extension : ");
        String extension = scanner.nextLine();
        while(!extension.substring(0,1).equals(".") || extension.contains(" ")){
            System.out.println("Please enter a valid extension ! ");
            System.out.println("Extension : ");
            extension = scanner.nextLine();
        }

        return extension;
    }

    // Cette fonction retourne uniquement le 'File' si c'est un fichier
    public File askFileUri(String... prefix){
        //Prefix pour le system out, optionnel...
        String systemOutPrefix = "";

        if (prefix.length > 0){
            systemOutPrefix = prefix[0] + " ";
        }

        System.out.println(systemOutPrefix + "uri :");
        File file = new File(scanner.nextLine());

        // Vérification du type du file et si il existe
        while(!file.exists() || file.isDirectory()){
            if(!file.exists()){
                System.out.println("Uri is pointing on nothing, please enter a valid folder path :");
                file = new File(scanner.nextLine());
            }
            else if (file.isDirectory()){
                System.out.println("Uri is pointing on a folder, please enter file path :");
                file = new File(scanner.nextLine());
            }
        }
        return file;
    }

    // Fonction qui détermine si c'est un fichier ou un dossier
    public void isFileOrFolder(){

        System.out.println("File uri :");
        File file = new File(scanner.nextLine());


        if(!file.exists()){ // Si le fichier n'existe pas
            System.out.println("Uri is pointing on nothing.");
        }
        else if (file.isDirectory()){ // Si le fichier est un dossier
            System.out.println("Uri is pointing on a folder.");
        }
        else{ // Si le fichier est un fichier
            System.out.println("Uri is pointing on a file.");
        }
    }


    // Retourne tous les fichiers dans le dossier passé en paramètre, si recursive est à true les sous-dossiers seront aussi pris en compte
    public void getAllFilesInFolder(File directory, boolean... recursive){

        boolean isRecursive = false;
        if(recursive.length > 0){
            isRecursive = recursive[0];
        }

        File[] files = directory.listFiles();

        for(File file : files){

            if(file.isFile()){
                System.out.println("File : "  + file.getName());
            }
            else if(file.isDirectory() && isRecursive){
                System.out.println("Directory : "  + file.getName() + " contains : ");
                getAllFilesInFolder(new File(file.getPath()), isRecursive);
            }
        }

    }

    // Retourne tous les fichiers avec l'extension demandé dans le dossier passé en paramètre, si recursive est à true les sous-dossiers seront aussi pris en compte
    public void getAllFilesWithExtension(File directory, String extension, boolean... recursive){

        boolean isRecursive = false;
        if(recursive.length > 0){
            isRecursive = recursive[0];
        }
        //System.out.println("Searching '" + directory.getName() + "' for files with extension '" + extension +  "'...");
        File[] files = directory.listFiles();

        for(File file : files){

            if(file.isFile() ){
                if(file.getName().contains(extension))
                {
                    System.out.println("File : "  + file.getName());
                }
            }
            else if(file.isDirectory() && isRecursive){
                System.out.println("Directory : "  + file.getName() + " contains : ");
                getAllFilesWithExtension(new File(file.getPath()), extension, isRecursive);
            }
        }

    }





}
