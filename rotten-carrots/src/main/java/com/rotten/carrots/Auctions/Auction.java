package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "auctions")
@Getter
@Setter
@NoArgsConstructor
public class Auction {

    @Id
    private String auctionID;

    @DBRef
    private Game game;

    private String ownerID;

    private String description;

    private double price;

    private LocalDateTime publicationDate;

    private boolean isActive;


    public Auction(Game game, String description, double price, String ownerID, LocalDateTime publicationDate){
        this.game = game;
        this.description = description;
        this.price = price;
        this.ownerID = ownerID;
        this.publicationDate = publicationDate;
    }
}
