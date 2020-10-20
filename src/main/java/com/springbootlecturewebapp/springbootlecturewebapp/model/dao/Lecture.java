package com.springbootlecturewebapp.springbootlecturewebapp.model.dao;

import com.springbootlecturewebapp.springbootlecturewebapp.model.type.LectureStatusType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Entity
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String speakers;

    private String title;

    private String date;

    private LectureStatusType lectureStatusType;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> attendees;

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

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
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

    public List<User> getAttendees() {
        return attendees;
    }

    public void setAttendees(List<User> attendees) {
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
