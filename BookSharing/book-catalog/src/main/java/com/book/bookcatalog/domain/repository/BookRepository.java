package com.book.bookcatalog.domain.repository;

import com.book.bookcatalog.domain.models.Book;
import com.book.bookcatalog.domain.models.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
}
