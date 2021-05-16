package com.evergreen.service;

import com.evergreen.dao.ArticleRepository;
import com.evergreen.entities.Article;
import com.evergreen.entities.GreenPoint;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class ArticleService {
    @Autowired
    public ArticleRepository articleRepository;

    public Optional<Article> getArticle(final Long id) {
        return articleRepository.findById(id);
    }
    public List<Article> getArticles() {
        return articleRepository.findAll();
    }
    public Article save(Article article) {
        return articleRepository.save(article);
    }
    public void delete(Long id) {
         articleRepository.deleteById(id);
    }

}
