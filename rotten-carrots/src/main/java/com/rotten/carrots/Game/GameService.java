package com.rotten.carrots.Game;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GameService {

    GameRepository gameRepository;

    public GameService() {
    }

    public GameService(GameRepository newsRepository) {
        this.gameRepository = newsRepository;
    }

    public List<Game> getAllGames(){
        return this.gameRepository.findAll();
    }

    public Optional<Game> getGameByID(String gameID) {

        return this.gameRepository.findById(gameID);
    }

    public void deleteGameByID(String gameID){
        this.gameRepository.deleteById(gameID);
    }
}
