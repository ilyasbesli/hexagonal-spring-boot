package org.hexagonal.ports.api;

import org.hexagonal.data.BookDto;

import java.util.List;

public interface BookServicePort {

    Long addBook(BookDto bookDto);

    void deleteBookById(Long id);

    BookDto updateBook(BookDto bookDto);

    List<BookDto> getBooks();

    BookDto getBookById(Long bookId);
}
