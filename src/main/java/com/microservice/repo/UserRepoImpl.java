package com.microservice.repo;

import com.microservice.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Kristian and Øyvind on 26.03.2017.
 */

@Repository
public class UserRepoImpl implements UserRepo {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll(){
        return this.entityManager.createQuery("Select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void createUser(String username, String password) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);

        entityManager.persist(u);
    }

}
