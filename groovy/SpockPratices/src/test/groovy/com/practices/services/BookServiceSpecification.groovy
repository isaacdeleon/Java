package com.practices.services

import com.practices.dto.Book
import com.practices.repository.BookRepository
import com.practices.services.impl.BookServiceImpl
import spock.lang.Specification

class BookServiceSpecification extends Specification {
    BookServiceImpl bookService;
    BookRepository bookRepository;

    def setupSpec() {
        println "setupSpec() - Runs once per Specification"
    }

    def setup() {
        println "setup() - Runs before every feature method"
        bookService = new BookServiceImpl()
        bookRepository = Stub(BookRepository)
        bookService.setBookRepository(bookRepository)

        bookRepository.getBook(_) >> {int id ->
            if (id == 1) {
                Book b = new Book(1, 'Srujana', 'Spock Tut');
                println ("+++++++ " + b.toString());
                return b;
            } else if (id == 2) {
                Book b = new Book(2, 'Eugen', 'JUnit Tut');
                println("+++++++ " + b.toString());
                return b;
            } else if (id == 3) {
                println("Book with this ID does not exist");
                return null;
            } else if (id <= 0) {
                println("Exception thrown");
                throw new IllegalArgumentException("Invalid Book ID");
            }
        }
    }

    def "retrieved book object is not null"() {
        println "Feature method 1 - retrieved book object is not null- start"
        expect :
            bookService.retrieveBookDetails(id) != null
        where :
            id << [1, 2]
    }

    def "retrieved book object is null"(){
        println ("Feature method - 2 retrieved book object is null - start");
        expect :
            bookService.retrieveBookDetails(id) == null
        where :
            id << 3
    }

    def "book id is must be greater than 0"() {
        println "Feature method 3 - book id must be greater than 0 - start"
            given:
            when:
                bookService.retrieveBookDetails(-3);
            then:
                thrown(IllegalArgumentException)
    }

    def cleanup() {
        println "Cleanup method - Runs after every feature method."
    }

    def cleanupSpec() {
        println "cleanupSpec() - Runs only once per specification"
    }
}
