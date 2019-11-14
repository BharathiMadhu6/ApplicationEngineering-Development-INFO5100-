package A8Question2;

import java.util.ArrayList;
import java.util.List;

public class StudentController {

    ArrayList<StudentModel> studentList = new ArrayList<StudentModel>();

    public void addStudent(int ID,String name,int age, String gender,String course) {
        studentList.add(new StudentModel(ID, name, age, gender, course));
    }

    public List<StudentModel> getDisplayStudents() {
        return studentList;
    }
}
