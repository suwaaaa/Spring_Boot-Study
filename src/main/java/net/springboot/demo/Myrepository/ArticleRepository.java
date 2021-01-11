package net.springboot.demo.Myrepository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.springboot.demo.domain.Article;


//@Component 
@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

	
	
	
	
}
