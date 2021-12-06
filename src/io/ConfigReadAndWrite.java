package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReadAndWrite<E> {

    public void writeToFile(String path, List<E> t){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(t);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<E> readFromFile(String path){
        try {
            File file = new File(path);
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileInputStream fileInputStream = new FileInputStream(path);
            List<E> eList;
            if (fileInputStream.available() != 0) {
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                eList = (List<E>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
                return eList;
            }
            return new ArrayList<>();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



}