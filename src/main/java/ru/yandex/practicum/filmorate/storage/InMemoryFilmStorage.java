package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.FilmNotFoundException;
import ru.yandex.practicum.filmorate.exception.LikeNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.validator.FilmsValidator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class InMemoryFilmStorage implements FilmStorage{

    private final Map<Integer,Film> films = new HashMap<>();
    private int filmsCount = 1;

    public int getFilmsCount() {
        return filmsCount++;
    }

    @Override
    public Film addFilm(Film film) throws ValidationException {
        if (films.containsKey(film.getId())) {
            log.error("попытка заменить фильм");
            throw new ValidationException("id", " фильм с таким id существует");
        }
        if (FilmsValidator.validate(film)) {
            film.setId(getFilmsCount());
            films.put(film.getId(), film);
            log.info(film.getName() + " фильм добавлен");
        }
        return film;
    }

    @Override
    public Film updateFilm(Film film) throws ValidationException, FilmNotFoundException {
        System.out.println(film);
        System.out.println(film.getId());
        if (!films.containsKey(film.getId())) {
            log.error("Попытка обновление не существующего фильма");
            throw new FilmNotFoundException("Фильм с id:" + film.getId() + " не найден");
        }
        if (FilmsValidator.validate(film)) {
                films.put(film.getId(), film);
                log.info(film.getName() + "обновлен");
            }
        return film;
        }

    @Override
    public Collection<Film> getAll() {
        return films.values();
    }

    @Override
    public Film getFilmById(Integer filmId) throws FilmNotFoundException {
        if (!films.containsKey(filmId))
            throw new FilmNotFoundException("Фильм с таким id " + filmId + " не найден");
        return films.get(filmId);
    }

    @Override
    public Film addLikeToFilm(Integer filmId, Integer userId) {
        Film film = films.get(filmId);
        film.setLikes(userId);
        return film;
    }

    @Override
    public Film delLikeToFilm(Integer filmId, Integer userId) throws LikeNotFoundException {
        Film film = films.get(filmId);
        if (!film.delLikes(userId)) {
            log.error("попытка удаления не существующего лайка");
            throw new LikeNotFoundException("Лайк " + userId + " не найден");
        }
        return film;
    }
}
