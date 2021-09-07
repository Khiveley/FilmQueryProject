package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {

	private int filmId;
	private String title;
	private String description;
	private int releaseYear;
	private int languageId;
	private int rentalDuration;
	private double rentalRate;
	private int length;
	private double replacementCost;
	private String rating;
	private String language;
	private String specialFeatures;
	private List<Actor> actors;

	public Film() {
		super();
	}

	public Film(int filmId, String title, String description, int releaseYear, int languageId, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		super();
		this.filmId = filmId;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.setLanguage(language);
		this.specialFeatures = specialFeatures;

	}

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String showFilmInformation() {
		String information = "Title: " + title + "Release Year: " + releaseYear + "Rating: " + rating + "Description: "
				+ description;
		return information;
	}

	public String fullInformation() {
		String full = "Title:" + title + "Release Year: " + releaseYear + "Rating: " + rating + "Length: " + length
				+ "mins" + "Rental Duration: " + rentalDuration + "days" + "Rental Rate: " + rentalRate
				+ "Description: " + description;
		return full;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, filmId, languageId, length, rating, releaseYear, rentalDuration, rentalRate,
				replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(description, other.description) && filmId == other.filmId
				&& languageId == other.languageId && length == other.length && Objects.equals(rating, other.rating)
				&& releaseYear == other.releaseYear && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
//		if (actors.size() == 0) {
//			return "Film id: " + filmId + " " + "Title: " + title + "\n" + "Description: " + description + "\n" + "\n"
//					+ "Release Year: " + releaseYear + " " + "Language Id: " + languageId + " " + "Rental Duration: "
//					+ rentalDuration + " " + "Rental Rate: " + rentalRate + "\n" + "Length: " + length + " mins "
//					+ "Replacement Cost: " + replacementCost + " " + "Rating: " + rating + " " + "Special Features: "
//					+ specialFeatures + "\n" + "\n" + "All rates and costs listed in USD. Be Kind. Please Rewind.";
//		} else {
			StringBuilder sb = new StringBuilder("Film [id=").append(filmId).append(", title=").append(title)
					.append(", description=").append(description).append(", releaseYear=").append(releaseYear)
					.append(", languageId=").append(languageId).append(", rentalDuration=").append(rentalDuration)
					.append(", rentalRate=").append(rentalRate).append(", specialFeatures=").append(specialFeatures)
					.append(", language=").append(language).append(", actors=");
			for (Actor actor : actors) {
				sb.append(actor.getActorFullName() + ", ");
			}
			sb.delete(sb.length() - 2, sb.length());
			sb.append("]");
			return sb.toString();
		}
	

	public void setName(String string) {
		// TODO Auto-generated method stub

	}

}
