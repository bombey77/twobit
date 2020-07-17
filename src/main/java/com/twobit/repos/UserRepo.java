package com.twobit.repos;

import com.twobit.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

    User findUserByUserName(String name);
}
