package com.project.demo.controllers;


import com.project.demo.entities.BookCatalog;
import com.project.demo.entities.BookCheckout;
import com.project.demo.services.BookCatalogService;
import com.project.demo.services.BookCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/checkout")
public class BookCheckoutController {

    //Figure out permissions on who has access to what url call

    @Autowired
    BookCheckoutService service;

    BookCatalogService bookService;

    @RequestMapping("/showAllCheckouts") // admin
    @ResponseBody
    public List<BookCheckout> getBookCheckouts(){ //Who calls this, admins?
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getAuthorities().toString().contains("admin")){
            return service.getAll();
        }
        return null;
    }

    @RequestMapping("/getMyCheckouts") // user
    @ResponseBody
    public List<BookCheckout> getBookCheckout(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        List<BookCheckout> bList = service.getAll();
        List<BookCheckout> filtered = bList.stream()
                .filter(n -> n.getUsername().contains(name))
                .collect(Collectors.toList());
        return filtered;
    }

    @PostMapping("/bookCheckout")  // admin user
    @ResponseBody
    public BookCheckout createBookCheckout(@RequestBody BookCheckout b){ //checkout a book using isbn?

        System.out.println("hello here");

        BookCatalog book = bookService.getBookCatalog(b.getISBN());
        if(book.getInstock() > 1){
            BookCheckout BookCheckoutResponse = service.createBookCheckout(b);
            book.setInstock(book.getInstock()-1);
            return BookCheckoutResponse;
        }

        return null;
    }

    @PutMapping(value = "/extendBookTime/{id}") // user: extend time by a week
    @ResponseBody
    public BookCheckout updateBookCheckout(@PathVariable String id){

        System.out.println(id);
        List<BookCheckout> myList = getBookCheckout();
        if(myList.isEmpty()){
            return null;
        }
        BookCheckout BookCheckoutResponse = service.updateBookCheckout(id);
        return BookCheckoutResponse;
    }

    @DeleteMapping("/deleteBookCheckout/{id}") // admin
    @ResponseBody
    public void deleteBookCheckout(@PathVariable String id){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getAuthorities().toString().contains("admin")){
            service.deleteBookCheckout(id);
        }
    }

    @DeleteMapping("/deleteAll") // admin
    @ResponseBody
    public void deleteAll(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getAuthorities().toString().contains("admin")){
            service.deleteAll();
        }
    }
}
