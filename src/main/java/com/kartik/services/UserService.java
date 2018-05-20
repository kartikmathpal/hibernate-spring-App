package com.kartik.services;

import com.kartik.dao.interfaces.IUserDao;
import com.kartik.entity.User;
import com.kartik.services.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Scanner;
@Service("UserService")
public class UserService implements IUserService {
    private static Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;

    //Logger LOG = LoggerFactory.getLogger(UserService.class);
    private static Logger LOG = LoggerFactory.getLogger(UserService.class);

    @Autowired
    //UserDao userDao = new UserDao();
    IUserDao userDao;

    //@Override
    public User validateUserDetails(User user) throws Exception{


        User userx = userDao.searchUser(user);
        return  userx;
    }

    public User getUserDetails() throws Exception{
        System.out.print("Enter Username: ");
        username = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();

        try {
            User user = validateUserDetails(new User(username,password));
            return user;
        } catch (Exception e) {
            LOG.error ("invalid user credentials {}", e);
//            LOG.info ("\n\n\n\n\n");
//            e.printStackTrace ();

            throw new Exception ("invalid user Credentials");
        }

    }
}
