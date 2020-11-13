package com.springbootlecturewebapp.springbootlecturewebapp.service.implementations;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.CommentRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;

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

    @Override
    public Lecture signOnLecture(Long id) {
        Lecture lecture = lectureRepository.findOneById(id);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        User userByUsername = userRepository.findByUsername(username);
        lecture.getAttendees().add(userByUsername);
        lectureRepository.save(lecture);
        return lecture;
    }

    @Override
    public Lecture sortComments(Lecture lecture) {
        List<Comment> comments = new ArrayList<>(lecture.getComments());
        comments.sort((comment, t1) -> comment.getDateOfCreation().compareTo(t1.getDateOfCreation()));
        lecture.setComments(comments);
        return lecture;
    }
}
