package Study_group;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
       StudentService studentService = new StudentService();
       studentService.addStudent("Ирина",18);
       studentService.addStudent("Мирон",17);
       studentService.addStudent("Арина",19);
       studentService.addStudent("Светлана",20);
       studentService.addStudent("Виктория",21);
       studentService.addStudent("Генрих",22);

        System.out.println(studentService.getInfoByStudent());
        studentService.sortByName();
        System.out.println(studentService.getInfoByStudent());
        studentService.sortByAge();
        System.out.println(studentService.getInfoByStudent());
    }


}
