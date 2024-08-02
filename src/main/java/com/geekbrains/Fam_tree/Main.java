package com.geekbrains.Fam_tree;

import com.geekbrains.Fam_tree.FamTree.FamilyTree;
import com.geekbrains.Fam_tree.FamTree.HumanService;
import com.geekbrains.Fam_tree.Human.Gender;
import com.geekbrains.Fam_tree.Human.Human;
import com.geekbrains.Fam_tree.Human.HumanBuilder;
import com.geekbrains.Fam_tree.Writer.FileHandler;

import java.time.LocalDate;



public class Main {
    final static String path = "src/main/java/com/geekbrains/Fam_tree/Writer/file.txt";
    public static void main(String[] args) {
//        FamilyTree famTree = read();
        HumanService<Human> famTree = getFamilyTree();
        System.out.println(famTree.getInfo());
//        save(famTree);
        System.out.println("-----------------");
        famTree.sortByName();
        System.out.println("Объекты отсортированы по имени \n"+famTree.getInfo());
        System.out.println("-----------------");
        famTree.sortByAge();
        System.out.println("Объекты отсортированы по возрасту \n" + famTree.getInfo());



    }
    private static FamilyTree read (){
        FileHandler fh = new FileHandler(path);
        return (FamilyTree) fh.read();
    }

    private static void save(FamilyTree famTree) {
        FileHandler fh =new FileHandler(path);
        fh.save(famTree);
    }



    private static HumanService<Human> getFamilyTree() {
        HumanService<Human> MyFamTree = new HumanService<>();
        MyFamTree.addHuman("Ирина", Gender.Female,LocalDate.of(1994,10,28));
        MyFamTree.addHuman("Илья",Gender.Male,LocalDate.of(1993,4,25));
        MyFamTree.setWedding("Ирина","Илья");
        MyFamTree.addHuman("Мирон",Gender.Male,LocalDate.of(2022,4,18));
        MyFamTree.addChild("Ирина","Мирон");
        MyFamTree.addChild("Илья","Мирон");
        MyFamTree.addParent("Мирон","Ирина");
        MyFamTree.addParent("Мирон","Илья");
        MyFamTree.addHuman("Любовь", Gender.Female,LocalDate.of(1959,6,5));
        MyFamTree.addHuman("Сергей",Gender.Male,LocalDate.of(1957,10,12));
        MyFamTree.setWedding("Сергей","Любовь");
        MyFamTree.addChild("Любовь","Ирина");
        MyFamTree.addChild("Сергей","Ирина");
        MyFamTree.addParent("Ирина","Сергей");
        MyFamTree.addParent("Ирина","Любовь");
        MyFamTree.addHuman("Светлана", Gender.Female,LocalDate.of(1971,12,18));
        MyFamTree.addHuman("Александр",Gender.Male,LocalDate.of(1971,3,9));
        MyFamTree.setWedding("Александр","Светлана");
        MyFamTree.addChild("Светлана","Илья");
        MyFamTree.addChild("Александр","Илья");
        MyFamTree.addParent("Илья","Александр");
        MyFamTree.addParent("Илья","Светлана");
        return MyFamTree;
    }


}
