package com.example.demo.deo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.User;

import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class UserDataAccessServices implements UserDeo {

    private static List<User> users = new ArrayList<>();

    @Override
    public int insertUser(UUID id, User user) {
        users.add(user);
        return 1;
    }

    @Override
    public List<User> selectAllUsers() {
        return users;
    }

    @Override
    public int deleteUser(UUID id) {
        users.removeIf(user_ -> user_.getId().equals(id));
        return 1;
    }

    @Override
    public int updateUser(UUID id, User user) {
        return selectUserById(id).map(u -> {
            int index = users.indexOf(u);
            if (index >= 0) {
                user.setId(id);
                users.set(index, user);
                return 1;
            }
            return 0;
        }).orElse(null);

    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

}
