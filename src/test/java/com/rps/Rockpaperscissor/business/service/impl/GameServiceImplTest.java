package com.rps.Rockpaperscissor.business.service.impl;

import com.rps.Rockpaperscissor.business.dao.GameDAO;
import com.rps.Rockpaperscissor.business.dao.RoundDAO;
import com.rps.Rockpaperscissor.business.enums.Choice;
import com.rps.Rockpaperscissor.business.enums.GameStatus;
import com.rps.Rockpaperscissor.business.exception.GameNotFoundException;
import com.rps.Rockpaperscissor.business.exception.GameOverException;
import com.rps.Rockpaperscissor.business.model.Game;
import com.rps.Rockpaperscissor.business.service.GameService;
import com.rps.Rockpaperscissor.business.service.GameServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameServiceImplTest {

    private GameDAO gameDAO;

    private RoundDAO roundDAO;

    private GameService classUnderTest;

    @Before
    public void setup() {
        gameDAO = mock(GameDAO.class);
        roundDAO = mock(RoundDAO.class);
        classUnderTest = new GameServiceImpl(gameDAO, roundDAO);
    }


    @Test(expected = GameNotFoundException.class)
    public void shouldThrowBadGameNotFoundException() throws GameNotFoundException {

        // given
        when(gameDAO.findById(any())).thenReturn(Optional.empty());

        // when
        classUnderTest.getStatus(1L);
    }

    @Test(expected = GameOverException.class)
    public void shouldThrowBadGameOverException() throws GameOverException, GameNotFoundException {

        // given
        Game givenGame = new Game();
        givenGame.setGameStatus(GameStatus.FINISHED);
        Long givenId = new Long(1L);
        when(gameDAO.findById(any())).thenReturn(Optional.ofNullable(givenGame));

        // when
        classUnderTest.play(givenId, Choice.getRandom(), Choice.getRandom());

    }

}
