package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "auctions")
@Getter
@Setter
public class Auction {

    @Id
    private String auctionID;

    private Game game;

    private String description;

    private Float price;

    private String ownerID;

    private LocalDateTime publicationDate;


    public Auction(Game game, String description, Float price, String ownerID, LocalDateTime date){
        this.game = game;
        this.description = description;
        this.price = price;
        this.ownerID = ownerID;
        this.publicationDate = date;
    }
}
