package com.pinalli.listgames.dto;


import com.pinalli.listgames.entities.GameList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GameListDTO {

    private Long id;
    private String name;

    public GameListDTO(GameList entity) {
        id = entity.getId();
        name = entity.getName();
    }

}
