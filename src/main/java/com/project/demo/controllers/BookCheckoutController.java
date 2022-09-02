package com.project.demo.controllers;


import com.project.demo.entities.BookCheckout;
import com.project.demo.services.BookCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/checkout")
public class BookCheckoutController {

    //Figure out permissions on who has access to what url call

    @Autowired
    BookCheckoutService service;

    @RequestMapping("/showBookCheckouts") // admin
    @ResponseBody
    public List<BookCheckout> getBookCheckouts(){ //Who calls this, admins?
        List<BookCheckout> bList = service.getAll();
        return bList;
    }

    @RequestMapping("/getBookCheckout/{id}") // user
    @ResponseBody
    public BookCheckout getBookCheckout(@PathVariable String id){
        BookCheckout b = service.getBookCheckout(id);
        return b;
    }

    @PostMapping(value = "/createBookCheckout")  // admin user
    @ResponseBody
    public BookCheckout createBookCheckout(@RequestBody BookCheckout b){
        BookCheckout BookCheckoutResponse = service.createBookCheckout(b);
        return BookCheckoutResponse;
    }

    @PutMapping(value = "/updateBookCheckout/{id}") // user: extend time
    @ResponseBody
    public BookCheckout updateBookCheckout(@RequestBody BookCheckout b, @PathVariable String id){
        BookCheckout BookCheckoutResponse = service.updateBookCheckout(b, id);
        return BookCheckoutResponse;
    }

    @DeleteMapping("/deleteBookCheckout/{id}") // admin
    @ResponseBody
    public void deleteBookCheckout(@PathVariable String id){
        service.deleteBookCheckout(id);
    }

    @DeleteMapping("/deleteAll") // admin
    @ResponseBody
    public void deleteAll(){
        service.deleteAll();
    }
}
