package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String parkCode;
	private int dayValue;
	private int low;
	private int high;
	private String forecast;
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public int getDayValue() {
		return dayValue;
	}
	
	public void setDayValue(int dayValue) {
		this.dayValue = dayValue;
	}
	
	public int getLow() {
		return low;
	}
	
	public void setLow(int low) {
		this.low = low;
	}
	
	public int getHigh() {
		return high;
	}
	
	public void setHigh(int high) {
		this.high = high;
	}
	
	public String getForecast() {
		return forecast;
	}
	
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	/*
	 * Returns preparation recommendations for parkers based on weather conditions.
	 */
	public List<String> getWeatherRecommendation() {
		List<String> recommendations = new ArrayList<>();
		//conditionals based on forecast
		if(forecast.equals("snow")) {
			recommendations.add("pack snowshoes");
		} else if(forecast.equals("rain")) {
			recommendations.add("pack rain gear and wear waterproof shoes");
		} else if(forecast.equals("thunderstorms")) {
			recommendations.add("seek shelter and avoid hiking on exposed ridges");
		} else if(forecast.equals("sunny")) {
			recommendations.add("pack sunblock");
		}
		//conditionals based on temperature
		if(high > 75) {
			recommendations.add("bring an extra gallon of water");
		} else if(low < 20) {
			recommendations.add("be careful of exposure to frigid temperatures");
		}
		if(high - low > 20) {
			recommendations.add("wear breathable layers");
		}
		return recommendations;
	}
	
	public String getFormattedImageName() {
		String formattedForecast = "";
		if(forecast.contains(" ")) {
			int spaceIndex = forecast.indexOf(" ");
			String nameHalf1 = forecast.substring(0, spaceIndex);
			String nameHalf2 = forecast.substring(spaceIndex +1);
			formattedForecast = nameHalf1.concat(nameHalf2);
		} else {
			formattedForecast = forecast;
		}
		return formattedForecast;
	}
	//TODO could do temp conversions in this object
}
