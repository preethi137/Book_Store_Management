package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.MyBookList;
import com.example.demo.repository.MyBookRepository;

@Service
public class MyBookService {
	@Autowired
	private MyBookRepository myBookRepository;
	public void saveMyBooks(MyBookList myBook) {
		myBookRepository.save(myBook);
	}
	public List<MyBookList> getAllBookList(){
		return myBookRepository.findAll();
	}
	public void deleteBooksById(int id) {
		 myBookRepository.deleteById(id);
	}

}
