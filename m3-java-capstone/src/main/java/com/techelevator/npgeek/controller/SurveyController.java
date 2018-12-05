package com.techelevator.npgeek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.park.ParkDAO;
import com.techelevator.npgeek.model.survey.SurveyDAO;

@Controller
public class SurveyController {
	
	@Autowired
	ParkDAO parkDao;
	@Autowired
	SurveyDAO surveyDao;
	
	@RequestMapping(path="/parkSurvey", method=RequestMethod.GET)
	public String viewSurveyPage(ModelMap map) {
		map.put("parkList", parkDao.getAllParks());
		return "parkSurvey";
	}
	
	@RequestMapping(path="/parkSurvey", method=RequestMethod.POST)
	public String processSurveyPage(
								RedirectAttributes rA, 
								@RequestParam String parkCode, 
								@RequestParam String emailAddress, 
								@RequestParam String state, 
								@RequestParam String activityLevel) {

		//Include email validation
		if(emailAddress.isEmpty() || !emailAddress.contains("@")) {
			//They did not include an email!
			rA.addFlashAttribute("emailError", "No Email");
			return "redirect:/parkSurvey";
		}
		
		surveyDao.save(parkCode, emailAddress, state, activityLevel);
		
		return "redirect:/favoriteParks";
	}
	
	@RequestMapping("/favoriteParks")
	public String viewFavoriteParks(ModelMap map) {
		map.put("favoriteParks", parkDao.getFavoriteParks());
		return "favoriteParks";
	}

}
