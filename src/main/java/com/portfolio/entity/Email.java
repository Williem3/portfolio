package com.portfolio.entity;

// created object to pass through as a ModelAttribute in Thymeleaf and return values to be used in EmailServiceImpl
public class Email {

    // main components
    private String from;
    private String name;
    private String content;

    // constructors
    public Email() {
    }
    public Email(String from, String name, String content) {
        this.from = from;
        this.name = name;
        this.content = content;
    }

    // Getters and Setters
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
