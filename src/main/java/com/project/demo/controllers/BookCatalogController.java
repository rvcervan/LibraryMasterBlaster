package com.project.demo.controllers;


import com.project.demo.entities.BookCatalog;
import com.project.demo.services.BookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class BookCatalogController {

    //Figure out permissions on who has access to what url call

    @Autowired
    BookCatalogService service;

    @RequestMapping("/showBookCatalogs")
    @ResponseBody
    public List<BookCatalog> getBookCatalogs(){ //Who calls this, admins?
        List<BookCatalog> bList = service.getAll();
        return bList;
    }

    //search books by title
    @RequestMapping("/title/{key}")
    @ResponseBody
    public List<BookCatalog> getBooksByTitle(@PathVariable String key){
        List<BookCatalog> bList = service.getAll();
        List<BookCatalog> filtered = bList.stream()
                .filter(t -> t.getBookName().contains(key))
                .collect(Collectors.toList());
        return filtered;

    }

    @RequestMapping("/author/{key}")
    @ResponseBody
    public List<BookCatalog> getBooksByAuthor(@PathVariable String key){
        List<BookCatalog> bList = service.getAll();
        List<BookCatalog> filtered = bList.stream()
                .filter(t -> t.getAuthor().contains(key))
                .collect(Collectors.toList());
        return filtered;
    }

    @RequestMapping("/ISBN/{key}")
    @ResponseBody
    public List<BookCatalog> getBooksByISBN(@PathVariable String key){
        List<BookCatalog> bList = service.getAll();
        List<BookCatalog> filtered = bList.stream()
                .filter(t -> t.getISBN().contains(key))
                .collect(Collectors.toList());
        return filtered;

    }

    @RequestMapping("/getBookCatalog/{id}")
    @ResponseBody
    public BookCatalog getBookCatalog(@PathVariable String id){
        BookCatalog b = service.getBookCatalog(id);
        return b;
    }

    @PostMapping(value = "/createBookCatalog")
    @ResponseBody
    public BookCatalog createBookCatalog(@RequestBody BookCatalog b){
        BookCatalog BookCatalogResponse = service.createBookCatalog(b);
        return BookCatalogResponse;
    }

    @PutMapping(value = "/updateBookCatalog/{id}")
    @ResponseBody
    public BookCatalog updateBookCatalog(@RequestBody BookCatalog b, @PathVariable String id){
        BookCatalog BookCatalogResponse = service.updateBookCatalog(b, id);
        return BookCatalogResponse;
    }

    @DeleteMapping("/deleteBookCatalog/{id}")
    @ResponseBody
    public void deleteBookCatalog(@PathVariable String id){
        service.deleteBookCatalog(id);
    }

    @DeleteMapping(path = "/deleteAll")
    @ResponseBody
    public void deleteAll(){
        service.deleteAll();
    }
    
}
