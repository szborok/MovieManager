package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {

    public static Integer leastScreeningRoom(Room[] input){
        int roomIndex               = -1;
        int smallestNumberOfMovies   = 99;

        for (int i = 0; i <input.length; i++) {
            int currentSmallestNumberOfMovies = input[i].numberOfMovies();

            if (currentSmallestNumberOfMovies < smallestNumberOfMovies) {
                roomIndex = i;
                smallestNumberOfMovies = currentSmallestNumberOfMovies;
            }
        }
        return input[roomIndex].getRoomNumber();
    }

    public static List<Integer> roomsWithMoreThanThreeMovies(Room[] input) {
        List<Integer> returnList    = new ArrayList<>();

        for (int i = 0; i <input.length; i++) {
            int currentHighestNumberOfMovies = input[i].numberOfMovies();

            if (currentHighestNumberOfMovies > 3) {
                returnList.add(input[i].getRoomNumber());
            }
        }
        return returnList;
    }

    public static void closedRooms(Room[] input) {
        List<Integer> closedRoomsIndexes = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            if (input[i].getStatus().equals(false)) {
                closedRoomsIndexes.add(i);
            }
        }

        for (int i = 0; i < closedRoomsIndexes.size(); i++) {
            int indexNumber = closedRoomsIndexes.get(i);
            System.out.println(
                    input[indexNumber].getRoomNumber() + " - " + input[indexNumber].getRoomCapacity()
            );
        }
    }

    public static void roomDetails(Room[] input) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a room number between 1-14 for it's details: ");
        String userInput = scanner.nextLine(); // Read a line of text
        //scanner.close();

        Integer roomNumber = Integer.parseInt(userInput);

        Room chosenRoom = null;
        for (int i = 0; i < input.length; i++) {
            if (input[i].getRoomNumber().equals(roomNumber)) {
                chosenRoom = input[i];
            }
        }

        System.out.println("Room number: " + chosenRoom.getRoomNumber());
        System.out.println("Room capacity: " + chosenRoom.getRoomCapacity());
        System.out.print("Movies: ");
        for (int i = 0; i < chosenRoom.getDailyMovieArray().length; i++) {
            if (chosenRoom.getDailyMovieArray()[i] != null) {
                System.out.print(chosenRoom.getDailyMovieArray()[i].getTitle());
                if (i != chosenRoom.getDailyMovieArray().length) {
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
        System.out.println("Status: " + chosenRoom.getStatus());
    }

    public static Room biggestRoomOpen(Room[] rooms) {
        int maxIdx = 0;
        int maxCapacity = 0;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].getStatus()) {
                if (rooms[i].getRoomCapacity() > maxCapacity) {
                    maxIdx = i;
                    maxCapacity = rooms[i].getRoomCapacity();
                }
            }
        }
        return rooms[maxIdx];
    }

    public static void swapMovie(Room[]roomArray, Movie oldMovie, Movie newMovie) {
        for (int i = 0; i < roomArray.length; i++) {
            if (roomArray[i].getStatus()) {
                Movie[] actualRoomsMovieList = roomArray[i].getDailyMovieArray();

                for (int j = 0; j < actualRoomsMovieList.length; j++) {
                    if (actualRoomsMovieList[j] != null) {
                        if (actualRoomsMovieList[j].getTitle().equals(oldMovie.getTitle())) {
                            actualRoomsMovieList[j] = newMovie;
                        }
                    }
                }
            }
        }
    }


//    Készítsen metódust mely megállapítja, hogy a zárt termek közül melyik a
//    három legnagyobb. Amennyiben egy terem 100 fő feletti kapacitással
//    rendelkezik, akkor arra 30% esély van, hogy megnyissák. Amennyiben 130 fő
//    feletti, akkor még 50%, 100-nál kisebb termekre 20%, adjon vissza egy terem
//    számot, melyiket nyissák meg.

    private static Room biggestRoomClosed(Room[] rooms) {
        int maxIdx = 0;
        int maxCapacity = 0;

        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] != null && !rooms[i].getStatus()){
                if (rooms[i].getRoomCapacity() > maxCapacity) {
                    maxIdx = i;
                    maxCapacity = rooms[i].getRoomCapacity();
                }
            }
        }
        return rooms[maxIdx];
    }

    public static Room[] biggestThreeRoomClosed(Room[] rooms) {
        Room[] copyOfRooms = rooms.clone();
        Room[] returnList = new Room[3];

        for (int i = 0; i < returnList.length; i++) {
            Room currentBiggest = biggestRoomClosed(copyOfRooms);
            returnList[i] = currentBiggest;

            for (int j = 0; j < copyOfRooms.length; j++) {
                if (copyOfRooms[j] != null) {
                    if (currentBiggest.getRoomNumber().equals(copyOfRooms[j].getRoomNumber())) {
                        copyOfRooms[j] = null;
                    }
                }
            }
        }
        return returnList;
    }

    public static Room luckiestRoomToOpen(Room[] closedRooms) {
        List<Room> luckyList = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < closedRooms.length; i++) {
            int howLucky = 0;

            if (closedRooms[i].getRoomCapacity() < 100) {
                howLucky = 20;
            }
            if (closedRooms[i].getRoomCapacity() <= 100) {
                howLucky = 30;
            }
            if (closedRooms[i].getRoomCapacity() <= 130) {
                howLucky = howLucky + 30;
            }
            for (int j = 0; j < howLucky; j++) {
                luckyList.add(closedRooms[i]);
            }
        }
        int returnRoomIndex = rnd.nextInt(0,luckyList.size());
        return luckyList.get(returnRoomIndex);
    }

    public static void fillTheOpeningRoomWithMovies(Room luckyRoom, Movie[] movies) {
        int numberOfMoviesToAdd = 4;
        Random rnd = new Random();

        for (int i = 0; i < numberOfMoviesToAdd; i++) {
            Movie randomMovie = movies[rnd.nextInt(0,movies.length-1)];
            luckyRoom.addMovieToTheList(randomMovie);
        }
    }





}
