package ru.yandex.practicum.filmorate.storage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.yandex.practicum.filmorate.exception.UserNotFoundException;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.validator.UserValidator;

import java.util.*;

@Slf4j
@Component

public class InMemoryUserStorage implements UserStorage {

    private final Map<Integer, User> users = new HashMap<>();
    private int usersCount = 1;

    public int getUsersCount() {
        return usersCount++;
    }


    @Override
    public User addUser(User user) throws ValidationException {
        if (users.containsKey(user.getId())) {
            log.error("попытка заменить пользователя");
            throw new ValidationException("id", " пользователь с таким id существует");
        }
        if (UserValidator.validate(user)) {
            user.setId(getUsersCount());
            log.info(user.getId() + " зарегистрировался на сервисе");
            users.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public User updateUser(User user) throws ValidationException {
        if (!users.containsKey(user.getId())) {
            log.error("Попытка обновление не существующего пользователя");
            throw new UserNotFoundException("Пользователь с id: " + user.getId() + " не найден");
        }
        if (UserValidator.validate(user)) {
            log.info(user.getId() + " обновил учетную запись");
            users.put(user.getId(), user);
        }
        return user;
    }

    @Override
    public Collection<User> getAll() {
        return users.values();
    }

    @Override
    public User getUserById(Integer userId) throws UserNotFoundException {
        if (!users.containsKey(userId))
            throw new UserNotFoundException("Пользователь с id " + userId + " не найден");
        return users.get(userId);
    }

    @Override
    public User addToFriends(Integer id, Integer userId) throws UserNotFoundException {
        if (!users.containsKey(id))
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        if (!users.containsKey(userId))
            throw new UserNotFoundException("Пользователь с id " + userId + " не найден");
        User user = users.get(id);
        User friend = users.get(userId);
        user.addFriend(userId);
        friend.addFriend(id);
        return user;
    }

    @Override
    public User removingFromFriends(Integer id, Integer friendId) {
        User user = users.get(id);
        user.removingFromFriends(friendId);
        User friend = users.get(friendId);
        friend.removingFromFriends(id);
        return user;
    }

    @Override
    public List<User> getAllUsersFriendsById(Integer userId) {
        User user = users.get(userId);
        List<Integer> friendsId = (user.getUserAllFriends());
        List<User> friends = new ArrayList<>();
        for (int id : friendsId) {
            User friend = users.get(id);
            friends.add(friend);
        }
        return friends;
    }
}
