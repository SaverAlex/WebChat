package com.example.WebChat;
import com.example.WebChat.domain.User;
import com.example.WebChat.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo userRepository;

    @Test
    public void findUserByName() {
        // given
        User user = new User("test", "test");
        entityManager.persist(user);
        entityManager.flush();

        // when
        User found = userRepository.findByUsername(user.getUsername());

        // then
        assertThat(found.getUsername())
                .isEqualTo(user.getUsername());
    }
}
