package org.hexagonal.mappers;

import org.hexagonal.entity.Book;
import org.hexagonal.data.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toDto(Book book);

    Book toModel(BookDto bookDto);
}
