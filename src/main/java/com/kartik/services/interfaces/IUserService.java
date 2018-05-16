package com.kartik.services.interfaces;

import com.kartik.entity.User;

public interface IUserService {
      User validateUserDetails(User user) throws Exception;
      User getUserDetails() throws Exception;

}
