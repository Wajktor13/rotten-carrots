package com.rotten.carrots.Game;

import com.rotten.carrots.Review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Document(collection = "games")
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    private String gameID;
    private List<Review> reviews = new ArrayList<>();
    private String title;
    private String genre;
    private String description;
    private String developer;
    private LocalDateTime releaseDate;
    private double msrp;
    private double carrotRate = -1;


    public Game(String title, String genre, String description, LocalDateTime releaseDate, String developer,
                double msrp) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.msrp = msrp;
    }
}

