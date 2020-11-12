package com.springbootlecturewebapp.springbootlecturewebapp.service;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;

public interface CommentService {
    Comment addComment(Comment comment);
    Comment findCommentByLecture(Comment comment);
}
