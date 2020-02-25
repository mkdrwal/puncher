package dev.mateuszkowalczyk.puncher.repository;

import dev.mateuszkowalczyk.puncher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
