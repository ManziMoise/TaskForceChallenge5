package com.example.taskforcechallenge50.Domain;

public class Todo {

    private int id;
    private String title;
    private String description;
    private String mode;
    private String created;
    private String modified;
    private byte[] image;
    private String status;

    public Todo() {
    }

    public Todo(int id, String title, String description, String mode, String created, String modified, byte[] image, String status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.mode = mode;
        this.created = created;
        this.modified = modified;
        this.image = image;
        this.status = status;
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

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
