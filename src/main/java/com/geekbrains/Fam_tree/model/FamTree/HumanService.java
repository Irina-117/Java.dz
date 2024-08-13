package com.geekbrains.Fam_tree.model.FamTree;

import com.geekbrains.Fam_tree.model.Human.Gender;
import com.geekbrains.Fam_tree.model.Human.HumanBuilder;

import java.time.LocalDate;


public class HumanService<E extends FamilyTreeItem<E>> {
    private FamilyTree<E> familyTree;
    private HumanBuilder<E> humanBuilder;

    public HumanService() {
        familyTree = new FamilyTree<>();
        humanBuilder=new HumanBuilder<>();
    }
    public void addHuman(String name, Gender gender, LocalDate birthDate){
        E human =  humanBuilder.setName(name).setGender(gender).setBirthDate(birthDate).build();
        familyTree.add(human);
    }
    public boolean setWedding(String name1,String name2){
        return familyTree.SetWedding(familyTree.findByName(name1), familyTree.findByName(name2) );
    }
    public boolean setDivorce(String name1,String name2){
        return familyTree.SetDivorce(familyTree.findByName(name1), familyTree.findByName(name2));

    }
    public boolean addChild(String nameHuman,String nameChild){
        return familyTree.findByName(nameHuman).addChild(familyTree.findByName(nameChild));
    }
    public boolean addParent(String nameHuman,String nameParent){
        return familyTree.findByName(nameHuman).addParent(familyTree.findByName(nameParent));
    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByAge(){
        familyTree.sortByAge();
    }
    public String getInfo(){
        return familyTree.getInfo();
    }


}
