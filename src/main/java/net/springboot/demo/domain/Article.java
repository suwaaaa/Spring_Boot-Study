package net.springboot.demo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 功能描述：文章对象，
 *
 * 
 *注意点：
 				索引名称记得小写，类属性名称也要小写
 			新建实体对象article
 			加上类注解 @Document(indexName = "blog", type = "article")

 *
 */
@Document(indexName = "blog")
public class Article implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long id;
	
	@Field(type = FieldType.Text,analyzer = "ik_max_word")
	private String title;
	@Field(type = FieldType.Text,analyzer = "ik_max_word")
	private String summary;
	@Field(type = FieldType.Text,analyzer = "ik_max_word")
	private String content;
	@Field(type = FieldType.Text,analyzer = "ik_max_word")
	private int pv;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
	
	

}
