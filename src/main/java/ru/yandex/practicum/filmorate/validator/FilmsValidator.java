package ru.yandex.practicum.filmorate.validator;

import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

@Slf4j
public class FilmsValidator {
    private final static int MAX_DESCRIPTION_LENGTH = 200;
    private final static LocalDate MIN_RELIES_DATE = LocalDate.parse("1895-12-28");

    public static boolean validate(Film film) {
        if (film.getName() == null || film.getName().isBlank()) {
            log.error("ошибка создания фильма без названия");
            throw new ValidationException("name", "не может быть пустым");
        }
        if (film.getDescription().length() > MAX_DESCRIPTION_LENGTH) {
            log.error("превышение максимальной длинны описания");
            throw new ValidationException("description", "максимальная длина — 200 символов");
        }
        if (film.getReleaseDate().isBefore(MIN_RELIES_DATE)) {
            log.error("");
            throw new ValidationException("releaseDate", "должен быть не раньше 28 декабря 1895 года");
        }
        if (film.getDuration().isNegative()) {
            System.out.println("tut");
            throw new ValidationException("duration", "должна быть положительной");
        }
        return true;
    }
}
