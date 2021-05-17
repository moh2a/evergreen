package com.evergreen.web;

import com.evergreen.entities.Article;
import com.evergreen.entities.GreenPoint;
import com.evergreen.entities.User;
import com.evergreen.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import util.FileUpload;

import java.io.IOException;
import java.sql.Date;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "article", method = RequestMethod.GET)
    public String viewGreenPoint(Model model, @RequestParam(name = "ref", defaultValue = "")
            Long idArticle, @RequestParam(name = "mc", defaultValue = "") String mc) {
        model.addAttribute("article", articleService.getArticle(idArticle).get());
        return "article";
    }
    @PostMapping("article")
    public String saveArticle(@RequestParam(name = "titre") String titre,
                              @RequestParam(name = "texte") String texte,
                              @RequestParam(name = "image") MultipartFile multipartFile,
                              @RequestParam(name = "description") String description, Model model) throws IOException {

        String fileName = null;
        if(multipartFile!=null) {
            fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        }
        Article article = new Article(titre, description, texte, fileName);
        article = articleService.save(article);
        if(multipartFile!=null) {
            String uploadDir = "src/main/resources/static/images/articles/" + article.getIdArticle();
            FileUpload.saveFile(uploadDir, fileName, multipartFile);
        }

        return "redirect:/article?ref=" + article.getIdArticle();
    }
}
