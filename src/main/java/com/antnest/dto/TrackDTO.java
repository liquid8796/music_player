package com.antnest.dto;

import javax.persistence.Column;

public class TrackDTO {

    private long id;

    private String name;

    private int lastName;

    public TrackDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastName() {
        return lastName;
    }

    public void setLastName(int lastName) {
        this.lastName = lastName;
    }
}
