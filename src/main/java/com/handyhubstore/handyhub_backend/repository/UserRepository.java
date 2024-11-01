package com.handyhubstore.handyhub_backend.repository;

import com.handyhubstore.handyhub_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);
}
