package com.book.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.book.example.demo.controller.BookStoreController;
import com.book.example.demo.model.BookStore;
import com.book.example.demo.repository.BookStoreRepository;
import com.book.example.demo.service.BookStoreService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(BookStoreController.class)
public class BookFactoryApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookStoreService bookService;
	
	@MockBean
	private BookStoreRepository bookRepository;
	
	@Test
	public void testgetBook() throws Exception {
		List<BookStore> listBook = new ArrayList<>();
		
		listBook.add(new BookStore(23,"JavaBook",350.0));
		listBook.add(new BookStore(45,"javascript",250.0));
		
		Mockito.when(bookService.getBooks()).thenReturn(listBook);
		mockMvc.perform(get("/books/getbooks")).andExpect(status().isOk());
	}
	
	@Test
	public void testaddBook() throws Exception {
		BookStore book = new BookStore();
		book.setId(1);
		book.setName("java");
		book.setPrice(250.0);
			
			mockMvc.perform(post("/books/save").contentType(MediaType.APPLICATION_JSON_UTF8)
						.content(asJsonString(book))
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	    }
	
		
		  @Test
		  public void testupdateBook() throws Exception {
			  BookStore book = new BookStore(); 
			  book.setId(1);
			  book.setName("java"); 
			  book.setPrice(987.9);
			  bookRepository.save(book); 
//			  mockMvc.perform(put("/book/{id}")) 
//			  .andExpect(status().isOk());
		  
//		  	 testaddBook();
//			 BookStore book=bookRepository.findById(1);
//			 book.setName("java"); 
//			 book.setPrice(344.9); 
//			 assertEquals(true, bookService.updateBook(book));
		  
//		  	String bookName = "Kindle Reader";
//		  	BookStore book = new BookStore(bookName , 350.0);
//		  	book.setId(4);
//		  	bookRepository.save(book); 
//		   	BookStore updatedProduct = bookRepository.findById(4); 
//		   	assertThat(updatedProduct.getName()).isEqualTo(bookName);
		   
		   
		  	mockMvc.perform(put("/books/updatebook/{id}}").contentType(MediaType.
		  	APPLICATION_JSON_UTF8) .content(asJsonString(book))
		  	.accept(MediaType.APPLICATION_JSON)) .andExpect(status().isOk());
		  
		  }
		 
	
	


	public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}