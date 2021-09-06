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
//    app.test();
		app.launch();
	}

//  private void test() {
//    Film film = db.findFilmById(1);
//    List <Actor> actors = db.findActorsByFilmId(1);
////    for (Actor actor : actors) {
////	}
//    film.setActors(actors);
////  
//   System.out.println(film);
////   
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
				System.out.println("Please enter an integer. Try again.");
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
				int filmId = input.nextInt();
				input.nextLine();
				Film film = db.findFilmById(filmId);
				if (film != null) {
					runFilmSubmenu(input, film, null);
				}
			} catch(InputMismatchException e){
			System.out.println("Please enter an integer 1-3. Try again.");
			  input.nextLine();
		}
		break;
		case 2:
			printFilmKeyword();
			String k = input.nextLine();
			List<Film> list = db.findFilmByKeyword(k);
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
	private void FilmSubmenu(){
		System.out.println("******************************************");
		System.out.println("*            What's next?                *");
		System.out.println("*      1. Main Menu                      *");
		System.out.println("*      2. Print Film Details             *");
		System.out.println("******************************************");	
	}
	
	private void printFilmKeyword(){
		System.out.println("***********************************************");
		System.out.println("*  What keyword would you like to search by?  *");
		System.out.println("*     Please provide your selection below.    *");
	}
	private void printFilmId(){
	System.out.println("******************************************");
	System.out.println("*          What is the film's id?        *");
	System.out.println("***Please provide your selection below.***");
	}
	
	private void printMainMenu(){			
	  System.out.println("********Have*******Money?********We*******Need********It!*********");
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
	  System.out.println("****Seriously****though****can****we****have****your****money?****");
	  
			}
}
