package org.hexagonal.controller;

import org.hexagonal.data.BookDto;
import org.hexagonal.ports.api.BookServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServicePort bookServicePort;

    @PostMapping("")
    public Long addBook(@RequestBody BookDto bookDto) {
        return bookServicePort.addBook(bookDto);
    }

    @PutMapping("")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookServicePort.updateBook(bookDto);
    }

    @GetMapping("/{id}")
    public BookDto getBookByID(@PathVariable long id) {
        return bookServicePort.getBookById(id);
    }

    @GetMapping()
    public List<BookDto> getAllBooks() {
        return bookServicePort.getBooks();
    }

    @DeleteMapping("/{id}")
    public void deleteBookByID(@PathVariable long id) {
        bookServicePort.deleteBookById(id);
    }
}
