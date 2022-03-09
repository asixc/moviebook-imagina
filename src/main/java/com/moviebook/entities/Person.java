package com.moviebook.entities;


import javax.persistence.Column;
import java.time.LocalDateTime;


public abstract class Person {

    @Column(name= "user_pass", length = 250)
    private String userPass;

    @Column(name= "img_profile", length = 250)
    private String profileImg;

    @Column(name = "birth_date")
    private LocalDateTime birthDate;

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
