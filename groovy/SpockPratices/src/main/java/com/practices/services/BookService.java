package com.practices.services;

import com.practices.dto.Book;

public interface BookService {
    Book retrieveBookDetails(Integer bookId);
}
