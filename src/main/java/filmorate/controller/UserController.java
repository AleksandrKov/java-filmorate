package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.validator.UserValidator;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
   private UserValidator userValidator = new UserValidator();
   private Map<Integer, User> users = new HashMap<>();

    @PostMapping
    public void addUser(@Valid @RequestBody User user) throws ValidationException {
        if (userValidator.validate(user)) {
            log.info(user.getId() + " зарегистрировался на сервисе");
            users.put(user.getId(), user);
        }
    }

    @PutMapping
    public void updateUser(@Valid @RequestBody User user) throws ValidationException {
        if (userValidator.validate(user)) {
            log.info(user.getId() + " обновил учетную запись");
            users.put(user.getId(), user);
        }
    }

    @GetMapping
    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }
}
