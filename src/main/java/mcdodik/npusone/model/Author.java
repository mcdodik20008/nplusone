package mcdodik.npusone.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
    @Fetch(FetchMode.SELECT)
    private Set<Book> books;

    public String getName(){
        return name;
    }

    public Set<Book> getBooks(){
        return books;
    }
}