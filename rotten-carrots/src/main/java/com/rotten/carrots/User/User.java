package com.rotten.carrots.User;

import com.rotten.carrots.Auctions.Auction;
import com.rotten.carrots.Game.Game;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "users")
@Getter
@Setter
public class User {

    @Id
    private String userID;

    @Indexed(unique=true)
    private String nickname;

    private List<Auction> auctions = new ArrayList<>();

    private List<Game> favouriteGames = new ArrayList<>();


    public User(String nickname) {
        this.nickname = nickname;
    }

    public void addAuction(Auction auction){
        this.auctions.add(auction);
    }

    public void addFavouriteGame(Game game){
        this.favouriteGames.add(game);
    }
}

