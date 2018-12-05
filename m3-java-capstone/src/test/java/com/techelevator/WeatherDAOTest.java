package com.techelevator;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.JDBCWeatherDAO;
import com.techelevator.npgeek.model.weather.WeatherDAO;

public class WeatherDAOTest extends DAOIntegrationTest {

	@Test
	public void testGetForecastByCode() {
		// Create instance of WeatherDAO and give it the test DataSource, also a
		// jdbctemplate
		WeatherDAO weatherDao = new JDBCWeatherDAO(getDataSource());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		// Create a fake park for testing purposes
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, "
				+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES ('TEST', 'Test Park', 'Ohio', 99999, 6600, 123.4, 5, 'City', 2018, 27, "
				+ "'When the going gets tough, the tough take a nap.', 'Al Nachman', "
				+ "'This is a test site for testing', 14000, 1);";

		jdbcTemplate.update(sqlInsertPark);

		// Create a fake forecast (5 times)
		for (int i = 0; i < 5; i++) {
			String sqlInsertWeather = "INSERT INTO weather (parkCode, fiveDayForecastValue, low, high, forecast) "
					+ "VALUES ('TEST', ?, 35, 40, 'cold');";
			jdbcTemplate.update(sqlInsertWeather, i + 1);
		}

		// Run the method and check if we get results (length 5)
		assertEquals("Test getFiveDayForecast", 5, weatherDao.getForecastByCode("TEST").size());
	}
	
	@Test
	public void testGetForecastByCodeMatch() {
		// Create instance of WeatherDAO and give it the test DataSource, also a
		// jdbctemplate
		WeatherDAO weatherDao = new JDBCWeatherDAO(getDataSource());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());

		// Create a fake park for testing purposes
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, "
				+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES ('TEST', 'Test Park', 'Ohio', 99999, 6600, 123.4, 5, 'City', 2018, 27, "
				+ "'When the going gets tough, the tough take a nap.', 'Al Nachman', "
				+ "'This is a test site for testing', 14000, 1);";

		jdbcTemplate.update(sqlInsertPark);

		// Create a fake forecast (5 times)
		for (int i = 0; i < 5; i++) {
			String sqlInsertWeather = "INSERT INTO weather (parkCode, fiveDayForecastValue, low, high, forecast) "
					+ "VALUES ('TEST', ?, 35, 40, 'cold');";
			jdbcTemplate.update(sqlInsertWeather, i + 1);
		}
		
		//Make a list to hold the returns
		List<Weather> forecastList = weatherDao.getForecastByCode("TEST");

		// Run the method and check if each return has the right code.
		assertEquals("Test getFiveDayForecast Code0", "TEST", forecastList.get(0).getParkCode());
		assertEquals("Test getFiveDayForecast Code1", "TEST", forecastList.get(1).getParkCode());
		assertEquals("Test getFiveDayForecast Code2", "TEST", forecastList.get(2).getParkCode());
		assertEquals("Test getFiveDayForecast Code3", "TEST", forecastList.get(3).getParkCode());
		assertEquals("Test getFiveDayForecast Code4", "TEST", forecastList.get(4).getParkCode());
	}

}
