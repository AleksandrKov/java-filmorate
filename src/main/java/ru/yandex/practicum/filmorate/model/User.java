package ru.yandex.practicum.filmorate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    private int id;
    @NonNull
    @Email
    private String Email;
    @NonNull
    @NotBlank
    private String login;
    private String name;
    @NonNull
    LocalDate birthday;
}
