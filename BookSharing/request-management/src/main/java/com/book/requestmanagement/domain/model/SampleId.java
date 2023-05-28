package com.book.requestmanagement.domain.model;

import com.book.sharedkernel.domain.base.DomainObjectId;

public class SampleId extends DomainObjectId {

    private SampleId() {
        super(SampleId.randomId(SampleId.class).getId());
    }

    public SampleId(String uuid) {
        super(uuid);
    }

}
