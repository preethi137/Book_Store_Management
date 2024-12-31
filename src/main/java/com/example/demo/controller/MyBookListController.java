package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.MyBookService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookService mybook;
	
	@GetMapping("/deleteMyList/{id}")
	public String deleteBookById(@PathVariable("id")int id) {
		mybook.deleteBooksById(id);
		return "redirect:/my_books";
	}
	
}
