package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Game.GameRepository;
import com.rotten.carrots.Game.GameService;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auctions")
public class AuctionResource {

    private final AuctionService auctionService;
    private final GameService gameService;

    public AuctionResource(AuctionRepository auctionRepository, GameRepository gameRepository, ReviewRepository reviewRepository) {
        this.auctionService = new AuctionService(auctionRepository);
        this.gameService = new GameService(gameRepository, reviewRepository);
    }

    @GetMapping("/all")
    public List<Auction> getAll() {
        return auctionService.getAll();
    }

    @GetMapping("/active")
    public List<Auction> getActive() {return auctionService.getActive();}

    @GetMapping("/{auctionID}")
    public Optional<Auction> getAuctionByID(@PathVariable("auctionID") String id) {
        return auctionService.getAuctionByID(id);
    }

    @GetMapping("/game/{gameId}")
    public List<Auction> getAuctionsByGame(@PathVariable("gameId") String gameId) {
        Optional<Game> game = gameService.getGameByID(gameId);
        return game.map(auctionService::getAuctionsByGame).orElse(null);
    }

    @GetMapping("/price")
    public List<Auction> getAuctionsBetweenPrices(
            @RequestParam("minPrice") double minPrice,
            @RequestParam("maxPrice") double maxPrice) {
        // http://localhost:8080/auctions/price?minPrice=28.0&maxPrice=29.0
        return auctionService.getByPriceBetween(minPrice, maxPrice);
    }

    @GetMapping("/game/genre/{genre}")
    public List<Auction> getAuctionByGameGenre(@PathVariable("genre") String genre){
        List<Game> games = gameService.getGameByGenre(genre);
        List<Auction> res = new ArrayList<>();
        for(Game game : games){
            res.addAll(auctionService.getAuctionsByGame(game));
        }
        return res;
        //return auctionService.getAuctionsByGenre(genre);
    }

    @DeleteMapping("/{auctionID}")
    public ResponseEntity<?> deleteAuction(@PathVariable("auctionID") String id) {
        return auctionService.deleteAuctionByID(id);
    }
}
