package mcdodik.npusone.repository;

import mcdodik.npusone.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("select a from Author a join fetch a.books")
    List<Author> findAllWithQuery();

}
