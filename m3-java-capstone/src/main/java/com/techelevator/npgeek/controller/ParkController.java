package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.weather.WeatherDAO;

@Controller
public class ParkController {
	
	@Autowired
	ParkDAO parkDao;
	@Autowired
	WeatherDAO weatherDao;

	@RequestMapping({"/", "/homePage"})
	public String viewHomePage(ModelMap map) {
		map.put("parkList", parkDao.getAllParks());
		return "homePage";
	}
	
	@RequestMapping("/parkDetails")
	public String viewParkDetailPage(HttpSession session, ModelMap map, @RequestParam String parkCode) {
		map.put("park", parkDao.getParkByCode(parkCode));
		map.put("weather", weatherDao.getForecastByCode(parkCode));

		// Set default value
		if(session.getAttribute("isFahrenheit") == null) {
			session.setAttribute("isFahrenheit", true);
		}
		
		return "parkDetails";
	}
	
	@RequestMapping("/toggleTemperature")
	public String toggleTemperature(HttpSession session, @RequestParam String parkCode) {
		
		//set session "isFahrentheit" to !
		session.setAttribute("isFahrenheit", !(boolean)session.getAttribute("isFahrenheit"));
	
		return "redirect:/parkDetails?parkCode=" + parkCode + "#tempToggle";
	}
}
