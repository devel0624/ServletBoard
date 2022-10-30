package com.nhnacademey.board.domain.repository;

import com.nhnacademey.board.domain.account.User;

import java.util.HashMap;
import java.util.Map;

public class UserList implements UserRepository{

    Map<String , User> users ;

    public UserList(){
        users = new HashMap<>();
    }

    @Override
    public void add(User user){
        users.put(user.getId(),user);
    }

    @Override
    public void modify(User user){

    }
    @Override
    public void remove(String id){

    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

}
