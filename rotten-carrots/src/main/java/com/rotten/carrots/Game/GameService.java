package com.rotten.carrots.Game;

import com.rotten.carrots.Review.Review;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService {

    GameRepository gameRepository;
    ReviewRepository reviewRepository;

    public GameService(GameRepository gameRepository, ReviewRepository reviewRepository) {
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<Game> getAllGames(){
        return this.gameRepository.findAll();
    }

    public Optional<Game> getGameByID(String gameID) {
        return this.gameRepository.findById(gameID);
    }

    public int avgRate(String gameID){
        List<Review> reviews = reviewRepository.findByGameID(gameID);

        if (reviews.size() == 0)
            return 0;

        Integer rate = 0;

        for (Review review : reviews)
            rate += review.getCarrotRate();

        return rate/reviews.size();
    }

    public List<Game> getGameByGenre(String genre){
        return this.gameRepository.findByGenre(genre);
    }

    public void deleteGameByID(String gameID){
        this.gameRepository.deleteById(gameID);
    }
}
