package org.vinceboul.angularbeers.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.vinceboul.angularbeers.model.Beer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class BeerList
 */
@WebServlet("/BeerList")
public class BeerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Beer> beerList = Beer.getBeers();
		// ObjectMapper 
		ObjectMapper mapper = new ObjectMapper();
		// Tranformation de la liste d'objets en JSON
		String jsonBeerList = mapper.writeValueAsString(beerList);
		//return beerList;
		response.getWriter().append(jsonBeerList);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
}
