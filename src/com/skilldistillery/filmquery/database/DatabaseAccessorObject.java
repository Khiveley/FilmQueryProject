package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
			System.err.println("Error loading database driver:");
			System.err.println(e);
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration,"
					+ "rental_rate, length, replacement_cost, rating, special_features " + " FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				film = new Film();
				film.setFilmId(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getInt("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Database error:");
		}
		return film;

	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name" + " FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet as = stmt.executeQuery();
			if (as.next()) {
				actor = new Actor();
				actor.setActorId(as.getInt("id"));
				actor.setFirstName(as.getString("first_name"));
				actor.setLastName(as.getString("last_name"));
			}
			as.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Database error:");
		}
		return actor;

	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<Actor>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name "
					+ "FROM actor JOIN film_actor ON actor.id = film_actor.actor_id " + "WHERE film_actor.film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet af = stmt.executeQuery();
			while (af.next()) {
				Actor actor = new Actor();
				actor.setActorId(af.getInt("id"));
				actor.setFirstName(af.getString("first_name"));
				actor.setLastName(af.getString("last_name"));
				actors.add(actor);
			}
			System.out.println(actors);
			af.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Database error:");
		}
		return actors;
	}

	@Override
	public List<Film> findFilmByKeyword(String k) {
		List<Film> films = new ArrayList<Film>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration,\"\n"
					+ "rental_rate, length, replacement_cost, rating, special_features FROM film WHERE (title LIKE ?) OR description LIKE ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "%" + k + "%");
			stmt.setString(2, "%" + k + "%");
			ResultSet kw = stmt.executeQuery();
			while (kw.next()) {
				int id = kw.getInt("id");
				Film film = findFilmById(id);
				films.add(film);
			}
			kw.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("Database error:");
		}
		return films;
	}

	@Override
	public String findFilmLanguage(int languageId) {
		String language = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT name from language WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1,languageId);
			ResultSet fl = ps.executeQuery();
			while (fl.next()) {
				language = fl.getString("name");
			}
			fl.close();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Database error.");
		}
		return language;

	}

}
