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

    public ConsoleUI() {
        scanner=new Scanner(System.in);
        presenter = new Presenter(this);
        flag=true;
    }

    @Override
    public void start() {
        while(flag){
            System.out.println("1. Добавить объект в семейное дерево" );
            System.out.println("2. Свадьба" );
            System.out.println("3. Развод" );
            System.out.println("4. Добавить ребёнка" );
            System.out.println("5. Добавить родителя" );
            System.out.println("6. Отсортировать по имени" );
            System.out.println("7. Отстортировать по возрасту" );
            System.out.println("8. Получить семейное дерево" );
            System.out.println("9. Завершить работу" );
            String choice =scanner.nextLine();

            switch(choice){
                case "1":
                    addHuman();
                    break;
                case "2":
                    setWedding();
                    break;
                case "3":
                    setDivorce();
                    break;
                case "4":
                    addChild();
                    break;
                case "5":
                    addParent();
                    break;
                case "6":
                    sortByName();
                    break;
                case "7":
                    sortByAge();
                    break;
                case "8":
                    getInfo();
                    break;
                case "9":
                    finish();
                    break;
                default: error();
            }

        }


    }

    private void addHuman() {
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

    private void setWedding() {
        String name1,name2;
        System.out.println("Введите имена объектов, которые хотите сделать супругами: \n Введите первое имя:");
        name1= scanner.nextLine();
        System.out.println("Введите второе имя:");
        name2=scanner.nextLine();
        presenter.setWedding(name1,name2);
    }

    private void setDivorce() {
        String name1,name2;
        System.out.println("Введите имена объектов, брак которых хотите расторгнуть: \nВведите первое имя:");
        name1= scanner.nextLine();
        System.out.println("Введите второе имя:");
        name2=scanner.nextLine();
        presenter.setDivorce(name1,name2);
    }

    private void addChild() {
        String nameHuman, nameChild;
        System.out.println("Введите имя обьекта, которому хотите добавить ребёнка:");
        nameHuman= scanner.nextLine();
        System.out.println("Введите имя объекта, которого хотите сделать ребёнком:");
        nameChild= scanner.nextLine();
        presenter.addChild(nameHuman,nameChild);
    }

    private void addParent() {
        String nameHuman,nameParent;
        System.out.println("Введите имя объекта, которому хотите добавить родителя" );
        nameHuman=scanner.nextLine();
        System.out.println("Введите имя объекта, которого ходите сделать родителем");
        nameParent= scanner.nextLine();
        presenter.addParent(nameHuman, nameParent);

    }

    private void sortByName() {
        presenter.sortByName();
    }

    private void sortByAge() {
        presenter.sortByAge();
    }

    public void getInfo() {
        presenter.getInfo();
    }

    private void finish() {
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
