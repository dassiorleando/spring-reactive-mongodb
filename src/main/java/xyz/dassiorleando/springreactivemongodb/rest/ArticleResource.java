package xyz.dassiorleando.springreactivemongodb.rest;

import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<Article>> create(@RequestBody Article article) {
        return articleService.save(article).map(ResponseEntity::ok);
    }

    /**
     * To update an article
     * @param article
     * @return
     */
    @PutMapping("/article")
    public Mono<ResponseEntity<Article>> update(@RequestBody Article article) {
        if (article.getId() == null) {
            return create(article);
        }
        return articleService.save(article).map(ResponseEntity::ok);
    }

    /**
     * Get the list of all articles
     * @return
     */
    @GetMapping("/article")
    public Flux<ResponseEntity<Article>> list() {
        return articleService.findAll().map(ResponseEntity::ok);
    }

    /**
     * We asynchronously find an article by his Id, return it with a success status if its found
     * and with the 404 and null object if not
     * @param id
     * @return
     */
    @GetMapping("/article/{id}")
    public Mono<ResponseEntity<Article>> findById(@PathVariable String id) {
        return articleService.findOne(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.status(404).body(null));
    }

    /**
     * Delete an article by its id
     * @param id
     */
    @DeleteMapping("/article/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable String id) {
        return articleService.delete(id).map(ResponseEntity::ok);
    }
}
