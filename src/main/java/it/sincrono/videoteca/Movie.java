package it.sincrono.videoteca;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.List;

//classe Movie

@Document("movies")
public class Movie {

    @Id
    private ObjectId id;
    private List<Actor> actors;
    private String description;
    private int duration;
    private String genre;
    private String[] languages;
    private double price;
    private int publishYear;
    private String[] subtitles;
    private String title;


    //costruttore vuoto

    public Movie() {

    }

    //costruttore che inizializza tutti gli attributi tranne l'id

    public Movie(List<Actor> actors, String description, int duration,
                 String genre, String[] languages, double price, int publishYear,
                 String[] subtitles, String title) {

        this.actors = actors;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.languages = languages;
        this.price = price;
        this.publishYear = publishYear;
        this.subtitles = subtitles;
        this.title = title;
    }


    //costruttore che inizializza tutti gli attributi

    public Movie(ObjectId id, List<Actor> actors, String description, int duration,
                 String genre, String[] languages, double price,
                 int publishYear, String[] subtitles, String title) {

        this.id = id;
        this.actors = actors;
        this.description = description;
        this.duration = duration;
        this.genre = genre;
        this.languages = languages;
        this.price = price;
        this.publishYear = publishYear;
        this.subtitles = subtitles;
        this.title = title;

    }

    public ObjectId getId() {
        return id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() { return duration; }

    public String getGenre() {
        return genre;
    }

    public String[] getLanguages() {
        return languages;
    }

    public double getPrice() {
        return price;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String[] getSubtitles() {
        return subtitles;
    }

    public String getTitle() {
        return title;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(int duration) { this.duration = duration; }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setSubtitles(String[] subtitles) {
        this.subtitles = subtitles;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", actorList=" + actors +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", languages=" + Arrays.toString(languages) +
                ", price=" + price +
                ", publishYear=" + publishYear +
                ", subtitles=" + Arrays.toString(subtitles) +
                ", title='" + title + '\'' +
                '}';
    }
}
