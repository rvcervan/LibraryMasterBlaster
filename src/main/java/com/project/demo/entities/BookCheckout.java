package com.project.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookCheckout {

    String bookName;

    @Id
    String ISBN;

    String date;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookCheckout{" +
                "bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
