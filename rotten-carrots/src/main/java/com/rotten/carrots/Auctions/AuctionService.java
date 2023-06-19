package com.rotten.carrots.Auctions;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.User.User;
import com.rotten.carrots.User.UserRepository;
import com.rotten.carrots.User.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AuctionService {

    AuctionRepository auctionRepository;
    UserService userService;

    public AuctionService(){
    }

    public AuctionService(AuctionRepository auctionRepository, UserRepository userRepository){
        this.auctionRepository = auctionRepository;
        this.userService = new UserService(userRepository);
    }

    public List<Auction> getAll() {
        return auctionRepository.findAll();
    }

    public List<Auction> getByPriceBetween(double minPrice, double maxPrice){
        return auctionRepository.findByPrices(minPrice, maxPrice);
    }

    public List<Auction> getAuctionsByGame(Game game){
        return auctionRepository.findByGame(game);
    }

    public List<Auction> getAuctionsByGenre(String genre){
        return  auctionRepository.findByGameGenre(genre);
    }

    public List<Auction> getActive(){
        return auctionRepository.findActive();
    }

    public Optional<Auction> getAuctionByID(String id) {
        return auctionRepository.findById(id);
    }

    public ResponseEntity<?> deleteAuctionByID(String id) {
        var entity = auctionRepository.findById(id);
        if(entity.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        auctionRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public boolean purchaseById(String auctionID, String userID){
        Optional<Auction> actn = getAuctionByID(auctionID);
        Optional<User> usr = userService.getUserByID(userID);

        if (actn.isPresent() && usr.isPresent()) {
            Auction auction = actn.get();
            User user = usr.get();

            if( !auction.isActive() )
                return false;

            auction.setActive(false);
            user.addBought(auction);

            auctionRepository.save(auction);
            userService.updateUser(user);

            return true;
        } else {
            return false;
        }
    }





}
