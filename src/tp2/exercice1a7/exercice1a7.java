package tp2.exercice1a7;

import tp2.service.Asker;

public class exercice1a7 {
    public static void main(String[] args){

        CustomFileScanner customFileScanner = new CustomFileScanner();
        CustomFileWriter customFileWriter = new CustomFileWriter();

        // Voici le TP2 j'ai choisi de regrouper tous les exercices au lieu de créer des packages à chaque fois car je trouve ça plus cohérent & "amusant"
        // Il vous suffit de dé-commenter l'exercice que vous souhaitez tester et de commenter le reste (sauf les 2 déclarations ci-dessus)

        // Exercice 1 Changer le 2éme argument en false si vous souhaitez qu'il n'y ai pas de récursivité
        //customFileScanner.getAllFilesInFolder(customFileScanner.askFolderUri(), Asker.askIfRecursive());

        // Exercice 2 Changer le 3éme argument en false si vous souhaitez qu'il n'y ai pas de récursivité
        //customFileScanner.getAllFilesWithExtension(customFileScanner.askFolderUri(), customFileScanner.askExtension(), Asker.askIfRecursive());

        // Exercice 3
        //customFileScanner.isFileOrFolder();

        // Exercice 4
        //customFileWriter.writeToFile(customFileScanner.askFileUri("file"));

        // Exercice 6
        //customFileWriter.copyFileToFile(customFileScanner.askFileUri("Source file"), customFileScanner.askFileUri("Destination file"));

        // Exercice 7
        //customFileWriter.getImageFromUrl(Asker.askForUrl(),  customFileScanner.askFolderUri());

    }
}
