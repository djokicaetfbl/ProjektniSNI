package org.unibl.etf.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.unibl.etf.dao.ArticleDAO;
import org.unibl.etf.dto.Article;

@Path("article")
public class ArticleService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Article> getAll(){
		return ArticleDAO.getAllArticless();
	}

}
