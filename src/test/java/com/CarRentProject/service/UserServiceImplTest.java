package com.CarRentProject.service;

import com.CarRentProject.models.User;
import com.CarRentProject.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UsersServiceImpl usersService;

    @Test
    public void shouldSaveUserInRepository() {
        //given
        User user = new User();

        //when
        usersService.saveUser(user);

        //then
        BDDMockito.then(userRepository).should().save(user);
    }

    @Test
    public void shouldGetListOfAllUsers(){
        //given


    }

    @Test
    public void shouldGetUserByName(){
        //given
        User user = new User("Edek", "ABC", "pppppppp", "EkekABC");

        //when
        User result = usersService.getUsersByName("Andrzej");

        //then
        BDDMockito.then(userRepository).should().findByName("Andrzej");
    }
}
