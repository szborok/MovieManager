package org.example;

public class Room {

    private Integer roomNumber;
    private Integer roomCapacity;
    private Movie[] dailyMovieArray;
    private Boolean status;

    public Room(Integer roomNumber, Integer roomCapacity, Movie[] dailyMovieArray, Boolean status) {
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.dailyMovieArray = dailyMovieArray;
        this.status = status;
    }


    //Getter

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public Movie[] getDailyMovieArray() {
        return dailyMovieArray;
    }

    public Boolean getStatus() {
        return status;
    }


    //Methods

    public void addMovieToTheList(Movie newMovie) {
        int idx = -1;

        for (int i = 0; i < this.dailyMovieArray.length; i++) {
            if (this.dailyMovieArray[i] == null && idx == -1) {
                //BREAK helyettesitese miatt van a "&& idx == -1"
                idx = i;
                this.dailyMovieArray[idx] = newMovie;
            }
        }
    }

    public Integer numberOfMovies(){
        int currentHighestNumberOfMovies = 0;

        for (int i = 0; i < this.dailyMovieArray.length; i++) {
            if (this.dailyMovieArray[i] != null) {
                currentHighestNumberOfMovies++;
            }
        }
        return currentHighestNumberOfMovies;
    }

}
