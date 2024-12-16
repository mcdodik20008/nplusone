package mcdodik.npusone.controller;

import mcdodik.npusone.model.Author;
import mcdodik.npusone.model.Book;
import mcdodik.npusone.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(value = "/", produces = "application/json")
    public List<Author> printAuthorsWithBooks() {
        List<Author> authors = authorRepository.findAll();

        for (Author author : authors) {
            System.out.println("Author: " + author.getName());
            for (Book book : author.getBooks()) {
                System.out.println("  Book: " + book.getTitle());
            }
        }
        return authors;
    }
}

