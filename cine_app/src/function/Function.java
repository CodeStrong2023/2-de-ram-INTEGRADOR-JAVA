package function;

import movies.Movie;

import java.time.LocalTime;
import java.util.Date;

public class Function {

    // Atributos de la clase
    private int id; // Identificador único de la función
    private Movie movie; // Película asociada a la función
    private int room; // Número de la sala
    private LocalTime schedule; // Hora de inicio de la función
    private boolean isActive; // Indica si la función está activa
    private static int idCount; // Contador estático para asignar identificadores únicos

    //Constructor con parametros
    public Function(Movie movie, int room, int hours, int minutes) {
        this.movie = movie;
        this.room = room;
        this.schedule = LocalTime.of(hours, minutes);
        this.isActive = true;
        this.id = ++idCount;

    }

    //Constructor por defecto vacio
    public Function() {
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public LocalTime getSchedule() {
        return schedule;
    }

    public void setSchedule(int hour, int minutes) {
        this.schedule = LocalTime.of(hour, minutes);
    }
}
