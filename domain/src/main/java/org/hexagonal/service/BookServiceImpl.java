package org.hexagonal.service;

import org.hexagonal.data.BookDto;
import org.hexagonal.ports.api.BookServicePort;
import org.hexagonal.ports.spi.BookPersistencePort;

import java.util.List;

public class BookServiceImpl implements BookServicePort {

    private BookPersistencePort bookPersistencePort;

    public BookServiceImpl(BookPersistencePort bookPersistencePort) {
        this.bookPersistencePort = bookPersistencePort;
    }

    @Override
    public Long addBook(BookDto bookDto) {
        return bookPersistencePort.save(bookDto);
    }

    @Override
    public void deleteBookById(Long id) {
        bookPersistencePort.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        return bookPersistencePort.updateBook(bookDto);
    }

    @Override
    public List<BookDto> getBooks() {
        return bookPersistencePort.findAll();
    }

    @Override
    public BookDto getBookById(Long bookId) {
        return bookPersistencePort.findById(bookId);
    }
}
