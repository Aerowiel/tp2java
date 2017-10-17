package tp2.service;

import java.io.*;

public class Saver {

    // SERIALIZE / DESERIALIZE OBJECTS

    public static Object deserializeObject(String pathToObject){
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/saves/personnel.ser");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
            Object obj = objectInputStream.readObject();
            objectInputStream.close();
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void serializeObject(String whereToSave,Object objectToSerialize ){
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream("src/saves/personnel.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectToSerialize);
            fileOutputStream.close();
            objectOutputStream.close();
            System.out.println("Objet sauveguardé avec succés");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
