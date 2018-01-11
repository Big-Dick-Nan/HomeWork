package com.lixiaonan.cart.daomain;

import com.lixiaonan.book.domain.Book;

public class Cartltem {
    private Book book;
    private String amount;

    @Override
    public String toString() {
        return "CartItem{" +
                "book=" + book +
                ", amount=" + amount +
                '}';
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Cartltem() {

    }

    public Cartltem(Book book, String amount) {

        this.book = book;
        this.amount = amount;
    }
}
