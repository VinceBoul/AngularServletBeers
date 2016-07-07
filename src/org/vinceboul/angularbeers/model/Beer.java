package org.vinceboul.angularbeers.model;

import java.util.ArrayList;
import java.util.List;

import org.vinceboul.angularbeers.dao.BeerMongoDAO;


public class Beer {

	// Nom de la bière
	private String name;
	// Lieu de brassage
	private String place;
	//Instruction pour la boire
	private String drinkInstructions;
	// Degré d'alcool
	private Double alcool;
	// Disponibilité
	private String availability;
	// Style de la bière
		private String style;
	// Image
	private String image;

	public static List<Beer> getBeers(){
		
		return BeerMongoDAO.getBeerMongoDAOInstance().getBeerList();
		
	}

	
	private static ArrayList<Beer> getOracioBeers(){
		ArrayList<Beer> list = new ArrayList<Beer>();

		Beer beer;

		beer = new Beer();
		beer.setAlcohol(6.8);
		beer.setDescription("Affligem Blonde, the classic clear blonde abbey ale, with a gentle roundness and 6.8% alcohol. Low on bitterness, it is eminently drinkable.");
		beer.setImg("img/AffligemBlond.jpg");
		beer.setName("Affligem Blond");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(6.8);
		beer.setDescription("A reddish-brown abbey ale brewed with dark malts. The secondary fermentation gives a fruity aroma and a unique spicy character with a distinctive aftertaste. Secondary fermentation in the bottle.");
		beer.setImg("img/AffligemDubbel.jpg");
		beer.setName("Affligem Dubbel");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(8.5);
		beer.setDescription("The king of the abbey beers. It is amber-gold and pours with a deep head and original aroma, delivering a complex, full bodied flavour. Pure enjoyment! Secondary fermentation in the bottle.");
		beer.setImg("img/AffligemTripel.jpg");
		beer.setName("Affligem Tripel");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(7.5);
		beer.setDescription("Trappistes Rochefort 6 Belgian Beer.");
		beer.setImg("img/TrappistesRochefort6.jpg");
		beer.setName("Rochefort 6");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(9.2);
		beer.setDescription("A dry but rich flavoured beer with complex fruity and spicy flavours.");
		beer.setImg("img/TrappistesRochefort8.jpg");
		beer.setName("Rochefort 8");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(11.3);
		beer.setDescription("The top product from the Rochefort Trappist brewery. Dark colour, full and very impressive taste. Strong plum, raisin, and black currant palate, with ascending notes of vinousness and other complexities.");
		beer.setImg("img/TrappistesRochefort10.jpg");
		beer.setName("Rochefort 10");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(6.7);
		beer.setDescription("This name became a reference. This beer is mostly pointed out with its product name: a Paterke. This Paterke is a dark, chestnut coloured beer with a high fermentation (6.7%) and a full taste");
		beer.setImg("img/StBernardusPater6.jpg");
		beer.setName("St Bernardus Pater 6");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(8.0);
		beer.setDescription("This beer, with high fermentation, has a pale amber colour and a flowery, fruity taste with a harmonious balance between sweet and sour. This beer has a thick and vivid froth and strikes its balanced taste with a delicate bitterness.");
		beer.setImg("img/StBernardusTripel.jpg");
		beer.setName("St Bernardus Tripel");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(10.5);
		beer.setDescription("The top product from the Rochefort Trappist brewery. Dark colour, full and very impressive taste. Strong plum, raisin, and black currant palate, with ascending notes of vinousness and other complexities.");
		beer.setImg("img/StBernardusAbt12.jpg");
		beer.setName("St Bernardus Abt 12");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(7.0);
		beer.setDescription("This Trappist beer possesses a beautiful coppery colour that makes it particularly attractive. Topped with a creamy head, it gives off a slight fruity apricot smell from the fermentation. The aroma felt in the mouth is a balance confirming the fruit nuances revealed to the sense of smell. This traditional Belgian beer is best savoured at cellar temperature ");
		beer.setImg("img/ChimayRed.jpg");
		beer.setName("Chimay Rouge");
		list.add(beer);

		beer = new Beer();
		beer.setAlcohol(10.5);
		beer.setDescription("Chimay Triple, with its typical golden colour, its slightly hazy appearance and its fine head is especially characterised by its aroma which results from an agreeable combination of fresh hops and yeast. The beers flavour, as sensed in the mouth, comes from the smell of hops: above all it is the fruity notes of muscat and raisins that give this beer a particularly attractive aroma. The aroma complements the touch of bitterness. There is no acidity, but an after-bitterness which melts in the mouth. This top fermented Trappist beer, refermented in the bottle, is not pasteurised.");
		beer.setImg("img/ChimayTriple.jpg");
		beer.setName("Chimay Tripel");
		list.add(beer);

		return list;

	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImg(String image) {
		this.image = image;
	}

	/**
	 * @return the alcool
	 */
	public Double getAlcohol() {
		return (Double)alcool;
	}

	/**
	 * @param alcool the alcool to set
	 */
	public void setAlcohol(Double alcool) {
		this.alcool = (Double) alcool;
	}

	/**
	 * @return the drinkInstructions
	 */
	public String getDrinkInstructions() {
		return drinkInstructions;
	}

	/**
	 * @param drinkInstructions the drinkInstructions to set
	 */
	public void setDescription(String drinkInstructions) {
		this.drinkInstructions = drinkInstructions;
	}

	/**
	 * @return the place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * @param place the place to set
	 */
	public void setPlace(String place) {
		this.place = place;
	}

	/**
	 * @return the availability
	 */
	public String getAvailability() {
		return availability;
	}

	/**
	 * @param availability the availability to set
	 */
	public void setAvailability(String availability) {
		this.availability = availability;
	}

	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	 
}
