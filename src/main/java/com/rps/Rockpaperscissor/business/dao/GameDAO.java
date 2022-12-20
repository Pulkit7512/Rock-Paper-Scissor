package com.rps.Rockpaperscissor.business.dao;

import com.rps.Rockpaperscissor.business.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDAO extends JpaRepository<Game,Long> {
}
