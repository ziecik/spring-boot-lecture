package com.springbootlecturewebapp.springbootlecturewebapp.repositories;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface LectureRepository extends JpaRepository<Lecture, Long> {

}
