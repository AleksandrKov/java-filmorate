package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.validator.FilmsValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/films")

public class FilmController {
   private FilmsValidator filmsValidator = new FilmsValidator();
   private Map<Integer,Film> films = new HashMap<>();

    @PostMapping
    public void addFilm(@Valid @RequestBody Film film) throws ValidationException {
        if (filmsValidator.validate(film)) {
            films.put(film.getId(), film);
            log.info(film.getName() + " добавлен");
        }
    }

    @PutMapping
    public void updateFilm(@Valid @RequestBody Film film) throws ValidationException {
        if (filmsValidator.validate(film)) {
            films.put(film.getId(), film);
            log.info(film.getName() + " обновлен");
        }
    }

    @GetMapping
    public List<Film> getAll() {
        return new ArrayList<>(films.values());
    }
}
