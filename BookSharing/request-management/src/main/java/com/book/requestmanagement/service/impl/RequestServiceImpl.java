package com.book.requestmanagement.service.impl;

import com.book.requestmanagement.domain.exceptions.RequestNotFound;
import com.book.requestmanagement.domain.exceptions.SampleNotFound;
import com.book.requestmanagement.domain.model.Request;
import com.book.requestmanagement.domain.model.RequestId;
import com.book.requestmanagement.domain.model.SampleId;
import com.book.requestmanagement.domain.repository.RequestRepository;
import com.book.requestmanagement.service.RequestService;
import com.book.requestmanagement.service.form.RequestForm;
import com.book.requestmanagement.service.form.SampleForm;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor

public class RequestServiceImpl implements RequestService {

    private final RequestRepository requestRepository;
    private final Validator validator;


    @Override
    public RequestId request(RequestForm requestForm) {
        Objects.requireNonNull(requestForm,"request must not be null.");
        var constraintViolations = validator.validate(requestForm);
        if (constraintViolations.size()>0) {
            throw new ConstraintViolationException("The request form is not valid", constraintViolations);
        }
        var newOrder = requestRepository.saveAndFlush(toDomainObject(requestForm));
        return newOrder.getId();

    }

    @Override
    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    @Override
    public Optional<Request> findById(RequestId id) {
        return requestRepository.findById(id);
    }

    @Override
    public void addSample(RequestId orderId, SampleForm orderItemForm) throws RequestNotFound {
        Request order = requestRepository.findById(orderId).orElseThrow(RequestNotFound::new);
        order.addItem(orderItemForm.getBook(),orderItemForm.getQuantity());
        requestRepository.saveAndFlush(order);

    }

    @Override
    public void deleteSample(RequestId orderId, SampleId orderItemId) throws RequestNotFound, SampleNotFound {
        Request order = requestRepository.findById(orderId).orElseThrow(RequestNotFound::new);
        order.removeItem(orderItemId);
        requestRepository.saveAndFlush(order);

    }

    private Request toDomainObject(RequestForm requestForm) {
        var order = new Request(Instant.now());
        requestForm.getItems().forEach(item->order.addItem(item.getBook(),item.getQuantity()));
        return order;
    }

}
