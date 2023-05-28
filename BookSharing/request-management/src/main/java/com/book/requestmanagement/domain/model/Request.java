package com.book.requestmanagement.domain.model;

import com.book.requestmanagement.domain.valueobjects.Book;
import com.book.sharedkernel.domain.base.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name="request")
@Getter

public class Request extends AbstractEntity<RequestId> {
    private Instant orderedOn;

    @Enumerated(EnumType.STRING)
    private RequestState requestState;


    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Sample> samples = new ArrayList<>();

    public Request() {
        super(RequestId.randomId(RequestId.class));
    }
    public Request(Instant now) {
        super(RequestId.randomId(RequestId.class));
        this.orderedOn = now;
    }


    public Sample addItem(@NonNull Book book, int qty) {
        Objects.requireNonNull(book,"book must not be null");
        var item  = new Sample(book.getId(), book.getTitle(),qty);
        samples.add(item);
        return item;
    }

    public void removeItem(@NonNull SampleId orderItemId) {
        Objects.requireNonNull(orderItemId,"sample must not be null");
        samples.removeIf(v->v.getId().equals(orderItemId));
    }

}
