package com.pinalli.listgames.services;

import com.pinalli.listgames.dto.GameDTO;
import com.pinalli.listgames.dto.GameListDTO;
import com.pinalli.listgames.dto.GameMinDto;
import com.pinalli.listgames.entities.Game;
import com.pinalli.listgames.entities.GameList;
import com.pinalli.listgames.repository.GameListRepository;
import com.pinalli.listgames.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;

    public GameListService( GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;

    }

    @Transactional(readOnly = true)
    public List<GameListDTO> findAllGames() {
        // find contains a list of Game entities
        List<GameList> dto = gameListRepository.findAll();
        /**
         The line in question will transform each Game into GameMinDto
         Equivalent to doing it manually Functional Approach (Stream):
         other case use Imperative Approach (For) or
         spring batch for large data
         */
        return dto.stream().map(GameListDTO::new).toList();

    }


}
