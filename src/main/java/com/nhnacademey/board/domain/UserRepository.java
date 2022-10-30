package com.nhnacademey.board.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    Map<String , User> users ;

    public UserRepository(){
        users = new HashMap<>();
    }

    public void registUser(User user){
        users.put(user.getId(),user);
    }

    public boolean findUser(String id){
        return users.containsKey(id);
    }

    public boolean matchPassword(String id, String pw){
        return users.get(id).getPassword().equals(pw);
    }

    public User getUser(String id){
        return users.get(id);
    }
}
