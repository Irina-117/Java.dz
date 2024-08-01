package com.geekbrains.Fam_tree.Human;

import com.geekbrains.Fam_tree.FamTree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements Serializable,Comparable<Human>, FamilyTreeItem<Human> {
    private long id;

    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father) {
        this.id =-1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<Human>();

    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this(name ,gender, birthDate, null, null, null);
}

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        this(name ,gender, birthDate, null, mother, father);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public boolean addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }else if(parent.getGender().equals(Gender.Male)){
            setFather(parent);
        }
        return true;
    }
    public List<Human> getParents(){
        List<Human> parents = new ArrayList<>();
        if (father!=null){
            parents.add(father);

        }
        if (mother!=null){
            parents.add(mother);
        }
        return parents;
    }

     public int getAge () {
         if (deathDate == null) {
             return getPeriod(birthDate, LocalDate.now());
         } else{
         return getPeriod(birthDate,deathDate);
         }
     }

     private int getPeriod (LocalDate birthDate, LocalDate deathDate ){
            Period diff = Period.between(birthDate, deathDate);
            return diff.getYears();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info. append("id: " + id + "\n");
        info.append("Имя: " + name + "\n");
        info.append("Пол: "+ getGender() + "\n");
        info.append("Возраст:" + getAge() + "\n");
        info.append("Мать: " + getInfoMother() + "\n");
        info.append("Отец: " + getInfoFather() + "\n");
        info.append("Дети: " + getInfoChildren() + "\n");
        info.append ("Супруг/супруга: " + getInfoSpouse() + "\n");
        return info.toString();
    }
    private String getInfoMother() {
        if (this.mother != null){
            return this.mother.getName();
        }
        return "неизвестна";
    }

    private String getInfoFather() {
        if (this.father !=null){
            return this.father.getName();
        }
        return "неизвестен";
    }

    private String getInfoChildren() {
        StringBuilder res = new StringBuilder();
        res.append(" ");
        if (children.size()!=0 ) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("отсутствует");
        }
        return res.toString();
    }
    private String getInfoSpouse() {
        if (this.spouse != null){
            return this.spouse.getName();
        }
        return "отсутствует";
    }
    @Override
    public boolean equals(Object obj) {
        if (this ==obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Human human = (Human) obj;
        return Objects.equals(name, human.name) && gender==human.gender && Objects.equals(birthDate,human.birthDate) && Objects.equals(deathDate,human.deathDate) && Objects.equals(spouse,human.spouse)&& Objects.equals(children,human.children) && Objects.equals(mother,human.mother) && Objects.equals(father,human.father);
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}


