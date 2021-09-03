package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private String user = "student";
	private String pass = "student";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println()
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
	    Connection conn = DriverManager.getConnection(URL, user, pass);
	    String sql = "SELECT id, title, description, release_year, language_id, rental_duration,"+
	    "rental_rate, length, replacement_cost, rating, special_features "
	    		+"FROM film WHERE id = ?";
	    PreparedStatement stmt = conn.prepareStatement(sql);
	    stmt.setInt(1, filmId);
	    ResultSet rs = stmt.executeQuery();
	    if(rs.next()) {
	    	film = new Film();
	    	film.setFilmId(rs.getInt(1));
	    	film.setTitle(rs.getString(2));
	    	film.setDescription(rs.getString("description"));
	    	film.setReleaseYear(rs.getInt("release_year"));
	    	film.setLanguageId(rs.getInt("language_id"));
	    	film.setRentalDuration(filmId);
	    }
		return film;
		
		rs.close();
	    stmt.close();
	    conn.close();
	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL, user, pass);
	    String sqltext;
	
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		  PreparedStatement stmt = conn.prepareStatement(sql);
		  stmt.setInt(1,actorId);
		  ResultSet actorResult = stmt.executeQuery();
		  if (actorResult.next()) {
		    actor = new Actor(actorResult.getInt(1), actorResult.getString(2), actorResult.getString(3)); 
		    actorResult.getId(actorResult."id")+ " " +
		    actorResult.getFirstName(actorResult."first_name")+ " " +
		    actorResult.getLastName(actorResult."last_name")+ " " +
		    actorResult.getFilms(findFilmsByActorId(actorId));
		return null;
		 actorResult.close();
		    stmt.close();
		    conn.close();
	}
		 
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		String user = "student";
	    String pass = "student";
	    Connection conn = DriverManager.getConnection(URL, user, pass);
	    String sqltext;
		return null;
		
		actorResult.close();
	    stmt.close();
	    conn.close();
	}

}
