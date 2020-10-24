package pl.coderslab.SpringCMS.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.dao.ArticleDao;
import pl.coderslab.SpringCMS.dao.AuthorDao;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Article;
import pl.coderslab.SpringCMS.entity.Author;
import pl.coderslab.SpringCMS.entity.Category;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping(value = "/aut", produces = "text/html; charset=UTF-8")
public class AuthorController {

    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    @Autowired
    public AuthorController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    @Transactional
    public String findAll(Model m) {
        List<Author> authors = authorDao.findAll();
        m.addAttribute("authors", authors);
        return "author/list";
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
    public String addAuthor(Model m) {
        m.addAttribute("author", new Author());
        return "author/add-form";
    }

    @PostMapping("/add")
    public String addAuthorPost(@ModelAttribute("author") @Valid Author author, BindingResult result, Model m){
        if (result.hasErrors()){
            return "author/add-form";
        }
        authorDao.save(author);
        m.addAttribute("author", author);
        return "redirect:list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteArticle(@PathVariable long id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect: ../list";
    }


    @GetMapping("/edit/{id}")
    public String editArticleForm(@PathVariable long id, Model m) {
        Author authorEdited = authorDao.findById(id);
        m.addAttribute("authorEdited", authorEdited);
        m.addAttribute("author", new Author());
        return "author/update-form";
    }

    @PostMapping("/update")
    public String updateAndSave(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect: list";
    }

}
