package q5;

import java.util.ArrayList;
import java.util.List;

class Teacher extends Person {
    private int salary;

    private List<Student> students = new ArrayList<>();

    public Teacher(String str, int a, int sal) {
        super(str, a);
        salary = sal;
    }

    public Teacher(String str, int a) {
        super(str, a);
        salary = 10000;
    }

    public Teacher(Person p, int sal) {
        super(p.getName(), p.getAge());
        salary = sal;
    }

    public int getSalary() {
        return salary;
    }

    public void addStudent(Student stud) {
        students.add(stud);
        return;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void intro() {
        System.out.println("I am a Teacher, " + getName() + ", " + getAge() + ", " + salary);
    }
}
