package dev.mateuszkowalczyk.puncher.repository;

import dev.mateuszkowalczyk.puncher.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
