package com.rotten.carrots.User;

import com.rotten.carrots.Auctions.Auction;
import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Review.Review;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String userID;

    private String nickname;

    private List<Review> reviews = new ArrayList<>();

    private List<Auction> activeAuctions = new ArrayList<>();

    private List<Auction> finishedAuctions = new ArrayList<>();

    @DBRef
    private List<Game> favouriteGames = new ArrayList<>();


    public User(String nickname) {
        this.nickname = nickname;
    }

    public void addAuction(Auction auction){
        this.activeAuctions.add(auction);
    }

    public void addFavouriteGame(Game game){
        this.favouriteGames.add(game);
    }

    public void addReview(Review review){
        this.reviews.add(review);
    }
}

