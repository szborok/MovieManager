package org.example;

import java.util.Random;

public class Factory {

    public static Movie[] movieArrayGenerator(String input) {
        Movie[] moviesArray = new Movie[14];
        String[] movies = input.split("#");

        for (int i = 0; i < movies.length; i++) {

            String oneMovie = movies[i];
            //A nagy gatsby.The Great Gatsby.Hamis.0.143 perc

            //Visszakapott adatok fakkjai
            String hunTitle;
            String engTitle;
            Boolean isRated;
            Integer rating;
            Integer length;

            String[] movieDetails = oneMovie.split("\\.");
            //A nagy gatsby     The Great Gatsby        Hamis       0       143 perc
            //0                 1                       2           3       4

            //Adatok amik kellenek a classhoz
            hunTitle = movieDetails[0];
            engTitle = movieDetails[1];
            String title = hunTitle + " - " + engTitle;

            if (movieDetails[2].equals("Hamis")) {
                isRated = false;
                rating = 0;
            } else {
                isRated = true;
                rating = Integer.parseInt(movieDetails[3]);
            };

            String[] splittedLenght = movieDetails[4].split(" ");
            length = Integer.parseInt(splittedLenght[0]);

            moviesArray[i] = new Movie(title,isRated,rating,length);
        }
        return moviesArray;
    }


    public static Room[] roomArrayGenerator(String input) {
        String[] rooms = input.split("_");
        //1 120 Igaz
        Room[] roomsArray = new Room[rooms.length];

        //Visszakapott adatok fakkjai
        Integer roomNumber = null;
        Integer roomCapacity = null;
        Movie[] dailyMovieArray = null;
        Boolean status = null;

        for (int i = 0; i < rooms.length; i++) {
            String[] roomDetails = rooms[i].split(" ");
            //1     120     Igaz
            //0     1       2

            roomNumber = Integer.parseInt(roomDetails[0]);
            roomCapacity = Integer.parseInt(roomDetails[1]);
            if (roomDetails[2].equals("Igaz")) {
                status = true;
            } else {
                status = false;
            }

            dailyMovieArray = new Movie[8];

            roomsArray[i] = new Room(roomNumber,roomCapacity,dailyMovieArray,status);
        }
        return roomsArray;
    }
    
    
    public static void roomsMovieArrayGenerator(Movie[] movies, Room[] rooms) {
        Random rnd = new Random();


        for (int i = 0; i < rooms.length; i++) {
            if(rooms[i].getStatus()) {
                int randomMovieCount = rnd.nextInt(0, 8);
                Movie randomMovie = movies[rnd.nextInt(0,movies.length-1)];

                for (int j = 0; j < randomMovieCount; j++) {
                    rooms[i].addMovieToTheList(randomMovie);
                }
            }
        }
    }





}
