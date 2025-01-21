package com.pinalli.listgames.services;

import com.pinalli.listgames.dto.GameDTO;
import com.pinalli.listgames.dto.GameMinDto;
import com.pinalli.listgames.entities.Game;
import com.pinalli.listgames.projections.GameMinProjection;
import com.pinalli.listgames.repository.GameRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findAllGames() {
        // find contains a list of Game entities
        List<Game> dto = gameRepository.findAll();
        /**
         The line in question will transform each Game into GameMinDto
         Equivalent to doing it manually Functional Approach (Stream):
         other case use Imperative Approach (For) or
         spring batch for large data
         */
        return dto.stream().map(GameMinDto::new).toList();

    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        return gameRepository.findById(id)
                .map(GameDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Game not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        List<GameMinProjection> dto = gameRepository.searchByList(listId);
        return dto.stream().map(GameMinDto::new).toList();

    }

}