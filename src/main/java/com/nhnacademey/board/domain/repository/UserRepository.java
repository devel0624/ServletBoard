package com.nhnacademey.board.domain.repository;

import com.nhnacademey.board.domain.account.User;

import java.util.Map;

public interface UserRepository {
    void add(User user);
    void modify(User user);
    void remove(String id);

    User getUser(String id);
    Map<String, User> getUsers();
}
