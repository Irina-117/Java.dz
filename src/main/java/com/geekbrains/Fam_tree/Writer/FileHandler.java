package com.geekbrains.Fam_tree.Writer;


import java.io.*;

public class FileHandler implements Writer{
private String path;

public FileHandler(String path) {
    this.path=path;
}


    @Override
    public boolean save(Serializable obj) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
            oos.writeObject(obj);
            System.out.println("Сохранение файла произошло успешно");
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(){
    try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
        System.out.println("Чтение файла произошло успешно");
        return ois.readObject();
    }
    catch(Exception e){
        e.printStackTrace();
        return null;
    }
    }
}
