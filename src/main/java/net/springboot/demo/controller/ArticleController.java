package net.springboot.demo.controller;

import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.springboot.demo.Myrepository.ArticleRepository;
import net.springboot.demo.domain.Article;
import net.springboot.demo.domain.JsonData;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
	/*
	 * 查看索引信息：http://localhost:9200/_cat/indices?v
	 * 查看某个索引库结构：http://localhost:9200/blog
	 * 查看某个对象：http://localhost:9200/blog/article/1
	 */
//	@Autowired
	@Autowired(required=false)
	private ArticleRepository articleRepository;
	
	@GetMapping("/save")
	public Object save(long id,String title){
//		long id,String title
		Article article = new Article();
		article.setId(id);
		article.setPv(123);
		article.setContent("springboot整合elasticsearch");
		article.setTitle(title);
		article.setSummary("搜索框架整合");
		
		articleRepository.save(article);
	
		return JsonData.buildSuccess();
	}
	
	
	
	
	@GetMapping("search")
	public Object search(String title){

		//QueryBuilder queryBuilder = QueryBuilders.matchAllQuery(); //搜索全部文档
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("title", title); 

		Iterable<Article> list =  articleRepository.search(queryBuilder);
		
		return JsonData.buildSuccess(list);
	}
	
	
	
	
}
