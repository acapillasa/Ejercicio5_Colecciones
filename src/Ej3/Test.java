package Ej3;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Cinema cine = new Cinema("Niessen",5);
        Movie peli1 = new Movie("Forrest Gump",120,2003);
        Movie peli2 = new Movie("Cars",150,2007);
        Movie peli3 = new Movie("Shrek",160,2005);
        Movie peli4 = new Movie("Harry Potter",170,2003);
        Movie peli5 = new Movie("Los tres mosqueteros",90,1997);

        System.out.println("PELICULAS AÑADIDAS");
        cine.addMovie(peli1);
        cine.addMovie(peli2,1);
        cine.addMovie(peli3);
        cine.addMovie(peli4,3);
        cine.addMovie(peli5);

        System.out.println();

        System.out.println("EL ARRAYLIST");
        cine.mostrarArrayListDePeliculas();

        System.out.println();

        System.out.println("ENCONTRAR PELICULA");
        cine.roomOfMovie("Cars",147,2007);

        System.out.println();

        System.out.println("QUITAR PELICULA DE UNA SALA");
        cine.removeMovie("Harry");
        cine.mostrar();

        System.out.println();

        System.out.println("SALAS GRATUITAS");
        cine.freeRooms();
        cine.mostrarFreeRoooms();

        System.out.println();

        System.out.println("CAMBIAR PELICULA DE UNA SALA A OTRA");
        cine.changeRoom(peli2);
        cine.mostrar();

        System.out.println();

        System.out.println("MOSTRAR LOS TITULOS DE LAS PELICULAS CON UNA DURACION MENOR QUE LA QUE ESPECIFICAMOS");
        cine.mostrarMoviesShorterThan(cine.moviesShorterThan(100));

        System.out.println();

        System.out.println("¡¡BORRAR TODAS LA PELICULAS DEL CINE!!");
        cine.resetCinema();
        cine.visualizacion();

        System.out.println();

    }
}
