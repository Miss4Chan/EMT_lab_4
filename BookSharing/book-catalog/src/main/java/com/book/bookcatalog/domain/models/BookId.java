package com.book.bookcatalog.domain.models;

import com.book.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class BookId extends DomainObjectId {
    public BookId() {
        super(BookId.randomId(BookId.class).getId());
    }
    public BookId(@NonNull String uuid) {
        super(uuid);
    }

    public static BookId of(String uuid) {
        BookId p = new BookId(uuid);
        return p;
    }

}
