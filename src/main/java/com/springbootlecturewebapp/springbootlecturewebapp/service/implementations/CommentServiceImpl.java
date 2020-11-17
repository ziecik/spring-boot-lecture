package com.springbootlecturewebapp.springbootlecturewebapp.service.implementations;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Lecture;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.CommentRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.LectureRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.repositories.UserRepository;
import com.springbootlecturewebapp.springbootlecturewebapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment addComment(Comment comment, Long id, UserDetails userDetails) {
        Lecture lecture = lectureRepository.findOneById(id);
        comment.setLecture(lecture);
        comment.setAuthor(userRepository.findByUsername(userDetails.getUsername()));
        return commentRepository.save(comment);
    }

    @Override
    public Comment findCommentByLecture(Comment comment) {
        return null;
    }

    @Override
    public Comment editComment(Long id, Comment comment, UserDetails userDetails) {
        Comment oldComment = commentRepository.findById(id).get();
            if (userDetails.getUsername() == oldComment.getAuthor().getUsername()) {
                oldComment.setContent(comment.getContent());

                return commentRepository.save(oldComment);
            }
            else
                return null;
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id).get();
    }
}
