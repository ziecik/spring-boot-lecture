package com.springbootlecturewebapp.springbootlecturewebapp.controller;

import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.Comment;
import com.springbootlecturewebapp.springbootlecturewebapp.model.dao.User;
import com.springbootlecturewebapp.springbootlecturewebapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("lectures/{id}/comments")
    public RedirectView addComment(@PathVariable("id") Long id, Comment comment, @AuthenticationPrincipal UserDetails userDetails) {
        commentService.addComment(comment, id, userDetails);
        String url = "/lectures/" + id;
        return new RedirectView(url);
    }

    @PostMapping("lectures/{lid}/comments/{id}")
    public RedirectView editComment(@PathVariable("lid") Long lid, @PathVariable("id") Long id, @ModelAttribute("comment") Comment comment, @AuthenticationPrincipal UserDetails userDetails) {
        commentService.editComment(id, comment, userDetails);
        String url ="/lectures/" + lid;
        return new RedirectView(url);
    }

    @GetMapping("lectures/{lid}/comments/{id}")
    public ModelAndView getComment(ModelAndView modelAndView, @PathVariable("id") Long id) {
        Comment comment = commentService.getComment(id);
        modelAndView.addObject("comment", comment);
        modelAndView.setViewName("comment-edit");
        return modelAndView;
    }
}
