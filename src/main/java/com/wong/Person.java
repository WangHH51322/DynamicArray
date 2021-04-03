package com.wong;

public class Person {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
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

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    //当对象被销毁的时候会调用这个方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();

        System.out.println("Person-finalize");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return (this.age == person.age && this.name.equals(person.name));
        }
        return false;
    }
}
