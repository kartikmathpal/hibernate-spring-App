package com.kartik.dao.interfaces;

import com.kartik.entity.User;

public interface IUserDao {
     User searchUser(User user)throws Exception;
}
