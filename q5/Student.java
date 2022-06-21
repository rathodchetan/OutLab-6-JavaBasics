package q5;

import java.util.List;
import java.util.ArrayList;

class Student extends Person {
    private int RollNo;
    private List<Teacher> teachers = new ArrayList<>();

    public Student(String str, int a, int rn) {
        super(str, a);
        RollNo = rn;
    }

    public Student(Person p, int rn) {
        super(p.getName(), p.getAge());
        RollNo = rn;
    }

    public int getRollNo() {
        return RollNo;
    }

    public void addTeacher(Teacher teachr) {
        teachers.add(teachr);
    }

    public List<Teacher> getTeachers() {
        return teachers;

    }

    public void intro() {
        System.out.println("I am Student, " + getName() + ", " + getAge() + ", " + RollNo);
    }
}