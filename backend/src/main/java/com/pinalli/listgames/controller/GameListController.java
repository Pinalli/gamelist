package com.pinalli.listgames.controller;

import com.pinalli.listgames.dto.GameListDTO;
import com.pinalli.listgames.services.GameListService;
import com.pinalli.listgames.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    private final GameListService gameListService;

    public GameListController(GameService gameService, GameListService gameListService) {
        this.gameListService = gameListService;
    }

    @GetMapping
    public List<GameListDTO> findAllGames() {
        List<GameListDTO> result;
        result = gameListService.findAllGames();
        return result;
    }
}
