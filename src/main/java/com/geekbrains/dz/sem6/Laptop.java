package com.geekbrains.dz.sem6;

public class Laptop {
    int id;
    int year;
    String brand;
    int displaySize; // 15,6 12, 14, 17
    String processor;// Atom, Celeron, Pentium,Core i9,Ryzen 3, Ryzen 7
    String color; //black, white,grey,
    int ramSize;// опер память 4,8,16,32
    String driveType;//тип накопителя  HDD SSD SSHDS
    int price;

    @Override
    public String toString() {
        return String.format("Laptop %s %s %d release:  %n Diagonal %d inches/  Processor %s/  RAM %d Gb/  %s/ Price %d USD.%n ",   brand, color, year, displaySize, processor,  ramSize, driveType, price);
    }
}
