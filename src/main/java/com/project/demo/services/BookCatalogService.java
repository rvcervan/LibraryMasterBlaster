package com.project.demo.services;

import com.project.demo.entities.BookCatalog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookCatalogService {
    List<BookCatalog> getAll();

    BookCatalog getBookCatalog(String id);

    BookCatalog createBookCatalog(BookCatalog b);

    BookCatalog updateBookCatalog(BookCatalog b, String id);

    void deleteBookCatalog(String id);

    void deleteAll();
}
