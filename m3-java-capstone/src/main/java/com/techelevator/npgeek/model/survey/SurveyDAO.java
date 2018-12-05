package com.techelevator.npgeek.model.survey;

import java.util.List;

public interface SurveyDAO {
	
	public List<SurveyPost> getAllSurveys();
	public void save(String parkCode, String emailAddress, String state, String activityLevel);

}
