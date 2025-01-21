package com.pinalli.listgames.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Objects;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "score")
    private Double score;

    @Column(name = "game_year")
    private Integer gameYear;

    @Column(name = "genre")
    private String genre;

    @Column(name = "platforms")
    private String platforms;

    @Column(name = "img_url")
    private String imgUrl;

    @Column(columnDefinition = "TEXT",name = "short_description")
    private String shortDescription;

    @Column(columnDefinition = "TEXT",name = "long_description")
    private String longDescription;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(id, game.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

