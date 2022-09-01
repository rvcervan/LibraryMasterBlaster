package com.project.demo.controllers;


import com.project.demo.entities.BookCatalog;
import com.project.demo.services.BookCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/deleteAll")
    @ResponseBody
    public void deleteAll(){
        service.deleteAll();
    }
    
}
