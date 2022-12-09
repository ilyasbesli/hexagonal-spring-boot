package org.hexagonal.adapters;

import org.hexagonal.mappers.BookMapper;
import org.hexagonal.repository.BookRepository;
import org.hexagonal.data.BookDto;
import org.hexagonal.ports.spi.BookPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookPersistenceAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Long save(BookDto bookDto) {
        return bookRepository.save(bookMapper.toModel(bookDto)).getId();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        bookRepository.findById(bookDto.getId())
                .ifPresent(book -> {
                    book.setTitle(bookDto.getTitle());
                    book.setDescription(book.getDescription());
                    book.setPrice(book.getPrice());
                    bookRepository.save(book);
                });
        return findById(bookDto.getId());
    }

    @Override
    public List<BookDto> findAll() {

        return bookRepository.findAll()
                .stream()
                .map(book -> bookMapper.toDto(book))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto findById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(book -> bookMapper.toDto(book))
                .orElse(BookDto.builder().build());
    }
}
