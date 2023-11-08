package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {

    public static Integer leastScreeningRoom(Room[] input){
        int roomIndex               = -1;
        int highestNumberOfMovies   = -1;

        for (int i = 0; i <input.length; i++) {
            int currentHighestNumberOfMovies = input[i].numberOfMovies();

            if (currentHighestNumberOfMovies > highestNumberOfMovies) {
                roomIndex = i;
                highestNumberOfMovies = currentHighestNumberOfMovies;
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
        scanner.close();

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



}
