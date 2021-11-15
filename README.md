# FilmQueryProject

# Description

This application utilizes the Java Data Base Connectivity API (known as JDBC) to connect to MySQL where we have a pseudo-film directory stored. 
A user is presented with a menu and able to search by the movie's id or a keyword in a title or description.  Various get methods are utilized to display information about the film that a user selects.  The user is also prompted if s/he would like more information about the film or to return to the main menu.

# Technologies Used

SQL
Maven
ORM

# How to Run

Run FilmQueryApp.java.

# Lessons Learned

I chased a database error that impacted not returning information about my films.  The cause was that I had a syntax error that resulted from spacing in my query.  I also was receiving null for my list of actors on each film regardless of methodology.  This was the most maddening aspect. I was able to locate my issues by using debug and adding in a for loop in each of my methods. I will make use of debug to better examine my code in the future. This has been an incredible challenge.  I'm glad to have completed it, even if due to circumstances it was at the 11th hour.
