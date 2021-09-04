package com.skilldistillery.filmquery.app;

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
    app.test();
    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    List <Actor> actors = db.findActorsByFilmId(1);
//    for (Actor actor : actors) {
//	}
    film.setActors(actors);
//  
   System.out.println(film);
//   
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	  int userChoice = 0;
	  System.out.println("******Have******Money?*******We*******Need*******It*******!*******");
	  System.out.println("*                                                                *");
	  System.out.println("*             Welcome to Blockbüster Online™:                    *");
	  System.out.println("*      Later to the online game than most of our returns!©       *");
	  System.out.println("*                                                                *");
	  System.out.println("*                  Please enter a menu option:                   *");
	  System.out.println("*                                                                *");
	  System.out.println("*              1:  Look up a film by its Film ID.                *");
	  System.out.println("*              2:  Look up a film by a search keyword.           *");
	  System.out.println("*              3:  Exit the Application.                         *");
	  System.out.println("*                                                                *");
	  System.out.println("***Seriously****though****can****we****have****your****money?*****");
  }

}
