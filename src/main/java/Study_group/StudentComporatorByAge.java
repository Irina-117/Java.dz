package Study_group;

import java.util.Comparator;

public class StudentComporatorByAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getAge() - o2.getAge();
    }
}
