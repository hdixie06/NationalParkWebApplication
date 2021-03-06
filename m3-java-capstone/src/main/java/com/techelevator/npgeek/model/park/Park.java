package com.techelevator.npgeek.model.park;

import java.text.NumberFormat;
import java.util.Locale;

public class Park {
	
	private String parkCode;
	private String parkName;
	private String state;
	private int acreage;
	private int elevation;		//in feet
	private double milesOfTrail;			
	private	int campsites;
	private String climate;
	private int yearFounded;
	private int annualVisitors;
	private String quote;
	private String quoteSource;
	private String description;
	private int entryFee;		//in dollars
	private int animalSpecies;
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public String getParkName() {
		return parkName;
	}
	
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public int getAcreage() {
		return acreage;
	}
	
	public void setAcreage(int acreage) {
		this.acreage = acreage;
	}
	
	public int getElevation() {
		return elevation;
	}
	
	public void setElevation(int elevation) {
		this.elevation = elevation;
	}
	
	public double getMilesOfTrail() {
		return milesOfTrail;
	}
	
	public void setMilesOfTrail(double milesOfTrail) {
		this.milesOfTrail = milesOfTrail;
	}
	
	public int getCampsites() {
		return campsites;
	}
	
	public void setCampsites(int campsites) {
		this.campsites = campsites;
	}
	
	public String getClimate() {
		return climate;
	}
	
	public void setClimate(String climate) {
		this.climate = climate;
	}
	
	public int getYearFounded() {
		return yearFounded;
	}
	
	public void setYearFounded(int yearFounded) {
		this.yearFounded = yearFounded;
	}
	
	public int getAnnualVisitors() {
		return annualVisitors;
	}
	
	public void setAnnualVisitors(int annualVisitors) {
		this.annualVisitors = annualVisitors;
	}
	
	public String getQuote() {
		return quote;
	}
	
	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	public String getQuoteSource() {
		return quoteSource;
	}
	
	public void setQuoteSource(String quoteSource) {
		this.quoteSource = quoteSource;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getEntryFee() {
		return entryFee;
	}
	
	public void setEntryFee(int entryFee) {
		this.entryFee = entryFee;
	}
	
	public int getAnimalSpecies() {
		return animalSpecies;
	}
	
	public void setAnimalSpecies(int animalSpecies) {
		this.animalSpecies = animalSpecies;
	}
	
	//Some derived properties because I'm not sure where else to put this
	public String getFormattedAcreage() {
		return NumberFormat.getNumberInstance(Locale.getDefault()).format(acreage);
	}
	
	public String getFormattedElevation() {
		return NumberFormat.getNumberInstance(Locale.getDefault()).format(elevation);
	}
	
	public String getFormattedMilesOfTrail() {
		return NumberFormat.getNumberInstance(Locale.getDefault()).format(milesOfTrail);
	}
	
	public String getFormattedAnnualVisitors() {
		return NumberFormat.getNumberInstance(Locale.getDefault()).format(annualVisitors);
	}
}
