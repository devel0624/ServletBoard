package com.nhnacademey.board.domain.account;

public class Admin implements User, Administrator{
    String id;
    String name;
    String password;
    String profileFileName;

    public Admin(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.profileFileName = "프로필 사진을 등록해주세요";
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getProfileFileName() {
        return profileFileName;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }
}
