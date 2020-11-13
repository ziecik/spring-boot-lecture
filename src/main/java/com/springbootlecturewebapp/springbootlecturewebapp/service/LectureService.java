package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface LectureService {

    Page<Lecture> findPage(Pageable pageable);
    Lecture signOnLecture(Long id);
    Lecture sortComments(Lecture lecture);
}
