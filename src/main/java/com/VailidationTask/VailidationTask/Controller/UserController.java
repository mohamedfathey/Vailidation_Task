package com.VailidationTask.VailidationTask.Controller;

import com.VailidationTask.VailidationTask.Entity.User;
import com.VailidationTask.VailidationTask.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User addNewUser (@RequestBody @Valid User user){
        return userService.insert(user);
    }

    @GetMapping
    public List<User>findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public User findById (@PathVariable long id){
        return userService.findById(id);
    }

}
