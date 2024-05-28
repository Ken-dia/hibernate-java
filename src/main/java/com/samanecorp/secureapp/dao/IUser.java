package com.samanecorp.secureapp.dao;

import com.samanecorp.secureapp.entities.UserEntity;

import java.util.List;

public interface IUser {
    public List<UserEntity> liste();
    public boolean delete(long mat);
    public boolean update(UserEntity e);
    public UserEntity get(long mat);
    public boolean add(UserEntity u);

}
