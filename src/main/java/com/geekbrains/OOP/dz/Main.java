package com.geekbrains.OOP.dz;

import java.time.LocalDate;

import static com.geekbrains.OOP.dz.Gender.Female;

public class Main {
    public static void main(String[] args) {
    FamilyTree famTree = new FamilyTree();
    Human irina = new Human("Ирина",Gender.Female, LocalDate.of(1994, 10,28) );
    Human illia = new Human ("Илья", Gender.Male, LocalDate.of(1993, 4,25) );
    famTree.add(irina);
    famTree.add(illia);
    famTree.SetWedding(irina,illia);

    Human miron = new Human("Мирон", Gender.Male, LocalDate.of(2022, 4,18), irina,illia );
    famTree.add(miron);
    irina.addChild(miron);
    illia.addChild(miron);

    Human grandMother = new Human("Любовь", Gender.Female, LocalDate.of(1959, 6,5));
    Human grandFather = new Human("Сергей", Gender.Male, LocalDate.of(1957, 10,12));
    famTree.add(grandMother);
    famTree.add(grandFather);
    famTree.SetWedding(grandMother,grandFather);
    grandFather.addChild(irina);
    grandMother.addChild(irina);
    irina.addParent(grandFather);
    irina.addParent(grandMother);


    Human grandMother1 = new Human("Светлана", Gender.Female, LocalDate.of(1971, 12,18));
    Human grandFather1 = new Human("Александр", Gender.Male, LocalDate.of(1971, 3,9));
    famTree.add(grandMother1);
    famTree.add(grandFather1);
    famTree.SetWedding(grandMother1,grandFather1);
    grandMother1.addChild(illia);
    grandFather1.addChild(illia);
    illia.addParent(grandMother1);
    illia.addParent(grandFather1);


    Human sasha = new Human("Александра", Gender.Female, LocalDate.of(1988, 9,13));
    famTree.add(sasha);
    sasha.addParent(grandFather1);
    sasha.addParent(grandMother1);
    Human mark = new Human("Марк", Gender.Male, LocalDate.of(2016, 3,3));
    Human arina = new Human("Арина", Gender.Female, LocalDate.of(2010, 1,9));
    famTree.add(mark);
    famTree.add(arina);
    arina.addParent(sasha);
    mark.addParent(sasha);
    sasha.addChild(mark);
    sasha.addChild(arina);

    Human dima = new Human("Дмитрий", Gender.Male, LocalDate.of(1980, 1,12));
    famTree.add(dima);
    famTree.SetWedding(sasha,dima);
    dima.addChild(arina);
    dima.addChild(mark);
    mark.addParent(dima);
    arina.addParent(dima);
    famTree.SetDivorce(dima,sasha);
        System.out.println(famTree);
    }
}
