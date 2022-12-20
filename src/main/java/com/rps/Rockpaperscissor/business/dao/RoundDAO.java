package com.rps.Rockpaperscissor.business.dao;

import com.rps.Rockpaperscissor.business.model.Round;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RoundDAO extends JpaRepository<Round,Long> {
}
