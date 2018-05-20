package com.kartik.dao;

import com.kartik.dao.interfaces.IUserDao;
import com.kartik.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@Transactional //If this not added to repository:"Could not obtain transaction-synchronized Session for current thread"
@Repository("UserDao")
public class UserDao implements IUserDao {

    private static ArrayList <User> users;

    static {
        users = new ArrayList <User> ();

    }

    @Autowired
    private SessionFactory sessionFactory;

    public User searchUser(User user) throws Exception {

        user = (User) sessionFactory
                .getCurrentSession ()
                .createQuery ("from User where username=:username and password=:password")
                .setParameter ("username", user.getUsername ())
                .setParameter ("password", user.getPassword ())
                .uniqueResult ();

        if (user == null) {
            throw new Exception ("User with provided credentials does not exists");
        } else {
            return user;
        }
    }





}
