package com.book.bookcatalog.services.impl;

import com.book.bookcatalog.domain.exceptions.BookNotFoundException;
import com.book.bookcatalog.domain.models.Book;
import com.book.bookcatalog.domain.models.BookId;
import com.book.bookcatalog.domain.repository.BookRepository;
import com.book.bookcatalog.services.BookService;
import com.book.bookcatalog.services.form.BookForm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public Book findById(BookId id) {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public Book createBook(BookForm form) {
        Book p = Book.build(form.getTitle(),form.getIsbn(),form.getQuantity());
        bookRepository.save(p);
        return p;

    }

    @Override
    public Book bookSampleCreated(BookId productId, int quantity) {
        Book p = bookRepository.findById(productId).orElseThrow(BookNotFoundException::new);
        p.addQuantity(quantity);
        bookRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public Book bookSampleRemoved(BookId productId, int quantity) {
        Book p = bookRepository.findById(productId).orElseThrow(BookNotFoundException::new);
        p.removeQuantity(quantity);
        bookRepository.saveAndFlush(p);
        return p;

    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}
