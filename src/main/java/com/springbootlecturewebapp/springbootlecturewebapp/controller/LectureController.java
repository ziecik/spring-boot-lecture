package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/lectures")
    public ModelAndView createLecture(ModelAndView modelAndView, Lecture lecture) {

        modelAndView.addObject("lecture", lecture);
        modelAndView.setViewName("create-lecture");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/lectures")
    public RedirectView addLecture(@Valid Lecture lecture, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);

        lectureRepository.save(lecture);
        return new RedirectView("/");
    }

//    @GetMapping("/lectures")
//    public List<Lecture> getAllLectures() {
//        return lectureRepository.findAll();
//    }

    @GetMapping("/")
    public ModelAndView getLectureLists(ModelAndView modelAndView, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {

        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<Lecture> lecturesPage = lectureService.findPage(PageRequest.of(currentPage - 1, pageSize));

        modelAndView.addObject("lecturesPage", lecturesPage);

        int totalPages = lecturesPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            modelAndView.addObject("pageNumbers", pageNumbers);
        }

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/lectures/{id}")
    public ModelAndView getLecture(ModelAndView modelAndView, @PathVariable("id") Long id) {
        Lecture lecture = lectureRepository.findOneById(id);
        modelAndView.addObject("lecture", lecture);
        modelAndView.setViewName("lecture-details");
        return modelAndView;
    }
}
