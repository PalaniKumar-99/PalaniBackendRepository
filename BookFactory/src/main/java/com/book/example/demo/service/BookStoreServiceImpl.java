package com.book.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.book.example.demo.model.BookStore;
import com.book.example.demo.repository.BookStoreRepository;

@Service
public class BookStoreServiceImpl implements BookStoreService
{
	@Autowired
	private BookStoreRepository bookstorerepository;
	
	@Override
	public void addBooks(BookStore bookstore) {
		bookstorerepository.save(bookstore);
		
	}

	@Override
	public List<BookStore> getBooks() {
		
		List<BookStore> books= bookstorerepository.findAll();
		System.out.println("Getting Books "+books);
		return books;
	}

	@Override
	public ResponseEntity getBookByid(int id) {
		
		return new ResponseEntity<>(bookstorerepository.findById(id), HttpStatus.OK); 
	} 

	@Override
	public BookStore updateBook(BookStore bookstore) {
		return bookstorerepository.save(bookstore);
		
	}

	@Override
	public void deleteBookById(int id) {
		bookstorerepository.deleteById(id);
		
	}

}
