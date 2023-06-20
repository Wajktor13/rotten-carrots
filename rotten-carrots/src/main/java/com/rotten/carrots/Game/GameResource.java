package com.rotten.carrots.Game;

import com.rotten.carrots.News.News;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    @GetMapping("/genre/{genre}")
    public List<Game> getGameByGenre(@PathVariable("genre") String genre) {
        return this.gameService.getGameByGenre(genre);
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

    @GetMapping("/sortByTitle")
    public List<Game> getGamesByTitle() {
        return this.gameService.getGamesSortedByTitle();
    }

    @GetMapping("/byTitle/{title}")
    public List<Game> getGameByTitle(@PathVariable("title") String title) {
        return this.gameService.getGameByTitle(title);
    }

    @GetMapping("/developer")
    public List<Game> getGamesFromDeveloper(@RequestParam("name") String name) {
        return gameService.getGameByDeveloper(name);
    }
    @GetMapping("/fromYear")
    public List<Game> getGamesFromOneYear(@RequestParam("year") String year) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String from_ = year+ "-01-01";
        String to_ = year + "-12-31";
        try {
            Date from = format.parse(from_);
            Date to = format.parse(to_);
            return gameService.getNewsBetweenDates(from, to);
        } catch (ParseException e) {
            return new ArrayList<>();
        }
    }

    @GetMapping("/description/{content}")
    public List<Game> getGamesWithDescriptionFragment(@PathVariable("content") String content){
        return gameService.getGamesWithDescriptionFragment(content);
    }
}
