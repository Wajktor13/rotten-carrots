package com.rotten.carrots.User;

import com.rotten.carrots.Auctions.Auction;
import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Review.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    private String userID;

    private String nickname;

    private List<Review> reviews = new ArrayList<>();

    @DBRef
    private List<Auction> auctions = new ArrayList<>();

    private List<String> favouriteGames = new ArrayList<>();

    private List<Auction> boughtGames = new ArrayList<>();

    public User(String nickname) {
        this.nickname = nickname;
    }

    public void addAuction(Auction auction){
        this.auctions.add(auction);
    }

    public void addBought(Auction auction) { this.bought.add(auction); }

    public void addFavouriteGame(String game){
        this.favouriteGames.add(game);
    }
}

