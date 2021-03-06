package tp2.exercice1a7;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class CustomFileWriter {

    private final String KEYWORD_TO_QUIT = "quit";

    private Scanner scanner;

    public CustomFileWriter(){
        scanner = new Scanner(System.in);
    }

    public boolean AskWritingStyle(){
        System.out.println("Overwrite file or appends new line(s) ? (O/A) :");

        while(!scanner.hasNext("O|o|A|a")){
            System.out.println("Please enter a valid writing style OVERWRITE (O/o) or APPEND (A/a) :");
            scanner.next();
        }

        if(scanner.nextLine().toLowerCase().equals("o")){
            System.out.println("Writing mode : OVERWRITE");
            return false;
        }
        else{
            System.out.println("Writing mode : APPEND");
            return true;
        }


    }

    public void writeToFile(File file) {
        String fileName = file.getName();

        System.out.println("Opening : " + fileName + "...");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file, AskWritingStyle());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Ready to write ! Write 'quit' to save & close file.");
        System.out.println("New line : ");
        String line = scanner.nextLine();

        while(!line.toLowerCase().equals(KEYWORD_TO_QUIT)){
            // On continue à écrire
            try {
                fileWriter.write(line + System.getProperty( "line.separator" ));
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("New line : ");
            line = scanner.nextLine();
        }

        //On ferme le flux...
        System.out.println("Saving and closing file " + fileName + "...");
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copyFileToFile(File sourceFile, File destinationFile) {
        try {
            FileChannel src = new FileInputStream(sourceFile).getChannel();
            FileChannel dest = new FileOutputStream(destinationFile, true).getChannel();
            dest.position( dest.size() );

            //On transfere la source vers la destination
            src.transferTo(0, src.size(), dest);

            //On ferme le flux...
            src.close();
            dest.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Successfully copied " + sourceFile.getName() + " content into " + destinationFile.getName() + " !");
    }

    // Fonction inutile dans le cadre du TP mais je la laisse là
    public void moveFileToFolder(File file, File destinationFolder){
        try {
            InputStream src = new FileInputStream(file);
            OutputStream dest = new FileOutputStream(destinationFolder + "\\" + file.getName());
            byte[] buffer = new byte[8192];
            int length;

            // Tant qu'il y a des trucs à transférer on écrit dans la destination
            while ((length = src.read(buffer)) > 0) {
                dest.write(buffer, 0, length);
            }
            System.out.println("Successfully copied " + file.getName() + " to " + destinationFolder + "!");

            //On ferme le flux...
            src.close();
            dest.close();
            System.out.println("Successfully closed input & output streams !");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getImageFromUrl(String urlToImg, File destinationFolder){

        System.out.println("Image name :");
        String wantedName = scanner.nextLine();
        try {
            URL url = new URL(urlToImg);
            InputStream src = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream dest = new ByteArrayOutputStream();

            // On utilise un buffer de 8192 bytes, c'est plus rapide...
            byte[] buffer = new byte[8192];
            int length;

            // Tant qu'il y a des trucs à transférer on écrit dans la destination
            while ((length = src.read(buffer)) > 0)
            {
                dest.write(buffer, 0, length);
            }

            // On ferme le flux
            src.close();
            dest.close();

            // On convertit en tableau de bytes
            byte[] image = dest.toByteArray();

            // Il est important de préciser le nom du fichier de destination... sinon erreur
            FileOutputStream fileOutputStream = new FileOutputStream(destinationFolder + "\\" + wantedName + ".png");

            // On écrit l'image dans l'output stream
            fileOutputStream.write(image);

            // On ferme le flux
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
