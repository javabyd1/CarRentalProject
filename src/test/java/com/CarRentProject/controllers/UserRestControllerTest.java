package com.CarRentProject.controllers;

import com.CarRentProject.models.User;
import com.CarRentProject.service.UsersServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRestController.class)
public class UserRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UsersServiceImpl usersService;

    @Test
    public void shouldGetUsersList() throws Exception {

        User newUser = new User("Adam", "Kowalski", "adamkowalski", "AdamK");
        List<User> allUsers = Arrays.asList(newUser);

        given(usersService.getAllUsers()).willReturn(allUsers);

        this.mvc.perform(get("/users").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andExpect(content().string("[{\"id\":null,\"name\":\"Adam\",\"lastname\":\"Kowalski\",\"password\":\"adamkowalski\",\"active\":0,\"userLogin\":\"AdamK\",\"rolesSet\":null,\"listCar\":null}]"));
    }

}
