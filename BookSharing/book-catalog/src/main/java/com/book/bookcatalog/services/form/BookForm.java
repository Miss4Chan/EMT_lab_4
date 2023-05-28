package com.book.bookcatalog.services.form;

import lombok.Data;

@Data
public class BookForm {

    private String title;
    private String isbn;
    private int quantity;

}
