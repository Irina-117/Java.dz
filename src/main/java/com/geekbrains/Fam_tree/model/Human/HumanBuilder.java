package com.geekbrains.Fam_tree.model.Human;

import com.geekbrains.Fam_tree.model.FamTree.FamilyTreeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder<E extends FamilyTreeItem<E>>{
    private int genId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private List<E> children;

    public HumanBuilder() {
        creatHuman();
    }

    private void creatHuman() {
        human = new Human();
    }

    public HumanBuilder<E> setName(String name) {
        this.name=name;
        return this;
    }

    public HumanBuilder<E> setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder<E> setBirthDate(LocalDate birthDate) {
        this.birthDate=birthDate;
        return this;

    }
    private void setChildren(){
        human.setChildren(new ArrayList<>());
    }


    private void nextId() {
        human.setId(genId++);
    }
    private void creatName(){
        human.setName(name);
    }
    private void creatGender(){
        human.setGender(gender);
    }
    private void creatBirthDate(){
        human.setBirthDate(birthDate);
    }

    public void setHuman(Human human) {
        this.human = human;
    }
    public E build(){
        nextId();
        creatHuman();
        creatName();
        creatGender();
        creatBirthDate();
        setChildren();
        return  (E) human;
    }
}
