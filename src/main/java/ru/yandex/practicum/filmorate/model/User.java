package ru.yandex.practicum.filmorate.model;

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
    private Set<Integer> friendsId = new HashSet<>();

    public boolean addFriend(int id) {
        return friendsId.add(id);
    }

    public boolean removingFromFriends(int id) {
        return friendsId.remove(id);
    }

    public List<Integer> getUserAllFriends() {
        List<Integer> friends = new ArrayList<>();
        friends.addAll(friendsId);
        return friends;
    }
}

