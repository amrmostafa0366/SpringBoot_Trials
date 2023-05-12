package com.butcher.app.rest.Repo;

import com.butcher.app.rest.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<User, Long> {
    List<User> findByFirstName(String firstName);
}
