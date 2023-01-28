package Ej3;

import java.util.Objects;

public class Movie {
    private String titulo;
    private int duracion;
    private int año;

    Movie(String titulo,int duracion, int año) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.año = año;
    }

    boolean isEqual(Movie pelicula) {
        if (Objects.equals(pelicula.titulo, titulo) && pelicula.duracion > duracion-5 && pelicula.duracion < duracion+5 && pelicula.año == año) {
            return true;
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", año=" + año +
                '}';
    }
}
