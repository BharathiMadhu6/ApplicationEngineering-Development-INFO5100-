package A8Question2;

public class StudentModel {

    private int ID;
    private String name;
    private int age;
    private String gender;
    private String course;

    StudentModel(int ID, String name, int age, String gender, String course) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.course = course;
    }

    StudentModel() {
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

}
