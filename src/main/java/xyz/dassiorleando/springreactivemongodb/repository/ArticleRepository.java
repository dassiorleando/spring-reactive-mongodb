package xyz.dassiorleando.springreactivemongodb.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import xyz.dassiorleando.springreactivemongodb.domain.Article;

/**
 * Spring Data MongoDB reactive repository for the Article entity.
 * @author dassiorleando
 */
@Repository
public interface ArticleRepository extends ReactiveMongoRepository<Article, String> {
}
