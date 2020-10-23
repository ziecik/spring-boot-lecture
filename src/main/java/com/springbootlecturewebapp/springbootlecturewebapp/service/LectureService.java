package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LectureService {

    private LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Page<Lecture> findPage(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Lecture> lectures = lectureRepository.findAll();
        List<Lecture> list;

        if(lectures.size() < startItem)
            list = Collections.emptyList();
        else {
            int toIndex = Math.min(startItem + pageSize, lectures.size());
            list = lectures.subList(startItem, toIndex);
        }

        Page<Lecture> lecturePage = new PageImpl<Lecture>(list, PageRequest.of(currentPage, pageSize), lectures.size());

        return lecturePage;
    }
}
