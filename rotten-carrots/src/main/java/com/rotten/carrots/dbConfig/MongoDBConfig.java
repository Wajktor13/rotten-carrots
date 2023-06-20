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
import java.util.ArrayList;
import java.util.List;


@Configuration
public class MongoDBConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(GameRepository gameRepository, ReviewRepository reviewRepository,
                                        UserRepository userRepository, AuctionRepository auctionRepository,
                                        NewsRepository newsRepository) {
        return strings -> {
            List<Auction> allAuctions = auctionRepository.findAll();
            List<User> allUsers = userRepository.findAll();

            for (User user: allUsers){
                List<Auction> auctionsToAdd = new ArrayList<>();

                for (Auction auction: allAuctions) {
                    if(auction.getOwnerID().equals(user.getUserID())){
                        auctionsToAdd.add(auction);
                    }
                }

                user.setAuctions(auctionsToAdd);
                userRepository.save(user);
            }
        };
    }

}

//        return strings -> {
//                Random random = new Random();
//                List<User> allUsers = userRepository.findAll();
//        List<Auction> allAuctions = auctionRepository.findAll();
//
//        for (User user: allUsers) {
//
//        }
//        };