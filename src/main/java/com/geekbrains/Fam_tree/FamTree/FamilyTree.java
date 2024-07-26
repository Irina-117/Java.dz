package com.geekbrains.Fam_tree.FamTree;

import com.geekbrains.Fam_tree.Human.Human;
import com.geekbrains.Fam_tree.Human.HumanComporatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human>familyTree;
    private long humansId;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }
    public void add(Human human) {
        this.familyTree.add(human);
        human.setId(humansId++);
    }

    public List<Human> findByName(String name){
        List<Human> humans = new ArrayList<>();
        for(Human human:familyTree){
            if (human.getName().equals(name)){
                humans.add(human);
            }
        }
        return humans;
    }
    public boolean SetWedding(Human human1,Human human2){
        if (human1.getSpouse()==null &&  human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean SetDivorce(Human human1, Human human2){
        if (human1.getSpouse()!=null &&  human2.getSpouse()!=null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;

    }
    public Human findById(long id){
        for (Human human:familyTree){
            if (human.getId()==id){
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append("В семейном дереве " + familyTree.size() + " объектов. \n");
        for (int i =0;i<familyTree.size();i++){
            str.append(familyTree.get(i));
            str.append("\n");
        }
        return str.toString();
    }
    public void sortByName(){
        Collections.sort(familyTree);

    }
    public void sortByAge(){
        Collections.sort(familyTree, new HumanComporatorByAge());
    }

}
