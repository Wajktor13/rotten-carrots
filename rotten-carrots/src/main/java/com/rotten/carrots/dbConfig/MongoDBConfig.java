package com.rotten.carrots.dbConfig;

import com.rotten.carrots.Auctions.Auction;
import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Game.GameRepository;
import com.rotten.carrots.Auctions.AuctionRepository;
import com.rotten.carrots.News.News;
import com.rotten.carrots.News.NewsRepository;
import com.rotten.carrots.Review.Review;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.rotten.carrots.User.User;
import com.rotten.carrots.User.UserRepository;

import java.time.LocalDateTime;


@Configuration
public class MongoDBConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(GameRepository gameRepository, ReviewRepository reviewRepository,
                                        UserRepository userRepository, AuctionRepository auctionRepository,
                                        NewsRepository newsRepository) {
        return strings -> {
//            User newUser1 = new User("Dolores15");
//            User newUser2 = new User("Mike1999");
//
//            userRepository.save(newUser1);
//            userRepository.save(newUser2);
//
//            Game newGame = new Game("Far Cry Primal", "Action-Adventure", "Far Cry Primal is a 2016 action-adventure" +
//                    " game developed by Ubisoft Montreal and published by Ubisoft. It is a spin-off to Far Cry 4",
//                    LocalDateTime.now(), "Ubisoft", 50);
//
//            gameRepository.save(newGame);
//
//            Review newReview1 = new Review(newGame.getGameID(), newUser1.getNickname(), "nice game", 88,
//                    LocalDateTime.now());
//            Review newReview2 = new Review(newGame.getGameID(), newUser2.getNickname(), "not as good as I expected", 40,
//                    LocalDateTime.now());
//
//            newUser1.addReview(newReview1);
//            newUser2.addReview(newReview2);
//
//            reviewRepository.save(newReview1);
//            reviewRepository.save(newReview2);
//
//            newUser1.addFavouriteGame(newGame);
//
//            Auction newAuction = new Auction(newGame, "like new", 29.99, newUser2.getUserID(),
//                    LocalDateTime.now());
//
//            auctionRepository.save(newAuction);
//
//            newUser2.addAuction(newAuction);
//
//            News newNews = new News("JohnTheAdmin", "Upcoming games releases for June", "New month, new games...",
//                    LocalDateTime.now());
//
//            userRepository.save(newUser1);
//            userRepository.save(newUser2);
//            reviewRepository.save(newReview1);
//            reviewRepository.save(newReview2);
//            gameRepository.save(newGame);
//            auctionRepository.save(newAuction);
//            newsRepository.save(newNews);
        };
    }

}