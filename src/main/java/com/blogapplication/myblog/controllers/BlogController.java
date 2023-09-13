package com.blogapplication.myblog.controllers;



import com.blogapplication.myblog.models.Post;
import com.blogapplication.myblog.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {


    @Autowired
    private PostRepo postRepo;


    @GetMapping("/blog")
    public String blogMain(Model model){

        Iterable<Post> posts = postRepo.findAll();
        model.addAttribute("posts" , posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model){


        return "blog-add";
    }


    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, Model model){
      Post post = new Post(title , anons , full_text);
      postRepo.save(post);
        return "";
    }


    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") Long id, Model model){
        if (!postRepo.existsById(id)){
            return "redirect:/blog";
        }
      Optional<Post> post = postRepo.findById(id);
        List<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post" , res);
        return "blog-details";
    }
}
