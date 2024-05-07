package aston.serialization.task;

import java.io.Serializable;
import java.util.Objects;


public class Person implements Serializable {
    private static final long serialVersionUID = 1L;
    private int age;
    private String name;
    private int id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getAge() == person.getAge() && getId() == person.getId() && Objects.equals(getName(), person.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAge(), getName(), getId());
    }

    public Person(int age, String name, int id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

