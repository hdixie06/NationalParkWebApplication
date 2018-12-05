package com.techelevator;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.npgeek.model.park.JDBCParkDAO;
import com.techelevator.npgeek.model.park.Park;
import com.techelevator.npgeek.model.park.ParkDAO;

public class ParkDAOTest extends DAOIntegrationTest {

	@Test
	public void testGetAllParks() {
		// Instantiate a ParkDAO and give it the test DataSource
		ParkDAO parkDao = new JDBCParkDAO(getDataSource());

		// Create initial list for reference
		List<Park> parkList = parkDao.getAllParks();

		// Create a fake park for testing purposes
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, "
				+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES ('TEST', 'Test Park', 'Ohio', 99999, 6600, 123.4, 5, 'City', 2018, 27, "
				+ "'When the going gets tough, the tough take a nap.', 'Al Nachman', "
				+ "'This is a test site for testing', 14000, 1);";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertPark);

		// Run the method and test
		assertEquals("Test getAllParks", parkList.size() + 1, parkDao.getAllParks().size());
	}

	@Test
	public void getParkByCodeTestName() {
		// Instantiate a ParkDAO and give it the test DataSource
		ParkDAO parkDao = new JDBCParkDAO(getDataSource());

		// Create a fake park for testing purposes
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, "
				+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES ('TEST', 'Test Park', 'Ohio', 99999, 6600, 123.4, 5, 'City', 2018, 27, "
				+ "'When the going gets tough, the tough take a nap.', 'Al Nachman', "
				+ "'This is a test site for testing', 14000, 1);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertPark);
		
		//Run the method and test
		assertEquals("test getParkByCode getName", "Test Park", parkDao.getParkByCode("TEST").getParkName());
	}
	
	@Test
	public void getParkByCodeTestState() {
		// Instantiate a ParkDAO and give it the test DataSource
		ParkDAO parkDao = new JDBCParkDAO(getDataSource());

		// Create a fake park for testing purposes
		String sqlInsertPark = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, "
				+ "milesoftrail, numberofcampsites, climate, yearfounded, annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) "
				+ "VALUES ('TEST', 'Test Park', 'Ohio', 99999, 6600, 123.4, 5, 'City', 2018, 27, "
				+ "'When the going gets tough, the tough take a nap.', 'Al Nachman', "
				+ "'This is a test site for testing', 14000, 1);";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertPark);
		
		//Run the method and test
		assertEquals("test getParkByCode getState", "Ohio", parkDao.getParkByCode("TEST").getState());
	}
	
	@Test
	public void testGetFavoriteParks() {
		// Instantiate a ParkDAO and give it the test DataSource
		ParkDAO parkDao = new JDBCParkDAO(getDataSource());
		
		List<Park> favepark = parkDao.getFavoriteParks();
	}

}
