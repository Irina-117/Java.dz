package com.geekbrains.Fam_tree.presenter;

import com.geekbrains.Fam_tree.model.FamTree.HumanService;
import com.geekbrains.Fam_tree.model.Human.Gender;
import com.geekbrains.Fam_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private HumanService service;

    public Presenter(View view) {
        this.view = view;
        service = new HumanService();
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name,gender,birthDate);
        getInfo();
    }

    public void setWedding(String name1, String name2) {
        service.setWedding(name1,name2);
        getInfo();
    }

    public void setDivorce(String name1, String name2) {
        service.setDivorce(name1,name2);
        getInfo();
    }

    public void addChild(String nameHuman, String nameChild) {
        service.addChild(nameHuman,nameChild);
        getInfo();
    }

    public void addParent(String nameHuman, String nameParent) {
        service.addParent(nameHuman,nameParent);
        getInfo();
    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getInfo();
    }

    public void getInfo() {
        String answer = service.getInfo();
        view.printAnswer(answer);
    }
}
