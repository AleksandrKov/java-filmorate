package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.service.FilmService;

import java.util.Collection;


@RestController
@Slf4j
@RequestMapping("/films")

public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    @PutMapping
    public Film updateFilm(@RequestBody Film film) {
        return filmService.updateFilm(film);
    }

    @GetMapping
    public Collection<Film> getAll() {
        return filmService.getAllFilms();
    }

    @PutMapping("{id}/like/{userId}")
    public Film addLikeToFilm(@PathVariable Integer id, @PathVariable Integer userId) {
        return filmService.addLikeToFilm(id, userId);
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Integer id) {
        return filmService.getFilmById(id);
    }

    @DeleteMapping("/{id}/like/{userId}")
    public Film deleteLikeToFilm(@PathVariable Integer id, @PathVariable Integer userId) {
        return filmService.delLikeToFilm(id, userId);
    }

    @GetMapping("/popular")
    public Collection<Film> getSelectionOfFilms(@RequestParam(defaultValue = "10", required = false) Integer count) {
        return filmService.getSelectionOfFilms(count);
    }
}
