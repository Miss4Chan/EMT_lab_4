package com.book.requestmanagement.domain.valueobjects;

import com.book.sharedkernel.domain.base.DomainObjectId;
import com.book.sharedkernel.domain.base.ValueObject;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public class BookId extends DomainObjectId {
    public BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(String uuid) {
        super(uuid);
    }
}
