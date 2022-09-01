package com.project.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book_checkout")
@Entity
public class BookCheckout {

    @Column(name="bookName")
    String bookName;

    @Column(name="ISBN")
    @Id
    String ISBN;

    @Column(name="checkoutTime")
    String checkoutTime;

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
        return checkoutTime;
    }

    public void setDate(String date) {
        this.checkoutTime = date;
    }

    @Override
    public String toString() {
        return "BookCheckout{" +
                "bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", date='" + checkoutTime + '\'' +
                '}';
    }
}
