package com.journal;

public class Parent extends Person {

    int child_id;

    public Parent(String name, String surname, String id, String login, String pass, String position, int child_id) {
        super(name, surname, id, login, pass, position);
    }
}
