package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.validator.FilmsValidator;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/films")

public class FilmController {
    private FilmsValidator filmsValidator = new FilmsValidator();
    private final Map<Integer,Film> films = new HashMap<>();
    private int filmsCount = 0;

    public int getFilmsCount() {
        return filmsCount++;
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film) throws ValidationException {
        if (films.containsKey(film.getId())) {
            log.error("попытка заменить фильм");
            throw new ValidationException("id", " фильм с таким id существует");
        }
        film.setId(getFilmsCount());
        if (filmsValidator.validate(film)) {
            films.put(film.getId(), film);
            log.info(film.getName() + " добавлен");
        }
        return film;
    }

    @PutMapping
    public Film updateFilm(@Valid @RequestBody Film film) throws ValidationException {
 //       if(!films.containsKey(film.getId())) {
   //         log.error("попытка обновить фильм без указания id");
     //       throw new ValidationException("id", "не может быть пустым");
     //   }
        if (filmsValidator.validate(film)) {
            films.put(film.getId(), film);
            log.info(film.getName() + " обновлен");
        }
        return film;
    }

    @GetMapping
    public Collection<Film> getAll() {
        System.out.println("Collection<Film>");
        return films.values();
    }
}
