package ru.yandex.practicum.filmorate.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@Valid @RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping
    public Collection<User> getAll() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    public User getFilmById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }
//добавление в друзья
    @PutMapping("/{id}/friends/{friendId}")
    public User addToFriends(@PathVariable Integer id, @PathVariable Integer friendId) {
        return userService.addToFriends(id, friendId);

    }
// удаление из друзей
    @DeleteMapping("/{id}/friends/{friendId}")
    public User removingFromFriends(@PathVariable Integer id, @PathVariable Integer friendId) {
        return userService.removingFromFriends(id, friendId);

    }

    // список друзей
    @GetMapping("/{id}/friends")
    public List<User> getAllUsersFriendsById(@PathVariable Integer id) {
        return userService.getAllUsersFriendsById(id);
    }

    //список общих друзей
    @GetMapping("/{id}/friends/common/{otherId}")
    public Collection<User> commonFriends(@PathVariable Integer id, @PathVariable Integer otherId) {
        return userService.getCommonFriends(id, otherId);
    }
}
