package com.geekbrains.Fam_tree.model.writer;

import com.geekbrains.Fam_tree.model.FamTree.FamilyTree;
import com.geekbrains.Fam_tree.model.Human.Human;

public class FileManager {
    private FileHandler fileHandler;

    public FileManager(FileHandler fileHandler){
        this.fileHandler = fileHandler;
    }

    public boolean saveToFile(String filename, FamilyTree familyTree) {
        fileHandler.setPath(filename);
        return fileHandler.save(familyTree);
    }

    public FamilyTree<Human> loadFromFile(String filePath) {
        fileHandler.setPath(filePath);
        return (FamilyTree<Human>) fileHandler.read();

    }
}
