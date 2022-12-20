package com.rps.Rockpaperscissor.business.service;

import com.rps.Rockpaperscissor.business.enums.Choice;
import com.rps.Rockpaperscissor.business.exception.GameNotFoundException;
import com.rps.Rockpaperscissor.business.exception.GameOverException;
import com.rps.Rockpaperscissor.business.model.Game;

public interface GameService {

    Game start(String playerOneName, String playerTwoName);

    Game getStatus(Long id) throws GameNotFoundException;

    Game play(Long id, Choice playerOneChoice, Choice playerTwoChoice) throws GameNotFoundException, GameOverException;
}
