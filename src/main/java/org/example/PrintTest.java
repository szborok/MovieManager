package org.example;

public class PrintTest {



    public static void roomWithLeastMovies(Room[] rooms) {
        System.out.println("Room with the least number of movies. (Random results)");
        System.out.println("Room number: " +
                Logic.leastScreeningRoom(rooms));
        System.out.println("---");
    }

    public static void roomsWithMoreThan3Movies(Room[] rooms) {
        System.out.println("Room(s) with more than 3 movies. (Random results)");
        for (int i = 0; i < Logic.roomsWithMoreThanThreeMovies(rooms).size(); i++) {
            System.out.println("Room number: " +
                    Logic.roomsWithMoreThanThreeMovies(rooms).get(i));
        }
        System.out.println("---");
    }

    public static void closedRoomsWithCapacity(Room[] rooms) {
        System.out.println("Closed rooms with their capacity. (Constant results)");
        Logic.closedRooms(rooms);
        System.out.println("---");
    }

    public static void choosenRoomDetails(Room[] rooms) {
        System.out.println("Room with details. (Chosen result)");
        Logic.roomDetails(rooms);
        System.out.println("---");
    }

    public static void availableRoomWithBiggestCapacity(Room[] rooms) {
        System.out.println("Available room's number with the biggest capacity.");
        System.out.println(Logic.biggestRoomOpen(rooms).getRoomNumber());
        System.out.println("---");
    }

    public static void swapMovies(Room[] rooms, Movie[] movies) {
        Logic.swapMovie(rooms, movies[0], movies[1]);

        System.out.println("Room with details. (Chosen result)");
        Logic.roomDetails(rooms);
        System.out.println("---");

        Room[] teft = Logic.biggestThreeRoomClosed(rooms);
        for (int i = 0; i < teft.length; i++) {
            System.out.println(teft[i].getRoomNumber().toString());
        }
    }

    public static void luckiestRoomToOpen(Room[] input) {
        Room[] closedRoomsThreeBiggestRoom = Logic.biggestThreeRoomClosed(input);
        Room luckiesRoom = Logic.luckiestRoomToOpen(closedRoomsThreeBiggestRoom);

        System.out.println("Luckiest room to open. (Random result)");
        System.out.println(luckiesRoom.getRoomNumber());
        System.out.println("---");
    }

    public static void fillTheLuckiestOpeningRoomWithMovies(Room[] rooms, Movie[] movies) {
        Room[] closedRooms = Logic.biggestThreeRoomClosed(rooms);
        Room victim = Logic.luckiestRoomToOpen(closedRooms);
        Logic.fillTheOpeningRoomWithMovies(victim, movies);

        System.out.println("Room number " + victim.getRoomNumber() + " is filled up with the following movies.");
        for (int i = 0; i < victim.getDailyMovieArray().length; i++) {
            if (victim.getDailyMovieArray()[i] != null) {
                System.out.println(victim.getDailyMovieArray()[i].getTitle());
            }
        }
        System.out.println("---");

    }

}
