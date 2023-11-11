package org.example;

public class Main {
    public static void main(String[] args) {
        String moviesSource = "A nagy gatsby.The Great Gatsby.Hamis.0.143 perc#A Gyűrűk Ura: A gyűrű szövetsége.The Lord of the Rings: The Fellowship of the Ring.Hamis.0.178 perc#Csillagok háborúja: Az ébredő Erő.Star Wars: The Force Awakens.Hamis.0.138 perc#Harry Potter és a bölcsek köve.Harry Potter and the Sorcerer's Stone.Hamis.0.152 perc#A sötét lovag.The Dark Knight.Hamis.0.152 perc#Avatar.Avatar.Hamis.0.162 perc#Egy makulátlan elme örök ragyogása.Eternal Sunshine of the Spotless Mind.Hamis.0.108 perc#Zöld könyv.Green Book.Igaz.12.130 perc#A diktátor.The Dictator.Igaz.16.83 perc#Mátrix.The Matrix.Igaz.16.136 perc#A hihetetlen Hulk.The Incredible Hulk.Igaz.12.112 perc#Forrest Gump.Forrest Gump.Igaz.12.142 perc#Bosszúállók: Végjáték.Avengers: Endgame.Igaz.12.181 perc#Star Wars: Az utolsó jedi.Star Wars: The Last Jedi.Igaz.12.152 perc#";
        String roomsSource = "1 120 Igaz_2 95 Hamis_3 140 Igaz_4 110 Hamis_5 160 Igaz_6 80 Hamis_7 130 Igaz_8 150 Igaz_9 100 Hamis_10 170 Igaz";

        Movie[] movies = Factory.movieArrayGenerator(moviesSource);
        Room[] cinemacityCsepel = Factory.roomArrayGenerator(roomsSource);

        Factory.roomsMovieArrayGenerator(movies,cinemacityCsepel);

        //------------------










    }
}