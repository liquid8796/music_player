package com.antnest.dto;

import javax.persistence.Column;

public class UserDTO {

    private long id;

    private String firstName;

    private String lastName;

    private int age;

    private boolean isSinger;

    public UserDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSinger() {
        return isSinger;
    }

    public void setSinger(boolean singer) {
        isSinger = singer;
    }
}
