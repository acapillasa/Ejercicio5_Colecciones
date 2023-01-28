package Ej3;

import java.util.*;

public class Cinema {
    String cine;
    List<Movie> peliculas = new ArrayList<>();
    Movie[] busyRooms;

    Cinema(String nombreDelCine, int numeroDeSalas) {
        cine = nombreDelCine;
        busyRooms = new Movie[numeroDeSalas];
    }

    void roomOfMovie(String nombreDePelicula, int duracion, int año) {
        Movie peli = new Movie(nombreDePelicula,duracion,año);
        boolean hayPelicula = false;
        for (int i = 0; i < peliculas.size(); i++) {
            peliculas.get(i).isEqual(peli);
            hayPelicula = true;
        }

        if (hayPelicula) {
            for (int i = 0; i < busyRooms.length; i++) {
                if (busyRooms[i].isEqual(peli)) {
                    System.out.println("La pelicula "+peli.getTitulo()+" se proyecta en la sala "+i);
                }
            }
        } else {
            System.out.println("No se esta proyectando esa pelicula en ninguna sala.");
        }

        if (!hayPelicula) {
            System.out.println("Nunca hemos tenido esta pelicula disponible");
        }
    }

    void addMovie(Movie peli) {
        boolean existe = false;
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] != null) {
                if (busyRooms[i].isEqual(peli)) {
                System.out.println("La peli ya existia en el cine, no la agregamos.");
                existe = true;
                break;
                }
            }
        }

        peliculas.add(peli);

        if (!existe) {
            for (int i = 0; i < busyRooms.length; i++) {
                if (busyRooms[i] == null) {
                    busyRooms[i] = peli;
                    System.out.println(peli.getTitulo()+" insertada en la sala "+i);
                    break;
                }
                if (i == busyRooms.length-1 && busyRooms[busyRooms.length-1] != null) {
                    System.out.println("Todas las salas del cine estan ocupadas, no puedes insertar la pelicula.");
                }
            }
        }

    }

    void addMovie(Movie peli,int sala) {
        boolean existe = false;
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] != null) {
                if (busyRooms[i].isEqual(peli)) {
                    System.out.println("La peli ya existia en el cine, no la agregamos.");
                    existe = true;
                    break;
                }
            }
        }

        peliculas.add(peli);

        if (!existe) {
            if (busyRooms[sala] == null) {
                busyRooms[sala] = peli;
                System.out.println(peli.getTitulo()+" insertada en la sala "+sala);
            } else {
                System.out.println("Ya hay una pelicula en la sala "+sala);
            }
        }
    }

    void removeMovie(String peli) {
        int palabra;
        palabra = peli.length();
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i].getTitulo().length() >= palabra) {
                if (busyRooms[i].getTitulo().substring(0, palabra).equals(peli)) {
                    System.out.println("Pelicula "+busyRooms[i].getTitulo()+" eliminada de la sala "+i);
                    busyRooms[i] = null;
                }
            }
        }
    }

    List<Integer> freeRooms() {
        List<Integer> salasGratuitas = new ArrayList<>();
        salasGratuitas.add(0);
        salasGratuitas.add(1);
        return salasGratuitas;
    }

    void changeRoom(Movie peli) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < busyRooms.length; i++) {
            if (Objects.equals(busyRooms[i], peli)) {
                System.out.println("La pelicula se encuentra en la sala "+i);
                System.out.println("¿Quiere moverla? (true/false)");
                boolean mover = sc.nextBoolean();

                while (mover) {
                    System.out.println("¿A que otra sala quieres moverla?");
                    System.out.print("Sala: ");
                    int s = sc.nextInt();
                    if (s < busyRooms.length && busyRooms[s] == null) {
                        busyRooms[s] = peli;
                        busyRooms[i] = null;
                        System.out.println("Pelicula "+peli.getTitulo()+" movida a la sala "+s);
                        mover = false;
                    } else {
                        System.out.println("Esa habitacion no esta libre o no existe");
                        System.out.println();
                        System.out.println("¿Quiere seguir moviendo la pelicula? (true/false)");
                        mover = sc.nextBoolean();
                    }
                }
                System.out.println();
                break;
            }
        }
    }

    void resetCinema() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Seguro que quieres borrar todas las peliculas de todo el cine? (true/false)");
        boolean seguro = sc.nextBoolean();

        if (seguro) {
            System.out.println("Todas las peliculas del cine han sido eliminadas");
            Arrays.fill(busyRooms, null);
            peliculas.clear();
        }

        if (!seguro) {
            System.out.println("Nada ha sido borrado");
        }
    }

    List<String> moviesShorterThan(int minutosDeDuracion) {
        List<String> peliculasCortas = new ArrayList<>();
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getDuracion() < minutosDeDuracion) {
                peliculasCortas.add(peliculas.get(i).getTitulo());
            }
        }
        return peliculasCortas;
    }

    void visualizacion() {
        System.out.println("Cine "+cine);
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] != null) {
                System.out.println(busyRooms[i].getTitulo()+" - sala "+i);
            }
        }
    }
    void mostrar() {
        System.out.println("Cine "+cine);
        for (int i = 0; i < busyRooms.length; i++) {
            if (busyRooms[i] == null) {
                System.out.println("??????? - sala "+i);
            } else {
                System.out.println(busyRooms[i].getTitulo()+" - sala "+i);
            }
        }
    }
    void mostrarArrayListDePeliculas() {
        for (Movie pelicula : peliculas) {
            System.out.println(pelicula.getTitulo());
        }
    }
    void mostrarFreeRoooms() {
        for (Integer sala : freeRooms()) {
            System.out.println(sala);
        }
    }
    void mostrarMoviesShorterThan(List<String> listaDeTitulosDePeliculas) {
        for (String titulo : listaDeTitulosDePeliculas) {
            System.out.println(titulo);
        }
    }
}
