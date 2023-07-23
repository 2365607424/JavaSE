package com.weiqiang01.collection;

import java.util.Objects;

public class Person {
    String name;
    int gae;

    public Person() {
    }

    public Person(String name, int gae) {
        this.name = name;
        this.gae = gae;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gae=" + gae +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gae == person.gae && Objects.equals(name, person.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, gae);
//    }
}
