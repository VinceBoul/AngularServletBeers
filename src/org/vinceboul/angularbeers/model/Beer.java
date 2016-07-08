package org.vinceboul.angularbeers.model;

import java.util.List;

import org.vinceboul.angularbeers.dao.BeerMongoDAO;


public class Beer {

	// ID de la bière -> slug du nom
	private String id;
	// Nom de la bière
	private String name;
	// Lieu de brassage
	private String brewery;
	//Instruction pour la boire
	private String serving;
	// Degré d'alcool
	private Double alcohol;
	// Disponibilité
	private String availability;
	// Style de la bière
	private String style;
	// Description
	private String description;
	// Image
	private String image;
	// Image
	private String label;

	public static List<Beer> getBeers(){
		
		return BeerMongoDAO.getBeerMongoDAOInstance().getBeerList();
		
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
		return (Double)alcohol;
	}

	/**
	 * @param alcool the alcool to set
	 */
	public void setAlcohol(Double alcohol) {
		this.alcohol = (Double) alcohol;
	}

	/**
	 * @return the drinkInstructions
	 */
	public String getServing() {
		return serving;
	}

	/**
	 * @param drinkInstructions the drinkInstructions to set
	 */
	public void setServing(String serving) {
		this.serving = serving;
	}

	/**
	 * @return the place
	 */
	public String getBrewery() {
		return brewery;
	}

	/**
	 * @param place the place to set
	 */
	public void setBrewery(String brewery) {
		this.brewery = brewery;
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


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}


	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	 
}
