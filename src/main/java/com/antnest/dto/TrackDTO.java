package com.antnest.dto;

import com.antnest.entity.User;

import javax.persistence.Column;

public class TrackDTO {

    private long id;

    private String name;

    private int lengthInSec;

    private long singerId;

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

    public int getLengthInSec() {
        return lengthInSec;
    }

    public void setLengthInSec(int lengthInSec) {
        this.lengthInSec = lengthInSec;
    }

    public long getSingerId() {
        return singerId;
    }

    public void setSingerId(long singerId) {
        this.singerId = singerId;
    }
}
