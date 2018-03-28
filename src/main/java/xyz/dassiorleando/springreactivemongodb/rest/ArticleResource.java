package xyz.dassiorleando.springreactivemongodb.rest;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import xyz.dassiorleando.springreactivemongodb.domain.Article;
import xyz.dassiorleando.springreactivemongodb.service.ArticleService;

@RestController
public class ArticleResource {
    private final ArticleService articleService;

    public ArticleResource(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * To create an article
     * @param article
     * @return
     */
    @PostMapping("/article")
    public Mono<Article> create(@RequestBody Article article) {
        return articleService.save(article);
    }

    /**
     * To update an article
     * @param article
     * @return
     */
    @PutMapping("/article")
    public Mono<Article> update(@RequestBody Article article) {
        if (article.getId() == null) {
            return create(article);
        }
        return articleService.save(article);
    }

    /**
     * Get the list of all articles
     * @return
     */
    @GetMapping("/article")
    public Flux<Article> list() {
        return articleService.findAll();
    }

    /**
     * Find an article by its id
     * @param id
     * @return
     */
    @GetMapping("/article/{id}")
    public Mono<Article> findById(@PathVariable String id) {
        return articleService.findOne(id);
    }

    /**
     * Delete an article by its id
     * @param id
     */
    @DeleteMapping("/article/{id}")
    public Mono<Void> deleteById(@PathVariable String id) {
        return articleService.delete(id);
    }
}
