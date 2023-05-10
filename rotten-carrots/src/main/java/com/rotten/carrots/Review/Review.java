package com.rotten.carrots.Review;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.User.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "reviews")
public class Review {

    @Id
    private String reviewID;


    private String gameID;

    @DBRef
    private User author;

    private String content;
    private Integer carrotRate;
    private LocalDateTime dateTime;


    public Review(String gameID, User author, String content, Integer carrotRate, LocalDateTime dateTime){
        this.gameID = gameID;
        this.author = author;
        this.content = content;
        this.carrotRate = carrotRate;
        this.dateTime = dateTime;
    }

    // getters

    public String getReviewID() {
        return reviewID;
    }

    public String getGameID() {
        return gameID;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public Integer getCarrotRate() {
        return carrotRate;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // setters

    public void setReviewID(String reviewID) {
        this.reviewID = reviewID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCarrotRate(Integer carrotRate) {
        this.carrotRate = carrotRate;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}


