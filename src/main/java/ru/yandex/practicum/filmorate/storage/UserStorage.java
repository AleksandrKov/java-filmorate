package ru.yandex.practicum.filmorate.storage;

import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;
import java.util.List;

public interface UserStorage {

    User addUser(User user) throws ValidationException;

    User updateUser(User user) throws ValidationException;

    Collection<User> getAll();

    User getUserById(Integer userId);

    User addToFriends(Integer id, Integer userId);

    User removingFromFriends(Integer id, Integer friendId);

    List<User> getAllUsersFriendsById(Integer userId);
}
