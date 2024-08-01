package Study_group;

/**Класс верхнеуровневого программирования использует в своей работе другие классы *
 */
public class StudentService {
    private StudyGroup studyGroup;
    private StudentBuilder builder;

    public StudentService() {
        studyGroup = new StudyGroup();
        builder = new StudentBuilder();
    }

    public void addStudent(String studentName, int studentAge) {
        Student student = builder.setStudentName(studentName).setStudentAge(studentAge).build();
        studyGroup.addStudent(student);
    }
    public String getInfoByStudent() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");
        for (Object student:studyGroup){
            stringBuilder.append(student);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
    public void sortByName(){
        studyGroup.sortByName();
    }
    public void sortByAge(){
        studyGroup.sortByAge();
    }
}
