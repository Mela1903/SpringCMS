package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.SpringCMS.dao.CategoryDao;
import pl.coderslab.SpringCMS.entity.Category;
import java.util.List;

@Controller
@RequestMapping(value = "/cat", produces = "text/html; charset=UTF-8")
public class CategoryController {

    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @GetMapping("/list")
    public String findAll(Model m) {
        List<Category> categories= categoryDao.findAll();
        m.addAttribute("categories", categories);
        return "category/list";
    }

    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryDao.findAll();
    }

    @GetMapping("/add")
    public String addCategory(Model m) {
        m.addAttribute("category", new Category());
        return "category/add-form";
    }

    @PostMapping("/add")
    public String addCategoryPost(@ModelAttribute Category category){
        this.categoryDao.save(category);
        return "redirect: list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCategory(@PathVariable long id) {
        Category category = categoryDao.findById(id);
        categoryDao.delete(category);
        return "redirect: ../list";
    }


    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable long id, Model m) {
        Category categoryEdited = categoryDao.findById(id);
        m.addAttribute("categoryEdited", categoryEdited);
        m.addAttribute("category", new Category());
        return "category/update-form";
    }

    @PostMapping("/update")
    public String updateAndSave(@ModelAttribute Category category) {
        categoryDao.update(category);
        return "redirect: list";
    }

}
