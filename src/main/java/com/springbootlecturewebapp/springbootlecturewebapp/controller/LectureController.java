package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class LectureController {

    @Autowired
    LectureService lectureService;
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
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/admin/lectures")
    public List<Lecture> getAllLectures() {
        return lectureRepository.findAll();
    }

    @GetMapping("/admin/lectureList")
    public ModelAndView getLectureLists(ModelAndView modelAndView, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Lecture> lectures = lectureService.findPage(PageRequest.of(currentPage - 1, pageSize));

        modelAndView.addObject("lectures", lectures);

        int totalPages = lectures.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }

        modelAndView.setViewName("lectureList");
        return modelAndView;
    }
}
