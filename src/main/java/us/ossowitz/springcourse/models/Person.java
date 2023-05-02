package us.ossowitz.springcourse.models;

public class Person {
    private int id;
    private String name;
    private int age;
    private int phone;

    public Person(int id, String name, int age, int phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public int calcPhone() {
        int sum = 0;
        while (phone != 0) {
            sum += (phone % 10);
            phone /= 10;
        }
        return sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

}
