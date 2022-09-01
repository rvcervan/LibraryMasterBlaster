package com.project.demo.services;

import com.project.demo.entities.BookCheckout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookCheckoutService {
    List<BookCheckout> getAll();

    BookCheckout getBookCheckout(String id);

    BookCheckout createBookCheckout(BookCheckout b);

    BookCheckout updateBookCheckout(BookCheckout b, String id);

    void deleteBookCheckout(String id);

    void deleteAll();
}
