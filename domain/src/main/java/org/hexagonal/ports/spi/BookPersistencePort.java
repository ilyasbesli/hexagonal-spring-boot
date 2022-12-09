package org.hexagonal.ports.spi;

import org.hexagonal.data.BookDto;

import java.util.List;

public interface BookPersistencePort {

    Long save(BookDto bookDto);

    void deleteById(Long id);

    BookDto updateBook(BookDto bookDto);

    List<BookDto> findAll();

    BookDto findById(Long bookId);

}
