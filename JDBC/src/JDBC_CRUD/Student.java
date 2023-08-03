package JDBC_CRUD;

public class Student {
    String st_first_name;

    String st_last_name;

    @Override
    public String toString() {
        return "Student{" +
                "st_first_name='" + st_first_name + '\'' +
                ", st_last_name='" + st_last_name + '\'' +
                ", st_age=" + st_age +
                '}';
    }

    int st_age;

    public Student() {
    }

    public Student(String st_first_name, String st_last_name, int st_age) {
        this.st_first_name = st_first_name;
        this.st_last_name = st_last_name;
        this.st_age = st_age;
    }

    public void setSt_first_name(String st_first_name) {
        this.st_first_name = st_first_name;
    }

    public void setSt_last_name(String st_last_name) {
        this.st_last_name = st_last_name;
    }

    public void setSt_age(int st_age) {
        this.st_age = st_age;
    }

    public String getSt_first_name() {
        return st_first_name;
    }

    public String getSt_last_name() {
        return st_last_name;
    }

    public int getSt_age() {
        return st_age;
    }
}
