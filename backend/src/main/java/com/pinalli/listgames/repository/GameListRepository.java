package com.pinalli.listgames.repository;

import com.pinalli.listgames.entities.Game;
import com.pinalli.listgames.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
