package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getForecastByCode(String parkCode) {
		List<Weather> forecastList = new ArrayList<>();
		String sqlSelectForecast = "SELECT * FROM weather WHERE parkCode = ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectForecast, parkCode);
		while(results.next()) {
			forecastList.add(mapRowToForecast(results));
		}
		return forecastList;
	}
	
	private Weather mapRowToForecast(SqlRowSet row) {
		Weather forecast = new Weather();
		forecast.setParkCode(row.getString("parkcode"));
		forecast.setDayValue(row.getInt("fivedayforecastvalue"));
		forecast.setLow(row.getInt("low"));
		forecast.setHigh(row.getInt("high"));
		forecast.setForecast(row.getString("forecast"));
		return forecast;
	}

}
