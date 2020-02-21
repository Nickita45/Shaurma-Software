package com.orders.management.repository;

import com.orders.management.domain.Spice;
import com.orders.management.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Query( value = "select * from users where login = :login and password = :password" , nativeQuery = true)
    User findByLoginAndPassword(@Param("login") String login, @Param("password") String password);
    Optional<User> findByLogin(String userName);
}