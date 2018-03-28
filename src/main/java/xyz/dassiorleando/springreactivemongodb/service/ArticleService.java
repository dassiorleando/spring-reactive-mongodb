package xyz.dassiorleando.springreactivemongodb.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.dassiorleando.springreactivemongodb.domain.Article;
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

    /**
     * To create/update article
     * @param article
     * @return saved/updated article
     */
    public Mono<Article> save(Article article) {
        return articleRepository.save(article);
    }

    /**
     * Find a single article by id
     * @param id
     * @return
     */
    public Mono<Article> findOne(String id) {
        return articleRepository.findById(id);
    }

    /**
     * Find all saved articles so fare
     * @return
     */
    public Flux<Article> findAll() {
        return articleRepository.findAll();
    }

    /**
     * Delete a single article by id
     * @param id
     */
    public Mono<Void> delete(String id) {
        return articleRepository.deleteById(id);
    }
}
