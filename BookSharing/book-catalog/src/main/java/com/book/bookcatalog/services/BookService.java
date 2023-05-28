package com.book.bookcatalog.services;

import com.book.bookcatalog.domain.models.Book;
import com.book.bookcatalog.domain.models.BookId;
import com.book.bookcatalog.services.form.BookForm;

import java.util.List;

public interface BookService {

    Book findById(BookId id);
    Book createBook(BookForm form);
    Book bookSampleCreated(BookId productId, int quantity);
    Book bookSampleRemoved(BookId productId, int quantity);
    List<Book> getAll();

}
