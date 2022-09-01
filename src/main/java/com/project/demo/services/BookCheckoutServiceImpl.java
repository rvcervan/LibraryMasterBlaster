package com.project.demo.services;


import com.project.demo.entities.BookCheckout;
import com.project.demo.repositories.BookCheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        BookCheckout book = repo.save(b);
        return book;
    }

    @Override
    public BookCheckout updateBookCheckout(BookCheckout b, String id){
        BookCheckout book = repo.findById(id).get();
        book.setDate(b.getDate());
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
