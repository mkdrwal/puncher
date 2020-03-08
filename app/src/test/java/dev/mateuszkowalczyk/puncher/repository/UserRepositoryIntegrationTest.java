package dev.mateuszkowalczyk.puncher.repository;

import dev.mateuszkowalczyk.puncher.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsernameThenReturnUser() {
        User user = new User();
        user.setUsername("superAdmin");
        user.setPassword("xxxxxxxxxx");
        user.setEmail("admin@admin.com");

        this.entityManager.persist(user);
        this.entityManager.flush();

        User found = this.userRepository.findByUsername("superAdmin").get();

        assertEquals(user.getUsername(), found.getUsername());
    }

}
