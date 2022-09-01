package com.project.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class BookCatalog {

    String bookName;

    @Id
    String ISBN;

    int instock;

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

    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    @Override
    public String toString() {
        return "BookCatalog{" +
                "bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", instock=" + instock +
                '}';
    }
}
