package com.book.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.example.demo.model.BookStore;
import com.book.example.demo.service.BookStoreService;

@RestController
@RequestMapping("/books")
public class BookStoreController 
{
	@Autowired
	private BookStoreService bookStoreService;
	
	@PostMapping("/save")
	public ResponseEntity addBooks(@RequestBody BookStore bookStore)
	{
		 bookStoreService.addBooks(bookStore);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/getbooks")
	public ResponseEntity getBooks()
	{
		List<BookStore> books= bookStoreService.getBooks();
		return new ResponseEntity<>(books,HttpStatus.OK);
	}
	@GetMapping("/getbooks/{id}")
	public ResponseEntity getBookById(@PathVariable int id)
	{
		
		return new ResponseEntity<>(bookStoreService.getBookByid(id), HttpStatus.OK);
	}
	@PutMapping("/updatebook/{id}")
	public ResponseEntity updateBooks(@RequestBody BookStore bookStore,@PathVariable int id)
	{
		
		return new ResponseEntity<>(bookStoreService.updateBook(bookStore),HttpStatus.OK);
	}
	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity deleteBook(@PathVariable int id)
	{
		bookStoreService.deleteBookById(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
}
