package com.rotten.carrots.Game;

import com.rotten.carrots.Review.Review;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/games")
public class GameResource {

    private GameService gameService;

    public GameResource(GameRepository gameRepository, ReviewRepository reviewRepository) {
        this.gameService = new GameService(gameRepository, reviewRepository);
    }

    @GetMapping("/all")
    public List<Game> getAll() {
        return this.gameService.getAllGames();
    }

    @GetMapping("/{gameID}")
    public Optional<Game> getGameByID(@PathVariable("gameID") String gameID) {
        return this.gameService.getGameByID(gameID);
    }

    @GetMapping("/{gameID}/rate")
    public Integer getGameRate(@PathVariable("gameID") String gameID){
        return this.gameService.avgRate(gameID);
    }

    @DeleteMapping("/{gameID}")
    public ResponseEntity<?> deleteGame(@PathVariable("gameID") String gameID) {
        try {
            this.gameService.deleteGameByID(gameID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
