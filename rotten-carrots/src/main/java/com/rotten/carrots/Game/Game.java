package com.rotten.carrots.Game;

import com.rotten.carrots.Review.Review;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "games")
public class Game {

    @Id
    private String gameID;

    @DBRef
    private List<Review> reviews = new ArrayList<>();

    private String title;
    private String genre;
    private String description;
    private String developer;
    private LocalDateTime releaseDate;
    private Integer msrp;


    public Game(String title, String genre, String description, LocalDateTime releaseDate, String developer,
                Integer msrp) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.developer = developer;
        this.releaseDate =releaseDate;
        this.msrp = msrp;
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }

    // getters

    public String getGameID() {
        return gameID;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public String getDeveloper() {
        return developer;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public Integer getMsrp() {
        return msrp;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // setters

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMsrp(Integer msrp) {
        this.msrp = msrp;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}

