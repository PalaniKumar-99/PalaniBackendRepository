package com.book.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.book.example.demo.model.BookStore;

public interface BookStoreService 
{
	public void addBooks(BookStore bookstore);
	public List<BookStore> getBooks();
	public ResponseEntity getBookByid(int id);
	public BookStore updateBook(BookStore bookstore);
	public void deleteBookById(int id);
}
