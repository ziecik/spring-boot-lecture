package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LectureController {

    @Autowired
    LectureRepository lectureRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin/create-lecture")
    public ModelAndView createLecture(ModelAndView modelAndView, Lecture lecture) {
        modelAndView.addObject("lecture", lecture);
        modelAndView.setViewName("create-lecture");
        return modelAndView;
    }

    @PostMapping("/admin/create-lecture")
    public ModelAndView addLecture(ModelAndView modelAndView, @Valid Lecture lecture){
        lectureRepository.save(lecture);
        return modelAndView;
    }

    @GetMapping("/admin/lectures")
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }
}
