package ru.yandex.practicum.filmarate.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    private static UserController userController;

    @BeforeEach
    public void beforeEach() {
        userController = new UserController();
    }

    @Test
    public void addUser() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        userController.addUser(user);
        assertTrue(userController.getAll().contains(user));
    }

    @Test
    public void addUserWithEmailBlankAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setUserEmail("");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    public void addUserWithEmailWithoutDogAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setUserEmail("QWE");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithLoginIsEmptyAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setLogin("");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithLoginContainsSpaceAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setLogin("fdlj dkjf");
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }

    @Test
    void addUserWithNameIsNullAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "thdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setName("");
      //  assertThrows(ValidationException.class, () -> userController.addUser(user));
        userController.addUser(user);
        final Collection<User> users = userController.getAll();
        for (User user1 : users) {
            assertEquals(user1.getName(), user1.getLogin());
        }
    }

    @Test
    void addUserWithFalseDateReliesAndShouldBeException() {
        User user = new User(1, "A@yandex.ru", "tdesbillVasya", "Vasya",
                LocalDate.parse("2000-01-01"));
        user.setBirthday((LocalDate.parse("3000-01-01")));
        assertThrows(ValidationException.class, () -> userController.addUser(user));
        assertFalse(userController.getAll().contains(user));
    }
}