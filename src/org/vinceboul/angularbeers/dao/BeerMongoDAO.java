/**
 * 
 */
package org.vinceboul.angularbeers.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.vinceboul.angularbeers.model.Beer;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * @author Vince
 *
 */
public class BeerMongoDAO {

	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
		
	// Constructeur privé
	private BeerMongoDAO(){
		this.client = new MongoClient("localhost");
		this.database = this.client.getDatabase("vince");
		this.collection = this.database.getCollection("beers");
	}
	
	// Instance static, donc une "beerMongoDAO" par application qui tourne
	private static BeerMongoDAO beerMongoDAO;

	public static BeerMongoDAO getBeerMongoDAOInstance(){
		if (beerMongoDAO == null){
			beerMongoDAO = new BeerMongoDAO();
		}
		return beerMongoDAO;
	}

	public List<Beer> getBeerList(){
		List<Beer> beers = new ArrayList<Beer>();
		MongoCursor<Document> cursor = this.collection.find().iterator();

		while (cursor.hasNext()){
			beers.add(createBeerWithCursor(cursor) );
		}
		return beers;
	}
	
	private Beer createBeerWithCursor(MongoCursor<Document> cursor){
		Document doc = cursor.next();
		Beer beer = new Beer();
		beer.setName(doc.getString("Name"));
		beer.setDescription(doc.getString("description"));
		
		Object alcohol = doc.get("alcohol");
		if ( alcohol instanceof Double ){
			beer.setAlcohol((Double) alcohol);
		}else{
			beer.setAlcohol( ( (Integer)alcohol).doubleValue());
		}
		//beer.setAlcohol(Double.valueOf(doc.getString("alcohol")));
		beer.setImg(doc.getString("img"));
		return beer;
	}
	
	public void insertBeer(Beer beer){
		Document doc = this.generateBeerDocument(beer);
		this.collection.insertOne(doc);
	}
	
	private Document generateBeerDocument(Beer beer){
		Document doc = new Document("name", beer.getName())
			.append("alcohol", beer.getAlcohol())
			.append("style", beer.getStyle())
			.append("description", beer.getDrinkInstructions())
			.append("availability", beer.getAvailability())
			.append("place", beer.getPlace())
		;
		return doc;
	}
}
