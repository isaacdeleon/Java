package com.in28minutes.rest.webservices.restfulwebservices.dao;


import com.in28minutes.rest.webservices.restfulwebservices.beans.UserBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<UserBean> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new UserBean(1, "Adam", new Date()));
        users.add(new UserBean(2, "Eve", new Date()));
        users.add(new UserBean(3, "Jack", new Date()));
    }

    public List<UserBean> findAll() {
        return users;
    }

    public UserBean save(UserBean user) {
        if(user.getId() == null) {
            user.setId(++usersCount);
        }
        users.add(user);
        return user;
    }

    public UserBean findOne(int id) {
        for(UserBean user: users) {
            if(user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public UserBean deleteById(int id) {
        Iterator<UserBean> iterator = users.iterator();
        while(iterator.hasNext()) {
            UserBean userBean = iterator.next();
            if(userBean.getId() == id) {
                iterator.remove();
                return userBean;
            }
        }
        return null;
    }
}
