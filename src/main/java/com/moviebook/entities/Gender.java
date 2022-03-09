package com.moviebook.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Gender {
    @Id
    private String gender;

    public Gender() {}

    public Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Gender{" +
                "gender='" + gender +
                '}';
    }
}
