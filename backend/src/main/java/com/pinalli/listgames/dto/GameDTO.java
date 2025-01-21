package com.pinalli.listgames.dto;

import com.pinalli.listgames.entities.Game;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long id;
    private String title;
    private Double score;
    private Integer gameYear;
    private String genre;
    private String platforms;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game entity){
        //copy all attributes from entity to this
        BeanUtils.copyProperties(entity, this);
    }
}
