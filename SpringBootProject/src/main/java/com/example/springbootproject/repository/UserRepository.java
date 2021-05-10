package com.example.springbootproject.repository;

import com.example.springbootproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query(value = "SELECT user FROM User user WHERE user.name = ?1 ")
//    User getTheUserWithName(@Param("name") String name);

    User findByName(String name);
}
