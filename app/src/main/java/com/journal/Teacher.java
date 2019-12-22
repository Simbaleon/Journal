package com.journal;

public class Teacher extends Person {

    String email, phone, qualification;
    boolean is_admin;

    public Teacher (String name, String surname, String id, String login, String pass, String position,
                    String email, String phone, String qualification, boolean is_admin) {
        super(name, surname, id, login, pass, position);
    }

}
