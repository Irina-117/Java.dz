package Study_group;

import java.util.Iterator;
import java.util.List;

public class StudentIterator implements Iterator<Student> {
    private int curInd;
    private List<Student> students;

    public StudentIterator(List<Student> students) {
        this.students = students;
    }

    @Override
    public boolean hasNext() {
        return students.size() > curInd;
    }

    @Override
    public Student next() {
        return students.get(curInd++);
    }
}
