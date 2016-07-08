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
import com.mongodb.client.model.Filters;

/**
 * @author Vince
 *
 */
public class BeerMongoDAO {

	private MongoClient client;
	private MongoDatabase database;
	private MongoCollection<Document> collection;

	// Constructeur privé
	private BeerMongoDAO() {
		this.client = new MongoClient("localhost");
		this.database = this.client.getDatabase("vince");
		this.collection = this.database.getCollection("beers");
	}

	// Instance static, donc une "beerMongoDAO" par application qui tourne
	private static BeerMongoDAO beerMongoDAO;

	public static BeerMongoDAO getBeerMongoDAOInstance() {
		if (beerMongoDAO == null) {
			beerMongoDAO = new BeerMongoDAO();
		}
		return beerMongoDAO;
	}

	public List<Beer> getBeerList() {
		List<Beer> beers = new ArrayList<Beer>();
		MongoCursor<Document> cursor = this.collection.find().iterator();

		while (cursor.hasNext()) {
			beers.add(createBeerWithCursor(cursor));
		}
		return beers;
	}

	private Beer createBeerWithCursor(MongoCursor<Document> cursor) {
		Document doc = cursor.next();
		Beer beer = new Beer();
		beer.setName(doc.getString("name"));
		beer.setDescription(doc.getString("description"));
		beer.setStyle(doc.getString("style"));
		beer.setBrewery(doc.getString("brewery"));
		beer.setServing(doc.getString("serving"));

		Object alcohol = doc.get("alcohol");
		/*if (alcohol instanceof Double) {
			beer.setAlcohol((Double) alcohol);
		} else {
			beer.setAlcohol(((Integer) alcohol).doubleValue());
		}*/
		beer.setAlcohol(4.5);
		if (doc.getString("id") != null) {
			beer.setImg(doc.getString("img"));
			beer.setId(doc.getString("id"));
		} else {
			beer.setImg("beers/img/" + doc.getString("name") + ".jpg");
			beer.setId(doc.getString("name") + ".jpg");

		}

		return beer;
	}

	public void insertBeer(Beer beer) {
		Document doc = this.generateBeerDocument(beer);
		this.collection.insertOne(doc);
	}

	public void updateBeer(Beer updatedBeer) {
		Document newDoc = this.generateBeerDocument(updatedBeer);
		this.collection.findOneAndReplace(Filters.eq("id", updatedBeer.getId()), newDoc);
	}

	private Document generateBeerDocument(Beer beer) {
		Document doc = new Document("name", beer.getName())
				.append("alcohol", beer.getAlcohol())
				.append("style", beer.getStyle())
				.append("description", beer.getDescription())
				.append("availability", beer.getAvailability())
				.append("brewery", beer.getBrewery())
				.append("serving", beer.getServing())
		;
		// Si c'est une bière d'Oracio, on laisse l'id
		if (beer.getId() != null) {
			doc.append("id", beer.getId());
		}else{
			// Sinon on en génère un nouveau
			doc = setBeerDocId(doc);
		}
		return doc;
	}
	
	private Document setBeerDocId(Document doc){
		List<Beer> beerList = Beer.getBeers();
		doc.append("id", Integer.toString(beerList.size()) );
		return doc;
	}

	public Beer getBeer(String json) {
		System.out.println(json);
		// TODO Auto-generated method stub
		Document doc = this.collection.find(Filters.eq("id", json)).first();
		if (doc.getString("name") != null){
			System.out.println(doc.getString("name"));
			System.out.println(doc.getString("serving"));

		}else{
			System.out.println("on a un pb");

		}
		
		return createBeerFromDocument(doc);
	}
	
	private Beer createBeerFromDocument(Document doc) {
		Beer beer = new Beer();
		beer.setId(doc.getString("id"));
		beer.setName(doc.getString("name"));
		beer.setDescription(doc.getString("description"));
		beer.setStyle(doc.getString("style"));
		beer.setBrewery(doc.getString("brewery"));
		beer.setServing(doc.getString("serving"));
		beer.setAvailability(doc.getString("availability"));
		beer.setImg(doc.getString("img"));

		return beer;
	}

	public void deleteBeer(Beer beer) {
		//Document newDoc = this.generateBeerDocument(beer);
		this.collection.deleteOne(Filters.eq("id", beer.getId()));
	}
}
