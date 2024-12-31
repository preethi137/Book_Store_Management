package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;

@Service
public class BookService {
	@Autowired
private BookRepository bookRepository;
	
	public void save(Book book) {
		bookRepository.save(book);
	}
	public List<Book>getAllBooks(){
		return bookRepository.findAll();
	}
	public Book getBooksById(int id) {
		return bookRepository.findById(id).get();
	}
	public void deleteBookById(int id) {
		bookRepository.deleteById(id);
	}
}
