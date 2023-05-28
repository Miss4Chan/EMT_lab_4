package com.book.bookcatalog.domain.models;

import com.book.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name="book")
@Getter

public class Book extends AbstractEntity<BookId> {
    private String title;
    private String isbn;

    private int quantity = 0;
    public Book() {
        super(BookId.randomId(BookId.class));
    }

    public static Book build(String title, String isbn, int quantity) {
        Book p = new Book();
        p.title = title;
        p.isbn = isbn;
        p.quantity = quantity;
        return p;
    }

    public void addQuantity(int qty) {
        this.quantity = this.quantity - qty;
    }

    public void removeQuantity(int qty) {
        this.quantity -= qty;
    }

}
