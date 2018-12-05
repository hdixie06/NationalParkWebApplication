package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<SurveyPost> getAllSurveys() {
		List<SurveyPost> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			allSurveys.add(mapRowToSurvey(results));
		}
		return allSurveys;
	}

	@Override
	//Removed surveyId as a specific entry, should auto-generate but come back to this if needed
	public void save(String parkCode, String emailAddress, String state, String activityLevel) {
		String sqlInsertSurvey = "INSERT INTO survey_result(parkcode, emailaddress, state, activitylevel) "
				+ "VALUES(?, ?, ?, ?);";
//		Long id = getNextId();
		jdbcTemplate.update(sqlInsertSurvey, parkCode, emailAddress, state, activityLevel);
//		post.setId(id);		
	}

	private SurveyPost mapRowToSurvey(SqlRowSet results) {
		SurveyPost post = new SurveyPost();
		post.setId(results.getLong("surveyid"));
		post.setParkCode(results.getString("parkcode"));
		post.setEmailAddress(results.getString("emailaddress"));
		post.setState(results.getString("state"));
		post.setActivityLevel(results.getString("activitylevel"));
		return post;
	}

	//Thanks for the code!
//	private Long getNextId() {
//		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId');";
//		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
//		if(result.next()) {
//			return result.getLong(1);
//		} else {
//			throw new RuntimeException("Something went wrong while getting the next product id");
//		}
//	}

}
