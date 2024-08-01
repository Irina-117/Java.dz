package com.geekbrains.Fam_tree;

public interface FamilyTreeItem<E> extends Comparable<E>{
    int getAge();
    String getName();
    void setId(long id);
    E getSpouse();
    void setSpouse(E item);
    long getId();



}
