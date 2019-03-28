package com.portfolio.entity;

import javax.persistence.*;

@Entity
@Table(name = "skills")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String techName;
    @Column(name = "logo")
    private byte[] logo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user   ;

    public Skills() {
    }

    public Skills(String techName, byte[] logo, User user) {
        this.techName = techName;
        this.logo = logo;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTechName() {
        return techName;
    }

    public void setTechName(String techName) {
        this.techName = techName;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
