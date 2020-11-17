package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    Comment addComment(Comment comment, Long id, UserDetails userDetails);
    Comment findCommentByLecture(Comment comment);
    Comment getComment(Long id);
    Comment editComment(Long id, Comment comment, UserDetails userDetails);
}
