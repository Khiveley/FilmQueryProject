package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//		app.test();
		app.launch();
	}

//  private void test() {
//    Film film = db.findFilmById(1);
//    List <Actor> actors = db.findActorsByFilmId(1);
//    for (Actor actor : actors) {
//	}
//    film.setActors(actors);
//  
//   System.out.println(film);
//   
//  }

	private void launch() {
		Scanner input = new Scanner(System.in);
		
		startUserInterface(input);
		input.close();
	}

	private void startUserInterface(Scanner input) {
		boolean keepRunning = true;
		int userChoice = 0;
		do {
			printMainMenu();
			try {
				userChoice = input.nextInt();
				input.nextLine();
				keepRunning = userSelection(userChoice, input);
			} catch (InputMismatchException e) {
				System.err.println("Please enter an integer. Try again.");
				input.nextLine();
			}
		} while (keepRunning);
	}

	private boolean userSelection(int userChoice, Scanner input) {
		boolean keepRunning = true;
		switch (userChoice) {
		case 1:
			printFilmId();
			try {
//				System.out.println("What is the film's id?");
				int id = input.nextInt();
				Film film = db.findFilmById(id);
				if (film != null) {
					runFilmSubmenu(input, film, null);
				}
			} catch (InputMismatchException e) {
				System.out.println("Please enter an integer 1-3. Try again.");
				input.nextLine();
			}
			break;
		case 2:
			printFilmKeyword();
			String keyword = input.nextLine();
			List<Film> list = db.findFilmByKeyword(keyword);
			if (list != null) {
				runFilmSubmenu(input, null, list);
			}
			break;
		case 3:
			keepRunning = false;
			System.out.println("We're sorry to see you go. \nVisit our 1 remaining store in Bend, Oregon.  Goodbye.");
			break;
		default:
			System.out.println("Please make your selection: 1-3:");
		}
		return keepRunning;
	}

	private void runFilmSubmenu(Scanner input, Film film, List<Film> list) {
		printSubmenu();
		try {
			int choice = input.nextInt();
			input.nextLine();
			subMenuChoices(choice, film, list);
		} catch (InputMismatchException e) {
			System.out.println("Please reenter an integer.");
			input.nextLine();
		}
	}
		
	private void subMenuChoices(int choice, Film filmId, List<Film> list) {
		switch(choice) {
		case 1:
			System.out.println("Returning to main menu.");
			break;
		case 2:
			if (list == null) {
				System.out.println(filmId.toString());
			}
			else {
				for (Film film : list) {
					System.out.println(film.toString());
				}
			}
			break;
		default:
			System.out.println("Not sure what you're looking for pal...returning to main menu.");
		}
		
	}

	private void printSubmenu() {
		System.out.println("******************************************");
		System.out.println("*            What's next?                *");
		System.out.println("*      1. Main Menu                      *");
		System.out.println("*      2. Print Film Details             *");
		System.out.println("******************************************");
	}

	private void printFilmKeyword() {
		System.out.println("***********************************************");
		System.out.println("*  What keyword would you like to search by?  *");
		System.out.println("*     Please provide your selection below.    *");
		System.out.println("*     										  *");
		System.out.println("***********************************************");
	}

	private void printFilmId() {
		System.out.println("******************************************");
		System.out.println("*          What is the film's id?        *");
		System.out.println("***Please provide your selection below.***");
	}

	private void printMainMenu() {
		System.out.println("******************************************************************");
		System.out.println("*                                                                *");
		System.out.println("*             Welcome to Blockbüster Online™:                    *");
		System.out.println("*      Later to online sales than most of our late returns!©     *");
		System.out.println("*                                                                *");
		System.out.println("*                  Please enter a menu option:                   *");
		System.out.println("*                                                                *");
		System.out.println("*              1:  Look up a film by its Film ID.                *");
		System.out.println("*              2:  Look up a film by a search keyword.           *");
		System.out.println("*              3:  Exit the Application.                         *");
		System.out.println("*                                                                *");
		System.out.println("******************************************************************");

	}
}
