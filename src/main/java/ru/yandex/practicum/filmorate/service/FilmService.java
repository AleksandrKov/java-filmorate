package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.storage.FilmStorage;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class FilmService {

    private final FilmStorage filmStorage;

    @Autowired
    public FilmService(FilmStorage filmStorage) {
        this.filmStorage = filmStorage;
    }

    public Film addFilm(Film film) {
        return filmStorage.addFilm(film);
    }

    public Film updateFilm(Film film) {
        return filmStorage.updateFilm(film);
    }

    public Collection<Film> getAllFilms() {
        return filmStorage.getAll();
    }

    public Film getFilmById(Integer filmId) {
        return filmStorage.getFilmById(filmId);
    }

    public Film addLikeToFilm(Integer filmId, Integer userId) {
        return filmStorage.addLikeToFilm(filmId, userId);
    }


    public Film delLikeToFilm(Integer filmId, Integer userId) {
        return filmStorage.delLikeToFilm(filmId, userId);
    }

    public Collection<Film> getSelectionOfFilms(Integer count) {

        return filmStorage.getAll().stream()
                .sorted((f1,f2) -> f2.getLikes().size() - f1.getLikes().size())
                .limit(count)
                .collect(Collectors.toList());
    }
}
