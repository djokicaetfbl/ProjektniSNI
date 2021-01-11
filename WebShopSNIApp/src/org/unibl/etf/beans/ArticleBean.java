package org.unibl.etf.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.unibl.etf.dao.ArticleDAO;
import org.unibl.etf.dto.Article;

public class ArticleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Article article;
	
	private ArrayList<Article> articleArrayList;

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArrayList<Article> getArticleArrayList() {
		return articleArrayList;
	}

	public void setArticleArrayList(ArrayList<Article> articleArrayList) {
		this.articleArrayList = articleArrayList;
	}
	
	public boolean add(Article article) {
		this.article = article;
		boolean result = ArticleDAO.add(article);
		return result;
	}
	
	public boolean updateArticle(Article article) {
		return ArticleDAO.updateArticle(article);
	}
		
	public boolean updateArticleToInactive(Article article) {
		return ArticleDAO.updateArticleToInactive(article);
	}

	
}
