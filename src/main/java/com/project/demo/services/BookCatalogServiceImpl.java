package com.project.demo.services;


import com.project.demo.entities.BookCatalog;
import com.project.demo.repositories.BookCatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookCatalogServiceImpl implements BookCatalogService {
    
    @Autowired
    BookCatalogRepository repo;

    @Override
    public List<BookCatalog> getAll(){
        List<BookCatalog> bList = repo.findAll();
        return bList;
    }

    @Override
    public BookCatalog getBookCatalog(String id){
        System.out.println(":sd");
        BookCatalog b = repo.findById(id).get();
        return b;
    }

    @Override
    public BookCatalog createBookCatalog(BookCatalog b){
        BookCatalog book = repo.save(b);
        return book;
    }

    @Override
    public BookCatalog updateBookCatalog(BookCatalog b, String id){
        BookCatalog book = repo.findById(id).get();
        book.setInstock(b.getInstock());
        repo.save(book);
        return book;
    }

    @Override
    public void deleteBookCatalog(String id){
        repo.deleteById(id);
    }

    @Override
    public void deleteAll(){
        repo.deleteAll();
    }
    
}
