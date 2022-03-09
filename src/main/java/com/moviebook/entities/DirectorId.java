package com.moviebook.entities;

import javax.persistence.Column;
import java.io.Serializable;

public class DirectorId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name= "first_name", length = 100)
    private String firstName;

    @Column(name= "last_name", length = 100)
    private String lasName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }
}
