package com.geekbrains.Fam_tree.FamTree;

import com.geekbrains.Fam_tree.Human.HumanComporatorByAge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable,Iterable<E> {
    private List<E>familyTree;

    private long humansId;
    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void add(E human) {
        this.familyTree.add(human);
        human.setId(humansId++);
    }
    public E findByName(String name){

        for(E human:familyTree){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public boolean SetWedding(E human1,E human2){
        if (human1.getSpouse()==null &&  human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }
    public boolean SetDivorce(E human1, E human2){
        if (human1.getSpouse()!=null &&  human2.getSpouse()!=null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;

    }

    public E findById(long id){
        for (E human:familyTree){
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
//Добавила вывод через цикл Foreach

    public String getInfoByHuman(){
        StringBuilder str = new StringBuilder();
        str.append("Список обектов семейного дерева:");
        str.append("\n");
        for(E human1:familyTree){
            str.append(human1);
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public Iterator<E> iterator() {return new HumanIterator<>(familyTree);
    }

    public void sortByName(){Collections.sort(familyTree);}

    public void sortByAge(){Collections.sort(familyTree, new HumanComporatorByAge<>());}

}
