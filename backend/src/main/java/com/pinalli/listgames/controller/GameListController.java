package com.pinalli.listgames.controller;

import com.pinalli.listgames.dto.GameListDTO;
import com.pinalli.listgames.dto.GameMinDto;
import com.pinalli.listgames.dto.ReplacementDTO;
import com.pinalli.listgames.services.GameListService;
import com.pinalli.listgames.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameService gameService, GameListService gameListService, GameService gameService1) {
        this.gameListService = gameListService;
        this.gameService = gameService1;
    }

    @GetMapping
    public List<GameListDTO> findAllGames() {
        List<GameListDTO> result;
        result = gameListService.findAllGames();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId) {
        List<GameMinDto> result;
        result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void  moveGamePositionInList(@PathVariable Long listId, @RequestBody  ReplacementDTO body) {
      gameListService.moveGamePositionInList(listId,body.getSourceIndex(), body.getDestinationIndex() );

    }
}
