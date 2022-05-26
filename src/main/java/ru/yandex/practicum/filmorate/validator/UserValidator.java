package ru.yandex.practicum.filmorate.validator;

import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
@Slf4j

public class UserValidator {

    public static boolean validate(User user) {
        if (!user.getUserEmail().contains("@") || user.getUserEmail().isBlank()) {
            log.error("ошибка логирования без указания почты");
            throw new ValidationException("email", "не может быть пустой и должна содержать символ @");
        }
        if (user.getLogin().contains(" ") || user.getLogin().isBlank()) {
            log.error("ошибка в логине");
            throw new ValidationException("login", "не может быть пустым и содержать пробелы");
        }
        if (user.getName() == null || user.getName().isBlank()) {
            user.setName(user.getLogin());
            log.info("поле name заменено на login ");
        }
        if (user.getBirthday().isAfter(LocalDate.now())) {
            log.error("");
            throw new ValidationException("birthday", "не может быть в будущем");
        }
        return true;
    }
}


