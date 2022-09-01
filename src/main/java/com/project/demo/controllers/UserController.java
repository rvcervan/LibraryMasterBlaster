package com.project.demo.controllers;

import com.project.demo.entities.User;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    //Figure out permissions on who has access to what url call

    @Autowired
    UserService service;

    @RequestMapping("/showUsers")
    @ResponseBody
    public List<User> getUsers(){ //Who calls this, admins?
        List<User> uList = service.getAll();
        return uList;
    }

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable int id){
        User u = service.getUser(id);
        return u;
    }

    @PostMapping(value = "/createUser")
    @ResponseBody
    public User createUser(@RequestBody User u){
        User userResponse = service.createUser(u);
        return userResponse;
    }

    @PutMapping(value = "/updateUser/{id}")
    @ResponseBody
    public User updateUser(@RequestBody User u, @PathVariable int id){
        User userResponse = service.updateUser(u, id);
        return userResponse;
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable int id){
        service.deleteUser(id);
    }

    @DeleteMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(){
        service.deleteAll();
    }

}
