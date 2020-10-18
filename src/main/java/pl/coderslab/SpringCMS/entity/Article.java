package pl.coderslab.SpringCMS.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 200)
    private String title;
    @OneToOne
    private Author author;
    @OneToMany(mappedBy = "article")
    private List<Category> categories = new ArrayList<>();
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    @PrePersist
    public void prePersist(){
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updated = LocalDateTime.now();
    }

    public Article() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public Article setAuthor(Author author) {
        this.author = author;
        return this;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Article setCategories(List<Category> categories) {
        this.categories = categories;
        return this;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
