package ru.yandex.practicum.filmorate.model;

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

    public int getLikesCount() {
        return likes.size();
    }

    public boolean setLikes(int userId) {
        return likes.add(userId);
    }

    public boolean deleteLikes(int userId) {
        return likes.remove(userId);
    }
}
