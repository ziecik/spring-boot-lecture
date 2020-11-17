package com.springbootlecturewebapp.springbootlecturewebapp.model.dao;

import com.springbootlecturewebapp.springbootlecturewebapp.model.audit.UserDateAudit;
import com.springbootlecturewebapp.springbootlecturewebapp.model.type.LectureStatusType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

@Entity
public class Lecture extends UserDateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User speaker;

    private String title;

    private String date;

    private LectureStatusType lectureStatusType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
    private Set<User> attendees;

    private String address;

    private Integer quantityOfAttendees;

    private String tags;

    private String description;

    @OneToMany(mappedBy = "lecture", fetch = FetchType.EAGER)
    private List<Comment> comments;

    public Lecture() {
    }

    public LectureStatusType getLectureStatusType() {
        return lectureStatusType;
    }

    public void setLectureStatusType(LectureStatusType lectureStatusType) {
        this.lectureStatusType = lectureStatusType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSpeaker() {
        return speaker;
    }

    public void setSpeaker(User speaker) {
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LectureStatusType getLectureStatus() {
        return lectureStatusType;
    }

    public void setLectureStatus(LectureStatusType lectureStatusType) {
        this.lectureStatusType = lectureStatusType;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(Set<User> attendees) {
        this.attendees = attendees;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getQuantityOfAttendees() {
        return quantityOfAttendees;
    }


    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantityOfAttendees(Integer quantityOfAttendees) {
        this.quantityOfAttendees = quantityOfAttendees;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
