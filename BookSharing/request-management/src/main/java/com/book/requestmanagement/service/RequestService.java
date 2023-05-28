package com.book.requestmanagement.service;

import com.book.requestmanagement.domain.exceptions.RequestNotFound;
import com.book.requestmanagement.domain.exceptions.SampleNotFound;
import com.book.requestmanagement.domain.model.Request;
import com.book.requestmanagement.domain.model.RequestId;
import com.book.requestmanagement.domain.model.SampleId;
import com.book.requestmanagement.service.form.RequestForm;
import com.book.requestmanagement.service.form.SampleForm;

import java.util.List;
import java.util.Optional;

public interface RequestService {

    RequestId request(RequestForm orderForm);

    List<Request> findAll();

    Optional<Request> findById(RequestId id);

    void addSample(RequestId orderId, SampleForm orderItemForm) throws RequestNotFound;

    void deleteSample(RequestId orderId, SampleId orderItemId) throws RequestNotFound, SampleNotFound;


}
