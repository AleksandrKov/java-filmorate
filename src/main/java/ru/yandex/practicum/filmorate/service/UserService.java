package ru.yandex.practicum.filmorate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.storage.UserStorage;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    private final UserStorage userStorage;

    @Autowired
    public UserService(UserStorage userStorage) {
        this.userStorage = userStorage;
    }

    public User addUser(User user) {
        return userStorage.addUser(user);
    }

    public User updateUser(User user) {
        return userStorage.updateUser(user);
    }

    public Collection<User> getAllUser() {
        return userStorage.getAll();
    }

    public User getUserById(Integer userId) { return userStorage.getUserById(userId);
    }

    public User addToFriends(Integer id, Integer friendId) {
        return userStorage.addToFriends(id, friendId);
    }

    public User removingFromFriends(Integer id, Integer friendId) {
        return userStorage.removingFromFriends(id, friendId);
    }

    public List<User> getAllUsersFriendsById(Integer userId) {
        return userStorage.getAllUsersFriendsById(userId);
    }

    public Collection<User> getCommonFriends(Integer userId, Integer friendId) {
        User user = userStorage.getUserById(userId);
        User friend = userStorage.getUserById(friendId);

        Set<User> commonFriends = new HashSet<>();
        for (int userFriendId : user.getUserAllFriends()) {
            if (friend.getFriendsId().contains(userFriendId)) {
                User commonFriend = userStorage.getUserById(userFriendId);
                commonFriends.add(commonFriend);
            }
        }
        return commonFriends;
    }
}
