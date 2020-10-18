package pl.coderslab.SpringCMS.controller;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.SpringCMS.dao.ArticleDao;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Author;
import pl.coderslab.SpringCMS.entity.Category;

import javax.transaction.Transactional;
import java.awt.print.Book;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/art", produces = "text/html; charset=UTF-8")
public class ArticleController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;


    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }


    @GetMapping("/list")
    @Transactional
    public String findAll(Model m) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        List<Article> articles = articleDao.findAll();
        for(Article a : articles){
        Hibernate.initialize(a.getCategory());
        }
        m.addAttribute("articles", articles);
        m.addAttribute("formatter", formatter);
        return "article/list";
    }

    @ModelAttribute("articles")
    public List<Article> articles(){
        return articleDao.findAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryDao.findAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors(){
        return authorDao.findAll();
    }

    @GetMapping("/add")
    public String addArticle(Model m) {
        m.addAttribute("article", new Article());
        return "article/add-form";
    }

    @PostMapping("/add")
    public String addArticlePost(@ModelAttribute Article article){
        this.articleDao.save(article);
        return "redirect: list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect: ../list";
    }


    @GetMapping("/edit/{id}")
    public String editArticleForm(@PathVariable long id, Model m) {
        Article articleEdited = articleDao.findById(id);
        m.addAttribute("articleEdited", articleEdited);
        m.addAttribute("article", new Category());
        return "article/update-form";
    }

    @PostMapping("/update")
    public String updateAndSave(@ModelAttribute Article article) {
        articleDao.update(article);
        return "redirect: list";
    }


}
