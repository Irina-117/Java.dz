package Study_group;

import java.util.*;

public class StudyGroup implements Iterable {
    private int genId;
    private List<Student> students;

    public StudyGroup() {
        students = new ArrayList<>();
    }
    public  void addStudent (Student student){
        student.setId(genId++);
        students.add(student);
    }

    public void sortByName(){
        Collections.sort(students);
    }

    public void sortByAge(){
        Collections.sort(students,new StudentComporatorByAge());
    }

    @Override
    public Iterator<Student> iterator() {
        return  new StudentIterator(students);
    }
}
