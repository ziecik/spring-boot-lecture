package com.springbootlecturewebapp.springbootlecturewebapp.service.implementations;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.CommentRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public Comment addComment(Comment comment, Long id) {
        Lecture lecture = lectureRepository.findOneById(id);
        comment.setLecture(lecture);
        return commentRepository.save(comment);
    }

    @Override
    public Comment findCommentByLecture(Comment comment) {
        return null;
    }
}
