package com.book.requestmanagement.service.form;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestForm {
    @Valid
    @NotEmpty
    private List<SampleForm> items = new ArrayList<>();

}
