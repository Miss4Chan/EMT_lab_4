package com.book.requestmanagement.domain.model;

import com.book.requestmanagement.domain.valueobjects.BookId;
import com.book.sharedkernel.domain.base.AbstractEntity;
import com.book.sharedkernel.domain.base.DomainObjectId;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "sample")
@Getter

public class Sample extends AbstractEntity<SampleId> {
    private String title;
    @Column(name = "qty", nullable = false)
    private int quantity;

    @AttributeOverride(name = "id", column = @Column(name = "sample_id", nullable = false))
    private BookId bookId;

    public Sample() {
        super(DomainObjectId.randomId(SampleId.class));
    }

    public Sample(@NonNull BookId bookId,String title, int qty) {
        super(DomainObjectId.randomId(SampleId.class));
        this.title=title;
        this.bookId = bookId;
        this.quantity = qty;
    }

}
