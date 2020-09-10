package com.springbootlecturewebapp.springbootlecturewebapp.model.dao;

import com.springbootlecturewebapp.springbootlecturewebapp.model.type.LectureStatusType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Set<User> speakers;

    private String title;

    private LocalDateTime date;

    private LectureStatusType lectureStatusType;

    @ManyToMany
    private Set<User> attendees;

    private String address;

    private Integer quantityOfAttendees;

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

    public Set<User> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Set<User> speakers) {
        this.speakers = speakers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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

    public void setQuantityOfAttendees() {
        this.quantityOfAttendees = this.attendees.size();
    }

}