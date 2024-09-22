package Exeption;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Certification {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добрый день. Введите, пожалуйста свои данные через пробел:ФИО, дата рождения, номер телефона, Ваш пол.");
        String date = scanner.nextLine();

        try{
            String [] element = date.split(" ");
            if(element.length!=6){
                System.out.println("Некорректные данные");
            }
            String surname = element[0];
            String name = element[1];
            String midname = element[2];
            LocalDate dateBirth =parseDate(element[3]);
            Long phoneNumber = parsePhoneNumber(element[4]);
            char gender = parseGender(element[5]);

            
            writeToFile(name,surname,midname,dateBirth,phoneNumber,gender);

        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка " + e.getMessage());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static LocalDate parseDate (String dateBirthStr) throws DateTimeParseException {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return LocalDate.parse(dateBirthStr, dateTimeFormatter);
        }
        catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Неверный формат даты");
        }
    }


    private static long parsePhoneNumber(String phoneNumberStr) {
        try{
            return Long.parseLong(phoneNumberStr);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("Неверный формат номера телефона");
        }

    }
    private static char parseGender(String genderStr) {

        if (genderStr.length() != 1 || !(genderStr.equalsIgnoreCase("f") || genderStr.equalsIgnoreCase("m")))  {
            throw new IllegalArgumentException("Неверный формат пола.");
        }
        return genderStr.toLowerCase().charAt(0);
    }
    private static void writeToFile(String surname, String name,
                                    String midname, LocalDate dateBirth,
                                    long phoneNumber, char gender)
            throws IOException {
        String fileName = surname + ".txt";
        String line = String.format("%s %s %s %s %d %c", surname,
                name, midname, dateBirth, phoneNumber, gender);

        try (BufferedWriter writer = new BufferedWriter(new
                FileWriter(fileName, true))) {
            writer.write(line);
            writer.newLine();
        }
    }
}


