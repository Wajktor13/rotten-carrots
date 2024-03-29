package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Game.GameRepository;
import com.rotten.carrots.Game.GameService;
import com.rotten.carrots.Review.ReviewRepository;
import com.rotten.carrots.User.UserRepository;
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

    public AuctionResource(AuctionRepository auctionRepository, GameRepository gameRepository, ReviewRepository reviewRepository, UserRepository userRepository) {
        this.auctionService = new AuctionService(auctionRepository, userRepository);
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

    @PostMapping("/buy")
    public String buyAuction(
            @RequestParam("auctionid") String auctionID,
            @RequestParam("userid") String userID) {
        // http://localhost:8080/auctions/buy?auctionid=648da202b75f480affc80370&userid=648d724e020f97c10309f32c

        boolean success = auctionService.purchaseById(auctionID, userID);
        if (success) return "Purchased";
        return "Failed to Purchase";
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
