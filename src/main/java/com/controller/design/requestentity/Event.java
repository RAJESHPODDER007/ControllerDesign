package com.controller.design.requestentity;


import java.io.Serializable;

public class Event implements Serializable {

    private String person_id;
    private String person_fname;
    private String person_lname;
    private String person_email;
    private String person_mobile_number;
    private String person_mobile_model;

    public Event() {
    }

    public Event(String person_id, String person_fname, String person_lname, String person_email, String person_mobile_number, String person_mobile_model) {
        this.person_id = person_id;
        this.person_fname = person_fname;
        this.person_lname = person_lname;
        this.person_email = person_email;
        this.person_mobile_number = person_mobile_number;
        this.person_mobile_model = person_mobile_model;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_fname() {
        return person_fname;
    }

    public void setPerson_fname(String person_fname) {
        this.person_fname = person_fname;
    }

    public String getPerson_lname() {
        return person_lname;
    }

    public void setPerson_lname(String person_lname) {
        this.person_lname = person_lname;
    }

    public String getPerson_email() {
        return person_email;
    }

    public void setPerson_email(String person_email) {
        this.person_email = person_email;
    }

    public String getPerson_mobile_number() {
        return person_mobile_number;
    }

    public void setPerson_mobile_number(String person_mobile_number) {
        this.person_mobile_number = person_mobile_number;
    }

    public String getPerson_mobile_model() {
        return person_mobile_model;
    }

    public void setPerson_mobile_model(String person_mobile_model) {
        this.person_mobile_model = person_mobile_model;
    }
}
