package q5;

public class Person {
    private String name;
    private int age;

    public Person(String str, int a) {
        name = str;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void intro() {
        System.out.println("I am a person, " + name + ", " + age);

    }
}
