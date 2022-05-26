package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.validator.UserValidator;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    private UserValidator userValidator = new UserValidator();
    private Map<Integer, User> users = new HashMap<>();

    @PostMapping
    public User addUser(@Valid @RequestBody User user) throws ValidationException {
        if (userValidator.validate(user)) {
            log.info(user.getId() + " зарегистрировался на сервисе");
            users.put(user.getId(), user);
        }
        return user;
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) throws ValidationException {
        if (userValidator.validate(user)) {
            log.info(user.getId() + " обновил учетную запись");
            users.put(user.getId(), user);
        }
        return user;
    }

    @GetMapping
    public Collection<User> getAll() {
        return users.values();
    }
}
