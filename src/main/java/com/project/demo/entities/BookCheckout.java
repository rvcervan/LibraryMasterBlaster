package com.project.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "book_checkout")
@Entity
public class BookCheckout {

    String username;

    @Column(name="bookName")
    String bookName;

    @Column(name="ISBN")
    @Id
    String ISBN;

    @Column(name="checkoutTime")
    String checkoutTime;

    String checkoutDue;

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

    public String getCheckoutDue() {
        return checkoutDue;
    }

    public void setCheckoutDue(String checkoutDue) {
        this.checkoutDue = checkoutDue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "BookCheckout{" +
                "username='" + username + '\'' +
                ", bookName='" + bookName + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", checkoutTime='" + checkoutTime + '\'' +
                ", checkoutDue='" + checkoutDue + '\'' +
                '}';
    }
}
