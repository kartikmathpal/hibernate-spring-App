package com.kartik.services;

import com.kartik.dao.UserDao;
import com.kartik.entity.User;
import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserServiceTest {

    @Tested
    private UserService userService;


    @Mocked
    private UserDao userDao;


    @Test
    public void  getUserDetails() throws Exception {

        new Expectations () {{
            userDao.searchUser (new User ("kartik", "mathpal"));
                result = new User ("kartik", "mathpal");
        }};

        User userToBeSearched = new User ("kartik", "mathpal");
        User returnedUser = null;
        returnedUser =  userDao.searchUser (userToBeSearched);

        System.out.println ("returned user" +  returnedUser);


    }

    @Test
    public void  addition() throws Exception {

        Assert.assertEquals (false, checkIfAgtB (2, 3));
        Assert.assertEquals (true, checkIfAgtB(4,2));


    }


    boolean checkIfAgtB(int a , int b) {
        return a > b;
    }


}
