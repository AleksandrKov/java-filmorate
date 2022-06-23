package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
//@AllArgsConstructor
//@Builder
public class Film {
    private Integer id;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    private String description;
    @NotNull
    private LocalDate releaseDate;
    @NotNull
    private Integer duration;
    private Set<Integer> likes = new HashSet<>();

    @Builder
    public Film(Integer id, String name, String description, LocalDate releaseDate, Integer duration,Set<Integer> likes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.duration = duration;
        if (this.likes == null)
            likes = new HashSet<>();
    }

    public int getLikesCount() {
        return likes.size();
    }

    public boolean setLikes(int userId) {
        if (likes.add(userId))
            return true;
        return false;
    }

    public boolean delLikes(int userId) {
        if (!likes.contains(userId))
            return false;
        likes.remove(userId);
        return true;
    }
}
