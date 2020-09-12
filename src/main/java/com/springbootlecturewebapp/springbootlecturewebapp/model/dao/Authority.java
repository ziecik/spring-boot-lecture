package com.springbootlecturewebapp.springbootlecturewebapp.model.dao;

import com.springbootlecturewebapp.springbootlecturewebapp.model.type.AuthorityType;

import javax.persistence.*;

@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private AuthorityType name;

    public Authority() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthorityType getName() {
        return name;
    }

    public void setName(AuthorityType name) {
        this.name = name;
    }

}
