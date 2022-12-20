package com.rps.Rockpaperscissor.controller;

import com.rps.Rockpaperscissor.business.enums.Choice;
import com.rps.Rockpaperscissor.business.exception.GameNotFoundException;
import com.rps.Rockpaperscissor.business.exception.GameOverException;
import com.rps.Rockpaperscissor.business.model.Game;
import com.rps.Rockpaperscissor.business.service.GameService;
import com.rps.Rockpaperscissor.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;

@Api(tags = "Game")
@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Game start(
            @RequestParam("playerOneName") String playerOneName) {
        return gameService.start(playerOneName, Constants.PLAYER_TWO_NAME);
    }

    @GetMapping("/{gameId}")
    public Game getStatus(
            @PathVariable("gameId") Long id) throws GameNotFoundException {
        return gameService.getStatus(id);
    }

    @PutMapping("/{gameId}")
    public Game play(
            @PathVariable("gameId") Long id,
            @RequestParam("choice") Choice playerOneChoice) throws GameOverException, GameNotFoundException {
        Choice playerTwoChoice = Choice.getRandom();
        return gameService.play(id, playerOneChoice, playerTwoChoice);
    }
}
