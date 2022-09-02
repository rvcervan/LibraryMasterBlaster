package com.project.demo.controllers;

import com.project.demo.entities.BookCatalog;
import com.project.demo.entities.BookCheckout;
import com.project.demo.entities.User;
import com.project.demo.services.BookCatalogService;
import com.project.demo.services.BookCheckoutService;
import com.project.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    BookCatalogService bookCatalogService;

    @Autowired
    BookCheckoutService bookCheckoutService;

    @RequestMapping("/showUsers")
    @ResponseBody
    public List<User> getUsers(){
        List<User> uList = userService.getAll();
        return uList;
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }

    @DeleteMapping("/deleteAllUsers")
    @ResponseBody
    public void deleteAllUsers(){
        userService.deleteAll();
    }

    @PostMapping(value = "/createBookCatalog")
    @ResponseBody
    public BookCatalog createBookCatalog(@RequestBody BookCatalog b){
        BookCatalog BookCatalogResponse = bookCatalogService.createBookCatalog(b);
        return BookCatalogResponse;
    }

    @PutMapping(value = "/updateBookCatalog/{id}")
    @ResponseBody
    public BookCatalog updateBookCatalog(@RequestBody BookCatalog b, @PathVariable String id){
        BookCatalog BookCatalogResponse = bookCatalogService.updateBookCatalog(b, id);
        return BookCatalogResponse;
    }

    @DeleteMapping("/deleteBookCatalog/{id}")
    @ResponseBody
    public void deleteBookCatalog(@PathVariable String id){
        bookCatalogService.deleteBookCatalog(id);
    }

    @DeleteMapping("/deleteAllBookCatalogs")
    @ResponseBody
    public void deleteAllBookCatalogs(){
        bookCatalogService.deleteAll();
    }

    @RequestMapping("/showBookCheckouts")
    @ResponseBody
    public List<BookCheckout> getBookCheckouts(){
        List<BookCheckout> bList = bookCheckoutService.getAll();
        return bList;
    }

    @PostMapping(value = "/createBookCheckout")
    @ResponseBody
    public BookCheckout createBookCheckout(@RequestBody BookCheckout b){
        BookCheckout BookCheckoutResponse = bookCheckoutService.createBookCheckout(b);
        return BookCheckoutResponse;
    }

    @DeleteMapping("/deleteBookCheckout/{id}")
    @ResponseBody
    public void deleteBookCheckout(@PathVariable String id){
        bookCheckoutService.deleteBookCheckout(id);
    }

    @DeleteMapping("/deleteAllBookCheckout")
    @ResponseBody
    public void deleteAll(){
        bookCheckoutService.deleteAll();
    }
}

