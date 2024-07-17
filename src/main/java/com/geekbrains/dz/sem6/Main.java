package com.geekbrains.dz.sem6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        int id = 0;
        String[] brands = new String[]{"Apple", "Asus", "Dell", "Lenovo", "Hp", "Sony", "Lg"};
        int[] displaySizes = new int[]{12, 14, 15, 16, 17};
        String[] processors = new String[]{"Atom", "Celeron", "Pentium", "Core i9", "Ryzen 3", "Ryzen 7"};
        String[] colors = new String[]{"Black", "White", "Grey", "Light grey", "Dark grey", "Beige"};
        int[] ramSizes = new int[]{4, 8, 16, 32};
        String[] driveTypes = new String[]{"SSD", "HDD", "SSHD"};
        Map<Integer, String> characteristics = new HashMap<Integer, String>();
        characteristics.put(1, "модель");
        characteristics.put(2, "размер дисплея");
        characteristics.put(3, "процессор");
        characteristics.put(4, "цвет");
        characteristics.put(5, "размер оперативной памяти");
        characteristics.put(6, "тип накопителя");
        int countLaptop = 70;
        Set<Laptop> laptops = new HashSet<Laptop>();
        System.out.println("\n В нашем магазине представлено " + countLaptop+ " ноутбуков: \n") ;
        for (int i = 0; i < countLaptop; i++) {
            laptops.add(creatListLaptop(id, brands, displaySizes, processors, colors, ramSizes, driveTypes));
        }
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
        greet();
        int[] filters = getCharacteristics(characteristics);
        Map <Integer,String> newFilters = getFilter(filters);
        Set <Laptop> laptopsForClient = getNewListLaptops(laptops, newFilters);
        if (laptopsForClient.isEmpty()) {
            System.out.println("К сожалению, по вашему запросу ничего не найдено.");
        }else {
            System.out.println("По вашему запросу найдены следующие устройства: ");
            System.out.println();
            for (Laptop laptop : laptopsForClient) {
                System.out.println(laptop);
            }
        }

    }

    private static Laptop creatListLaptop(int id, String[] brands, int[] displaySizes, String[] processors, String[] colors, int[] ramSizes, String[] driveTypes) {
        Random rnd = new Random();
        Laptop laptop = new Laptop();
        laptop.id = ++id;
        laptop.year = rnd.nextInt(2021, 2024);
        laptop.brand = brands[rnd.nextInt(brands.length)];
        laptop.displaySize = displaySizes[rnd.nextInt(displaySizes.length)];
        laptop.processor = processors[rnd.nextInt(processors.length)];
        laptop.color = colors[rnd.nextInt(colors.length)];
        laptop.ramSize = ramSizes[rnd.nextInt(ramSizes.length)];
        laptop.driveType = driveTypes[rnd.nextInt(driveTypes.length)];
        laptop.price = rnd.nextInt(1000, 2500);
        return laptop;
    }

    private static void greet() {
        System.out.println("\n Добрый день! Меня зовут Ирина, я специалист интернет-магазина.\n С удовольствием помогу Вам с выбором ноутбука!\n Чтобы я понимала, что для Вас имеет наибольшее значение при выборе, укажите, пожалуйста, несколько наиболее важных критериев из приведённых ниже.");
        System.out.println();
    }

    private static int[] getCharacteristics(Map<Integer, String> characteristics) {
        for (Map.Entry<Integer, String> entry : characteristics.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        System.out.println("Введите номера критериев через пробел: ");
        Scanner sc = new Scanner(System.in);
        String[] result = sc.nextLine().split(" ");
        int[] resultInt = new int[result.length];
        for (int i = 0; i < result.length; i++) {
            resultInt[i] = Integer.parseInt(result[i]);
        }
        return resultInt;
    }
    private static Map<Integer,String> getFilter(int[]filtrs) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> map1 = new HashMap<>();
        for (int i = 0; i < filtrs.length; i++) {

            if (filtrs[i] == 1) {
                System.out.println("Выберите модель ноутбука(Apple, Asus, Dell, Lenovo, Hp, Sony, Lg): ");
            } else if (filtrs[i] == 2) {
                System.out.println("Выберите размер дисплея(12, 14, 15, 16, 17): ");
            } else if (filtrs[i] == 3) {
                System.out.println("Выберите подходящий процессор(Atom, Celeron, Pentium, Core i9, Ryzen 3, Ryzen 7): ");
            } else if (filtrs[i] == 4) {
                System.out.println("Укажите интересующий Вас цвет(Black, White, Grey, Light grey, Dark gray, Beige): ");
            } else if (filtrs[i] == 5) {
                System.out.println("Укажите подходящий размер оперативной памяти(4, 8, 16, 32) :");

            } else if (filtrs[i] == 6) {
                System.out.println("Выберите желаемый тип накопителя(SSD, HDD, SSHDS): ");
            }
            String s = sc.nextLine();

            map1.put(filtrs[i], s);
        }
        return map1;
    }
    private static Set <Laptop> getNewListLaptops(Set<Laptop> laptops,Map <Integer,String> newFiltrs) {
        Set<Laptop> newLaptops = new HashSet<>();
        for (Laptop laptop : laptops) {
            int count = newFiltrs.size();
            for (Map.Entry<Integer, String> entry : newFiltrs.entrySet()) {
                if (entry.getKey()==1 && laptop.brand.equalsIgnoreCase(entry.getValue()) ||
                        entry.getKey() ==2 && laptop.displaySize==Integer.parseInt(entry.getValue()) ||
                        entry.getKey() ==3 && entry.getValue().equalsIgnoreCase(laptop.processor) ||
                        entry.getKey() ==4 && entry.getValue().equalsIgnoreCase(laptop.color) ||
                        entry.getKey() ==5 && laptop.ramSize == Integer.parseInt(entry.getValue()) ||
                        entry.getKey() ==6 && entry.getValue().equalsIgnoreCase(laptop.driveType))
                {
                    count--;
                }
            }
                if (count == 0) {
                    newLaptops.add(laptop);
                }
            }
        return newLaptops;
        }
}





