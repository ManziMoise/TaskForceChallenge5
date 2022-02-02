package com.example.taskforcechallenge50.Domain;

import java.util.Date;

public class Task {

    private int id;
    private String title;
    private String description;
    private byte[] image;
//    private int status;
//
    private String priority;
//    private String created;
//    private String modified;

//    public Task(String title, String description, byte[] image, int id) {
//    }


    public Task() {
    }

    public Task(int id, String title, String description, byte[] image, String priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
