package com.microservice.repo;

import com.microservice.domain.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kristian and Øyvind on 26.03.2017.
 */
@Transactional
public interface UserRepo {

    List<User> findAll();
    void createUser(String username, String password);
}