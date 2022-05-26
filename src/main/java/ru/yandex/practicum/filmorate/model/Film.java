package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.time.Duration;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Film {
    private int id;
    @NonNull
    @NotBlank
    private String name;
    @NonNull
    private String description;
    @NonNull
    private LocalDate dateRelease;
    @NonNull
    private Duration duration;
}
