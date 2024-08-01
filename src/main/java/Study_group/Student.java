package Study_group;

public class Student implements Comparable<Student> {
    int id;
    String name;
    int age;

    public Student() {

    }


    public String getName(){
        return name;
    }
    public String setName(String name){
        this.name=name;
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.name);
    }
}
