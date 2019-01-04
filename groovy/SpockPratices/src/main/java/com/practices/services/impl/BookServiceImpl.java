package com.practices.services.impl;

import com.practices.dto.Book;
import com.practices.repository.BookRepository;
import com.practices.services.BookService;

public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book retrieveBookDetails(Integer bookId) {
        return bookRepository.getBook(bookId);
    }
}
