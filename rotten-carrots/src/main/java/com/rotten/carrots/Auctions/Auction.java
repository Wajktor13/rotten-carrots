package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.User.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "auctions")
@Getter
@Setter
public class Auction {

    @Id
    private String auctionID;

    @DBRef
    private Game game;

    @DBRef
    private User owner;

    private String description;

    private double price;

    private LocalDateTime publicationDate;


    public Auction(Game game, String description, double price, User owner, LocalDateTime publicationDate){
        this.game = game;
        this.description = description;
        this.price = price;
        this.owner = owner;
        this.publicationDate = publicationDate;
    }
}
