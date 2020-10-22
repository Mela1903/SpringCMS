package pl.coderslab.SpringCMS.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.SpringCMS.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.awt.print.Book;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Article article) {
        entityManager.persist(article);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article) {
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }

    public List<Article> findAll(){
        Query query = entityManager.createQuery("SELECT a FROM Article a");
        return query.getResultList();
    }

    public List<Article> findLast5Articles(){
        Query query = entityManager.createQuery("SELECT b FROM Article b ORDER BY b.created DESC");
        query.setMaxResults(5);
        return query.getResultList();
    }

    public Article findById(long id) {
        return entityManager.find(Article.class, id);
    }

    public List<Article> findWithSpecificCategory(Long id) {
        Query query = entityManager.createQuery("SELECT b FROM Article b WHERE b.categories.id = :categoryId");
        query.setParameter("categoryId", id);
        return query.getResultList();
    }

    public List<Book> findWithSpecificAuthor(Long id) {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.author p WHERE p.id = :authorId");
        query.setParameter("authorId", id);
        return query.getResultList();
    }
}