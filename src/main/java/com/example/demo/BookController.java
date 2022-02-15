package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookRespository bookRespository;
	
	@GetMapping
	public List<Book> getAllBookRecords(){
		return bookRespository.findAll();
	}
	
	@GetMapping(value = "{bookId}")
	public Book getBookById(@PathVariable(value = "bookId") Long bookId) {
		return bookRespository.getById(bookId);
		//return bookRespository.findById(bookId).get();
	}
	
	@PostMapping
	public Book createBookRecord(@RequestBody Book bookRecord) {
		return bookRespository.save(bookRecord);
	}
	
	@PutMapping
	public Book updateBookRecord(@RequestBody Book bookRecord) throws NotFoundException {
		if (bookRecord == null || bookRecord.getBookId() == null) {
			throw new NotFoundException();
		}
		
		Optional<Book> optionalBook = bookRespository.findById(bookRecord.getBookId());
		if (!optionalBook.isPresent()) {
			throw new NotFoundException();
		}
		
		Book existingBookRecord = optionalBook.get();
		existingBookRecord.setName(bookRecord.getName());
		existingBookRecord.setSummary(bookRecord.getName());
		existingBookRecord.setRaiting(bookRecord.getRaiting());
		
		return bookRespository.save(existingBookRecord);
		
		
	}
	
	//deleting using tdd method
	

}
