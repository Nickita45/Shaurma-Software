package com.orders.management.repository;

import com.orders.management.domain.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

        @Repository
    public interface DocumentRepository extends CrudRepository<Document, Integer>{

        }