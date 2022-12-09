package org.hexagonal.configuration;

import org.hexagonal.adapters.BookPersistenceAdapter;
import org.hexagonal.ports.api.BookServicePort;
import org.hexagonal.ports.spi.BookPersistencePort;
import org.hexagonal.service.BookServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {

    @Bean
    public BookPersistencePort bookPersistence(){
        return new BookPersistenceAdapter();
    }

    @Bean
    public BookServicePort bookService(){
        return new BookServiceImpl(bookPersistence());
    }
}
