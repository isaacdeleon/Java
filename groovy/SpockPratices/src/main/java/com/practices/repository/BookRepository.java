package com.practices.repository;

import com.practices.dto.Book;

public interface BookRepository {

    Book getBook(Integer bookId);

}
