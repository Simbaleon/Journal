package com.journal;

public class Student extends Person {

    String clas;

    public Student(String name, String surname, String id, String login, String pass, String position,
                   String clas) {
        super(name, surname, id, login, pass, position);
    }
}
