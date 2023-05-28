package com.book.requestmanagement.domain.repository;

import com.book.requestmanagement.domain.model.Request;
import com.book.requestmanagement.domain.model.RequestId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, RequestId> {
}
