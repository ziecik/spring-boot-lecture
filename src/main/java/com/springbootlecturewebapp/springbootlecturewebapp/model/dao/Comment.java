package com.springbootlecturewebapp.springbootlecturewebapp.model.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springbootlecturewebapp.springbootlecturewebapp.model.audit.UserDateAudit;

import javax.persistence.*;

@Entity
public class Comment extends UserDateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture;

    @ManyToOne
    private User author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
