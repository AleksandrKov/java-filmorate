package ru.yandex.practicum.filmorate.model;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class User {
    private int id;
    @NonNull
    @Email
    private String email;
    @NonNull
    @NotBlank
    private String login;
    private String name;
    @NonNull
    LocalDate birthday;
    private Set<Integer> friendsId;

    @Builder
    public User(int id, String email, String login, String name, LocalDate birthday, Set<Integer> friendsId) {
        this.id = id;
        this.email = email;
        this.login = login;
        this.name = name;
        this.birthday = birthday;
        if (this.friendsId == null) {
            this.friendsId = new HashSet<>();
        }
    }

    public boolean addFriend(int id) {
        if (friendsId.add(id))
            return true;
        return false;
    }

    public boolean removingFromFriends(int id) {
        if (friendsId.remove(id))
            return true;
        return false;
    }
    public List<Integer> getUserAllFriends() {
        List<Integer> friends = new ArrayList<>();
        friends.addAll(friendsId);
        return friends;
    }
}
