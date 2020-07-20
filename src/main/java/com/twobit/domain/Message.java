package com.twobit.domain;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    public Message(String message, User user) {
        this.message = message;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String text) {
        this.message = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserInfo() {
        if (user != null && user.getUserName() != null && user.getSureName() != null) {
            return user.getUserName() + " " + user.getSureName();
        }
        return "";
    }
}
