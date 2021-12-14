package com.book.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.book.example.demo.model.BookStore;

@Repository
public interface BookStoreRepository extends MongoRepository<BookStore, Integer>
{
BookStore findById(int id);
}
