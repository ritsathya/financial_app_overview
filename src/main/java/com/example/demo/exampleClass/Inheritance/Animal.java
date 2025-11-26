package com.example.demo.exampleClass.Inheritance;

public abstract class Animal {
    protected int age; // state, field, variable

    //function, method, action
    public abstract void speak();

    public int getAge() {
        return this.age;
    }
}
