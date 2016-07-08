package org.vinceboul.angularbeers.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;
import org.vinceboul.angularbeers.dao.BeerMongoDAO;
import org.vinceboul.angularbeers.model.Beer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class BeerList
 */
@WebServlet("/BeerDetail")
public class BeerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StringBuilder beerBuff;
	private BufferedReader beerReader;
	// ObjectMapper 
	private ObjectMapper mapper;
	
	private Beer beer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerDetail() {
    	super();
    	this.beerBuff = new StringBuilder();
    	this.mapper = new ObjectMapper();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initialisation du reader
		this.beerReader = request.getReader();
		// Création d'une nouvelle bière
		String beerJSON = "";

		String paramValue = request.getParameter("beerId");

		if (paramValue==null) {
			System.out.println("Il manque un paramètre GET");
		}
		
		this.beer = BeerMongoDAO.getBeerMongoDAOInstance().getBeer(paramValue);
		beerJSON = mapper.writeValueAsString(beer);
		
		response.getWriter().append(beerJSON);
	}
	
}
