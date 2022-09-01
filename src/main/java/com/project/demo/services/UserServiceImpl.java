package com.project.demo.services;

import com.project.demo.entities.User;
import com.project.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Override
    public List<User> getAll(){
        List<User> uList = repo.findAll();
        return uList;
    }

    @Override
    public User getUser(int id){
        User u = repo.findById(id).get();
        return u;
    }

    @Override
    public User createUser(User u){
        User user = repo.save(u);
        return user;
    }

    @Override
    public User updateUser(User u, int id){
        User user = repo.findById(id).get();
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
//        user.setType(u.getType());
        repo.save(user);
        return user;
    }

    @Override
    public void deleteUser(int id){
        repo.deleteById(id);
    }

    @Override
    public void deleteAll(){
        repo.deleteAll();
    }

}
