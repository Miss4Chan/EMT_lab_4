package com.book.requestmanagement.domain.valueobjects;

import com.book.sharedkernel.domain.base.ValueObject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Book implements ValueObject {
    private final BookId id;
    private final String title;
    private final int quantity;

    public Book() {
        this.id=BookId.randomId(BookId.class);
        this.title= "";
        this.quantity = 0;
    }

    @JsonCreator
    public Book(@JsonProperty("id") BookId id,
                   @JsonProperty("title") String title,
                   @JsonProperty("quantity") int quantity) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
    }
}
