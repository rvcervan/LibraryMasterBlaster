package com.project.demo.services;


import com.project.demo.entities.BookCheckout;
import com.project.demo.repositories.BookCheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class BookCheckoutServiceImpl implements BookCheckoutService {

    @Autowired
    BookCheckoutRepository repo;

    @Override
    public List<BookCheckout> getAll(){
        List<BookCheckout> uList = repo.findAll();
        return uList;
    }

    @Override
    public BookCheckout getBookCheckout(String id){
        BookCheckout u = repo.findById(id).get();
        return u;
    }

    @Override
    public BookCheckout createBookCheckout(BookCheckout b){

        System.out.println("hello");

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        b.setUsername(auth.getName());

        LocalDate dateObj = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        b.setDate(date);

        dateObj = dateObj.plusDays(14);
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        date = dateObj.format(formatter);

        b.setCheckoutDue(date);

        BookCheckout book = repo.save(b);
        return book;
    }

    @Override
    public BookCheckout updateBookCheckout(String id){
        BookCheckout book = repo.findById(id).get();

        LocalDate dateObj = LocalDate.now();
        dateObj = dateObj.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dateObj.format(formatter);
        book.setCheckoutDue(date);

        repo.save(book);
        return book;
    }

    @Override
    public void deleteBookCheckout(String id){
        repo.deleteById(id);
    }

    @Override
    public void deleteAll(){
        repo.deleteAll();
    }

}
