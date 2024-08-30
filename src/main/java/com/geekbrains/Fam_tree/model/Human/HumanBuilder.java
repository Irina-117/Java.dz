package com.geekbrains.Fam_tree.model.Human;

import com.geekbrains.Fam_tree.model.FamTree.FamilyTreeItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanBuilder{
    private int genId;
    private Human human;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private List<Human> children;

    public HumanBuilder() {
        creatHuman();
    }

    private void creatHuman() {
        human = new Human();
    }

    public HumanBuilder setName(String name) {
        this.name=name;
        return this;
    }

    public HumanBuilder setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public HumanBuilder setBirthDate(LocalDate birthDate) {
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
    public Human build(){
        nextId();
        creatHuman();
        creatName();
        creatGender();
        creatBirthDate();
        setChildren();
        return human;
    }
}
