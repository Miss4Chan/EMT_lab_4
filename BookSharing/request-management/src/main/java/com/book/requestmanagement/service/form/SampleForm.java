package com.book.requestmanagement.service.form;

import com.book.requestmanagement.domain.valueobjects.Book;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SampleForm {

    @NotNull
    private Book book;

    @Min(1)
    private int quantity = 1;

}
