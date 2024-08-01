package Study_group;

public class StudentBuilder {
    private int genId;
    private Student student;
    private String studentName;
    private int studentAge;


    public StudentBuilder setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public StudentBuilder setStudentAge(int studentAge) {
        this.studentAge = studentAge;
        return this;
    }

    private void creatStudent() {
        student = new Student();
    }
    private void nextId(){
        student.setId(++genId);
    }

    private void creatName(){
        student.setName(studentName);

    }

    private void creatAge(){
        student.setAge(studentAge);
    }

    public Student build() {
        creatStudent();
        creatName();
        creatAge();
        nextId();
        return student;
    }
}
