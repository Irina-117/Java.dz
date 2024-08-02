package com.geekbrains.Fam_tree.FamTree;

public interface FamilyTreeItem<E> extends Comparable<E>{
    int getAge();
    String getName();
    void setId(long id);
    E getSpouse();
    void setSpouse(E item);
    long getId();
    boolean addParent(E parent);
    boolean addChild(E child);



}
