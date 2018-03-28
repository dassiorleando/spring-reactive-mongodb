package xyz.dassiorleando.springreactivemongodb.service;

import org.springframework.stereotype.Service;
import xyz.dassiorleando.springreactivemongodb.repository.ArticleRepository;

/**
 * Article service for basic CRUD operations
 * @author dassiorleando
 */
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
}
