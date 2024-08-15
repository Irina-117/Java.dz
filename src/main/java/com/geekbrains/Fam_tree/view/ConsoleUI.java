package com.geekbrains.Fam_tree.view;

import com.geekbrains.Fam_tree.model.Human.Gender;
import com.geekbrains.Fam_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View {
    Scanner scanner;
    Presenter presenter;
    boolean flag;
    private MainMenu menu;

    public ConsoleUI() {
        scanner=new Scanner(System.in);
        presenter = new Presenter(this);
        flag=true;
        menu=new MainMenu(this);
    }

    @Override
    public void start() {
        sayHello();
        while(flag){
            System.out.println(menu.menu());
            String strChoice = scanner.nextLine();
            check(strChoice);
        }


    }
    private void check(String strChoice){
        if (consistOfNumbers(strChoice)){
            int choice = Integer.parseInt(strChoice);
            if(sizeCheck(choice)){
                menu.execute(choice);
            }else{
                System.out.println("Данной команды не существует. Попробуйте ещё раз.\n");
            }

        }else{System.out.println("Данной команды не существует. Попробуйте ещё раз.\n");}



    }
    private boolean sizeCheck(int choice) {
        if (choice<= menu.size()){
            return true;
        }
        return false;
    }

    private boolean consistOfNumbers(String strChoice) {
        if (strChoice.matches("[0-9]+")){
            return true;
        }else{return false;}
    }


    private void sayHello() {
        System.out.println("Добрый день!\n");
    }

    public void addHuman() {
        String name;
        Gender gender;
        LocalDate birthDate;
        String strFormatter= "dd.MM.yyyy";
        System.out.println("Введите имя");
        name = scanner.nextLine();
        System.out.println("Выберите пол: \n 1. Мужской \n2. Женский ");
        String choice = scanner.nextLine();
        if (choice.equals("1")){
            gender = Gender.Male;
        }else{gender = Gender.Female;}
        System.out.println("Введите дату рождения в формате: dd.MM.yyyy");
        String strDB= scanner.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(strFormatter);
        birthDate = LocalDate.parse(strDB,dtf);
        presenter.addHuman(name,gender,birthDate);
    }

    public void setWedding() {
        String name1,name2;
        System.out.println("Введите имена объектов, которые хотите сделать супругами: \n Введите первое имя:");
        name1= scanner.nextLine();
        System.out.println("Введите второе имя:");
        name2=scanner.nextLine();
        presenter.setWedding(name1,name2);
    }

    public void setDivorce() {
        String name1,name2;
        System.out.println("Введите имена объектов, брак которых хотите расторгнуть: \nВведите первое имя:");
        name1= scanner.nextLine();
        System.out.println("Введите второе имя:");
        name2=scanner.nextLine();
        presenter.setDivorce(name1,name2);
    }

    public void addChild() {
        String nameHuman, nameChild;
        System.out.println("Введите имя обьекта, которому хотите добавить ребёнка:");
        nameHuman= scanner.nextLine();
        System.out.println("Введите имя объекта, которого хотите сделать ребёнком:");
        nameChild= scanner.nextLine();
        presenter.addChild(nameHuman,nameChild);
    }

    public void addParent() {
        String nameHuman,nameParent;
        System.out.println("Введите имя объекта, которому хотите добавить родителя" );
        nameHuman=scanner.nextLine();
        System.out.println("Введите имя объекта, которого ходите сделать родителем");
        nameParent= scanner.nextLine();
        presenter.addParent(nameHuman, nameParent);

    }

    public void sortByName() {
        presenter.sortByName();
    }

   public void sortByAge() {
        presenter.sortByAge();
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void finish() {
        System.out.println("Работа успешно завершена");
        flag=false;
    }





    private void error() {
        System.out.println("Вы ввели неверные данные. Попробуйте ещё раз.");
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
