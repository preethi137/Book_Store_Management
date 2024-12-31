package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Book;
import com.example.demo.entity.MyBookList;
import com.example.demo.service.BookService;
import com.example.demo.service.MyBookService;




@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	@Autowired
	private MyBookService myBookService;
	@GetMapping("/")
	public String home() {
		return "home";
		}
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
		}
	@GetMapping("/available_books")
	public ModelAndView availableBooks() {
		List<Book>list=bookService.getAllBooks();
		return new ModelAndView("bookList","book",list);
		}
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		bookService.save(book);
		return "redirect:/available_books";
		
	}
	@GetMapping("/my_books")
	public String myBooks(Model model) {
		List<MyBookList>list=myBookService.getAllBookList();
		model.addAttribute("book",list);
		return "myBooks";
	}
	@GetMapping("/myList/{id}")
	public String getBookById(@PathVariable ("id") int id) {
		Book book=bookService.getBooksById(id);
		MyBookList mb=new MyBookList(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@GetMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model) {
		Book b=bookService.getBooksById(id);
		model.addAttribute("book",b);
		
	return "editBook";
}
	@GetMapping("/deleteBook/{id}")
	public String deleteTheBookById(@PathVariable("id")int id) {
		bookService.deleteBookById(id);
		return "redirect:/available_books";
	}

}
