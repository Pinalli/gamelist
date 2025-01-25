package com.pinalli.listgames.services;

import com.pinalli.listgames.dto.GameDTO;
import com.pinalli.listgames.dto.GameListDTO;
import com.pinalli.listgames.dto.GameMinDto;
import com.pinalli.listgames.entities.Game;
import com.pinalli.listgames.entities.GameList;
import com.pinalli.listgames.projections.GameMinProjection;
import com.pinalli.listgames.repository.GameListRepository;
import com.pinalli.listgames.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameListService {

    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;

        this.gameRepository = gameRepository;
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

    @Transactional
    public void moveGamePositionInList(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        if (sourceIndex < 0 || sourceIndex >= list.size() || destinationIndex < 0 || destinationIndex >= list.size()) {
            throw new IllegalArgumentException("Invalid source or destination index");
        }

        if (sourceIndex == destinationIndex) {
            return;
        }

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(destinationIndex, sourceIndex);

        for (int i = min; i <= max; i++) {
           gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }
}
