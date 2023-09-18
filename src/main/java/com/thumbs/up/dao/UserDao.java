package com.thumbs.up.dao;

import com.thumbs.up.domain.UserDto;

public interface UserDao {
    UserDto select(String id) throws Exception;
    int delete(String id, String pwd) throws Exception;
    int insert(UserDto dto) throws Exception;
    int update(UserDto dto) throws Exception;
    int count() throws Exception;
    int deleteAll() throws Exception;
}