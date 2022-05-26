package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.Duration;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FilmControllerTest {
    private static FilmController filmController;

    @BeforeEach
    public void beforeEach() {filmController = new FilmController();
    }

    @Test
    public void addFilm() {
        Film film = new Film(1, "Kino", "Description", LocalDate.parse("2000-01-01"),
                Duration.ofMinutes(10));
        filmController.addFilm(film);
        assertTrue(filmController.getAll().contains(film));
    }

    @Test
    public void addFilmWithNameIsBlankAndShouldBeException() {
        Film film = new Film(1, "Kino", "Description", LocalDate.parse("2000-01-01"),
                Duration.ofMinutes(10));
        film.setName("");
        assertThrows(ValidationException.class, () -> filmController.addFilm(film));
        assertFalse(filmController.getAll().contains(film));
    }

    @Test
    void addFilmWithDescriptionIsBigAndShouldBeException() {
        Film film = new Film(1, "Kino", "Description", LocalDate.parse("2000-01-01"),
                Duration.ofMinutes(10));
        film.setDescription("это описание к фильму которое содержит больше 200 знаков. Здесь мы что то описываем и" +
                " описываем и описываем и уже даже надоело описывать но мы продолжаем потому что тесты это наше все! " +
                "Наконец уже подходит к концу описание и мы проверим тест");
        assertThrows(ValidationException.class, () -> filmController.addFilm(film));
        assertFalse(filmController.getAll().contains(film));
    }

    @Test
    void addFilmWithDurationIsNegativeAndShouldBeException() {
        Film film = new Film(1, "Kino", "Description", LocalDate.parse("2000-01-01"),
                Duration.ofMinutes(10));
        film.setDuration(Duration.ofMinutes(-100));
        assertThrows(ValidationException.class, () -> filmController.addFilm(film));
        assertFalse(filmController.getAll().contains(film));
    }

    @Test
    void addFilmWithFalseDateReliesAndShouldBeException() {
        Film film = new Film(1, "Kino", "Description", LocalDate.parse("2000-01-01"),
                Duration.ofMinutes(10));
        film.setDateRelease((LocalDate.parse("1895-12-27")));
        assertThrows(ValidationException.class, () -> filmController.addFilm(film));
        assertFalse(filmController.getAll().contains(film));
    }
}