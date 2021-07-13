package com.sillycat.lambda.service;

import com.sillycat.lambda.model.Article;

public class ArticleService {
	
	
	public Article get(String id) {
		Article item = new Article();
		item.setAuthor("Carl");
		item.setContent("like to use and demo with java");
		item.setId("1");
		item.setTitle("lambda and java");
		return item;
	}
	
	public Article create(Article article) {
		article.setId("101");
		return article;
	}

}
