package com.book.requestmanagement.domain.model;

import com.book.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class RequestId extends DomainObjectId {
    private RequestId() {
        super(RequestId.randomId(RequestId.class).getId());
    }

    public RequestId(@NonNull String uuid) {
        super(uuid);
    }

}
