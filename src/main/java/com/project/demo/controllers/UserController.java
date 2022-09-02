package com.project.demo.controllers;

import com.project.demo.entities.User;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public ResponseEntity getUsers(){ //Who calls this, admins?
        if(!checkAuth())
        {
            return new ResponseEntity<>( "Not Authorized", HttpStatus.UNAUTHORIZED);
        }

        try{
            List<User> userlist = service.getAll();
            return new ResponseEntity<>( userlist, HttpStatus.OK);
        }catch(Exception ex){
            String errorMessage;
            errorMessage = ex + " <== error";
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping("/getUser/{id}")
    @ResponseBody
    public ResponseEntity getUser(@PathVariable int id){
        if(!checkAuth())
        {
            return new ResponseEntity<>( "Not Authorized", HttpStatus.UNAUTHORIZED);
        }

        try{
            User u = service.getUser(id);
            if(u.getUsername().equals(returnUser()))
            {
                return new ResponseEntity<>( u, HttpStatus.OK);
            }
            else {
                throw new Exception();
            }
        }catch(Exception ex){
            return new ResponseEntity<>("Wrong ID", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/createUser")
    @ResponseBody
    public User createUser(@RequestBody User u){
        User userResponse = service.createUser(u);
        return userResponse;
    }

    @PutMapping(value = "/updateUser/{id}")
    @ResponseBody
    public ResponseEntity updateUser(@RequestBody User u, @PathVariable int id){
        try{
            if(u.getUsername().equals(returnUser()))
            {
                User userResponse = service.updateUser(u, id);
                return new ResponseEntity<>( userResponse, HttpStatus.OK);
            }
            else {
                throw new Exception();
            }
        }catch(Exception ex){
            return new ResponseEntity<>("Wrong ID", HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public ResponseEntity deleteUser(@PathVariable int id){
        try{
            User u = service.getUser(id);
            if(u.getUsername().equals(returnUser()))
            {
                service.deleteUser(id);
                return new ResponseEntity<>( "deleted", HttpStatus.OK);
            }
            else {
                throw new Exception();
            }
        }catch(Exception ex){
            return new ResponseEntity<>("Wrong ID", HttpStatus.UNAUTHORIZED);
        }

    }


    public Boolean checkAuth()
    {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString().equalsIgnoreCase("[user]");
    }

    public String returnUser()
    {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
