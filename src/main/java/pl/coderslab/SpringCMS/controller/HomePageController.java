package pl.coderslab.SpringCMS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.SpringCMS.dao.ArticleDao;
import pl.coderslab.SpringCMS.entity.Article;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/", produces = "text/html; charset=UTF-8")
public class HomePageController {

    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @RequestMapping("/")
    @ResponseBody
    public String findLast5Articles() {
        StringBuilder infos = new StringBuilder();
        List<Article> articles = articleDao.findLast5Articles();
            for (Article a : articles) {
                infos.append("Title: ").append(a.getTitle())
                     .append(", created on: ").append(a.getCreated())
                     .append(", content: ").append(a.getContent());
            }
        return infos.toString();

    }

}
