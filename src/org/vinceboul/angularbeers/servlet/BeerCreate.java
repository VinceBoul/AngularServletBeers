package org.vinceboul.angularbeers.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.vinceboul.angularbeers.dao.BeerMongoDAO;
import org.vinceboul.angularbeers.model.Beer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class BeerList
 */
@WebServlet("/BeerCreate")
public class BeerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StringBuilder beerBuff;
	private BufferedReader beerReader;
	// ObjectMapper 
	private ObjectMapper mapper;
	
	private Beer beer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerCreate() {
    	super();
    	this.beerBuff = new StringBuilder();
    	this.mapper = new ObjectMapper();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Initialisation du reader
		this.beerReader = request.getReader();
		
		// Création d'une nouvelle bière
		this.createBeer();
		
	}
	
	private void createBeer() {
		try {
			this.beer = this.mapper.readValue(this.getJSON(), Beer.class);
			BeerMongoDAO.getBeerMongoDAOInstance().insertBeer(beer);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// Retourne le JSON lu dans la requête HTTP
	private String getJSON() throws IOException{
		String line;
		// Lit chaque ligne
		while ( (line = this.beerReader.readLine()) != null) {
			// Ajoute la ligne lue dans le buffer
			this.beerBuff.append(line);
		}
		// Retourne tout le buffer, c'est à dire le JSON
		return beerBuff.toString();
	}

	
}
