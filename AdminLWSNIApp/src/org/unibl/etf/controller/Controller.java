package org.unibl.etf.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.unibl.etf.beans.ArticleBean;
import org.unibl.etf.dto.Article;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String address = "/WEB-INF/pages/adminLW.jsp";	
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		ArticleBean articleBean = new ArticleBean();
		
		if ("logout".equals(action)) {
			session.invalidate();
			address = "/login.jsp";
		}else if("addArticle".equals(action)) {			
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			if(name != null && price != null) {
				
				Article article = new Article();
				article.setName(name);
				article.setPrice(Double.parseDouble(price));
				article.setActive(true);
				
				if(articleBean.add(article)) {
					//System.out.println("USPJESNO DODAT :D ");
					address = "/WEB-INF/pages/adminLW.jsp";
				}			
			}			
		}else if("editArticle".equals(action)) {
			//System.out.println("DA EDIT SANJA PALAVESTRA <3");
			
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String idArticle = request.getParameter("id");

			if(name != null && price != null && idArticle != null) {
				Article article = new Article();
				
				article.setId(Integer.parseInt(idArticle));
				article.setName(name);
				article.setPrice(Double.parseDouble(price));
				article.setActive(true);
				
				if(articleBean.updateArticle(article)) {
					System.out.println("UPDATE IZVRSEN !");
				}
				
			}
			address = "/WEB-INF/pages/adminLW.jsp";
		} else if("setUnactiveArticle".equals(action)) {
			//System.out.println("DA DELETE SANJA PALAVESTRA <3");
			
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String idArticle = request.getParameter("id");
			
			if(name != null && price != null && idArticle != null) {
				Article article = new Article();
				
				article.setId(Integer.parseInt(idArticle));
				article.setName(name);
				article.setPrice(0.0);
				article.setActive(false);
				
				if(articleBean.updateArticleToInactive(article)) {
					System.out.println("DELETE IZVRSEN !");
				}
				
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
