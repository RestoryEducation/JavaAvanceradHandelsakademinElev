package com.example.javajpademo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.javajpademo.Entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
