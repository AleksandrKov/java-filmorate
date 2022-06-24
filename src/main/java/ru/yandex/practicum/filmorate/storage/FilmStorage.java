package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.util.Collection;

public interface FilmStorage {

    Film addFilm(Film film) throws ValidationException;

    Film updateFilm(Film film) throws ValidationException;

    Collection<Film> getAll();

    Film getFilmById(Integer filmId);

    Film addLikeToFilm(Integer filmId, Integer userId);

    Film delLikeToFilm(Integer filmId, Integer userId);

}
