package com.rotten.carrots.Review;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Document(collection = "reviews")
@Getter
@Setter
public class Review {

    @Id
    private String reviewID;

    private String gameID;

    private String author;

    private String content;

    private Integer carrotRate;

    private LocalDateTime publicationDate;


    public Review(String gameID, String author, String content, Integer carrotRate, LocalDateTime publicationDate){
        this.gameID = gameID;
        this.author = author;
        this.content = content;
        this.carrotRate = carrotRate;
        this.publicationDate = publicationDate;
    }
}


