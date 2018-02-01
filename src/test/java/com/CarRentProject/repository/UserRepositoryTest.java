package com.CarRentProject.repository;

import com.CarRentProject.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;

    @Test
    public void shouldReturnUser() {
        //given
        User givenUser = new User("Marek", "Kafarek");
        entityManager.persist(givenUser);
        entityManager.flush();

        //when
        User found = userRepository.findByName(givenUser.getName());

        //then
        assertThat(found.getName()).isEqualTo(givenUser.getName());
    }
}
