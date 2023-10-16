package function;

import movies.Movie;

import java.util.Date;

public class Function {
    private int id;
    private Movie movie;
    private int room;
    private Date schedule;
    private boolean isActive;
    private static int idCount;

    public Function(Movie movie, int room, Date schedule) {
        this.movie = movie;
        this.room = room;
        this.schedule = schedule;
        this.isActive = true;
        this.id = ++idCount;
    }

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

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }
}
