package com.zosh.user.services.repository;

import com.zosh.user.services.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User , Long> {
}
