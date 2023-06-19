package com.rotten.carrots.User;

import com.rotten.carrots.Game.Game;
import com.rotten.carrots.Game.GameRepository;
import com.rotten.carrots.Game.GameService;
import com.rotten.carrots.Review.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;
    private final GameService gameService;

    public UserResource(UserRepository userRepository, GameRepository gameRepository,
                        ReviewRepository reviewRepository) {
        this.userService = new UserService(userRepository);
        this.gameService = new GameService(gameRepository, reviewRepository);
    }

    // GET

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userID}")
    public ResponseEntity<?> getUserByID(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserByID(userID);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/nickname/{nickname}")
    public ResponseEntity<?> getUserByNickname(@PathVariable("nickname") String nickname) {
        Optional<User> user = userService.getUserByNickname(nickname);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/reviews")
    public ResponseEntity<?> getUserReviews(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserByID(userID);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get().getReviews());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/auctions")
    public ResponseEntity<?> getUserAuctions(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserByID(userID);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get().getAuctions());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/auctions/active")
    public ResponseEntity<?> getUserActiveAuctions(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserActiveAuctions(userID);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getAuctions());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/auctions/finished")
    public ResponseEntity<?> getUserFinishedAuctions(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserFinishedAuctions(userID);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get().getAuctions());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userID}/favourite-games")
    public ResponseEntity<?> getUserFavouriteGames(@PathVariable("userID") String userID) {
        Optional<User> user = userService.getUserByID(userID);
        if (user.isPresent()){
            return ResponseEntity.ok(user.get().getFavouriteGames());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        try {
            User createdUser = userService.saveUser(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // PUT

    @PutMapping("/{userID}/add-favourite-game/{gameID}")
    public ResponseEntity<?> addGameToFavourite(@PathVariable("userID") String userID,
                                                @PathVariable("gameID") String gameID) {

        Optional<User> userOptional = this.userService.getUserByID(userID);
        Optional<Game> gameOptional = this.gameService.getGameByID(gameID);

        if (userOptional.isPresent() && gameOptional.isPresent()){
            User user = userOptional.get();
            Game game = gameOptional.get();

            for (Game existingGame : user.getFavouriteGames()) {
                if (existingGame.getGameID().equals(game.getGameID())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
                }
            }

            user.addFavouriteGame(game);
            this.userService.saveUser(user);

            return ResponseEntity.ok().build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userID}/remove-favourite-game/{gameID}")
    public ResponseEntity<?> removeGameFromFavourite(@PathVariable("userID") String userID,
                                                     @PathVariable("gameID") String gameID) {

        Optional<User> userOptional = this.userService.getUserByID(userID);

        if (userOptional.isPresent()){
            User user = userOptional.get();
            boolean removed = user.getFavouriteGames()
                    .removeIf(game -> game.getGameID().equals(gameID));

            if (removed){
                this.userService.saveUser(user);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE

    @DeleteMapping("/{userID}")
    public ResponseEntity<?> deleteUser(@PathVariable("userID") String userID) {
        try {
            this.userService.deleteUserByID(userID);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
