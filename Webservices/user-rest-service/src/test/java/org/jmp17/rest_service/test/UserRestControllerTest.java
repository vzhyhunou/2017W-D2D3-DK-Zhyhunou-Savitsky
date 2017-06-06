package org.jmp17.rest_service.test;

import org.jmp17.rest_service.data.UserRepository;
import org.jmp17.rest_service.exception.UserNotFoundException;
import org.jmp17.rest_service.model.User;
import org.jmp17.rest_service.test.config.WebAppContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by asavitsky on 25.4.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebAppContext.class})
@WebAppConfiguration
public class UserRestControllerTest{
    MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void getAllUsers_UsersFound_ShouldReturnUsers() throws Exception {
        User user1 = new User(
               1L,
               "UserName1",
               "Login1",
               "email1"
        );
        User user2 = new User(
               2L,
               "UserName2",
               "Login2",
               "email2"
        );

        List<User> users = new ArrayList<>(Arrays.asList(user1, user2));
        when(userRepository.findAll()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(users.size())))
                .andExpect(jsonPath("$[0].id", is(Math.toIntExact(user1.getId()))))
                .andExpect(jsonPath("$[0].name", is(user1.getName())))
                .andExpect(jsonPath("$[0].login", is(user1.getLogin())))
                .andExpect(jsonPath("$[0].email", is(user1.getEmail())))
                .andExpect(jsonPath("$[1].id", is(Math.toIntExact(user2.getId()))))
                .andExpect(jsonPath("$[1].name", is(user2.getName())))
                .andExpect(jsonPath("$[1].login", is(user2.getLogin())))
                .andExpect(jsonPath("$[1].email", is(user2.getEmail())));

        verify(userRepository, only()).findAll();
    }

    @Test
    public void getUser_Found_ShouldReturnUser() throws Exception {
        User user = new User(
                1L,
                "UserName1",
                "Login1",
                "email1"
        );

        when(userRepository.findOne(user.getId())).thenReturn(user);

        mockMvc.perform(get("/users/"+user.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(Math.toIntExact(user.getId()))))
                .andExpect(jsonPath("$.name", is(user.getName())))
                .andExpect(jsonPath("$.login", is(user.getLogin())))
                .andExpect(jsonPath("$.email", is(user.getEmail())));

        verify(userRepository, only()).findOne(anyLong());
    }

    @Test
    public void getUser_NotFound404()
      throws Exception
    {
        when(userRepository.findOne(anyLong())).thenReturn(null);

        mockMvc.perform(get("/users/"+anyLong()))
                .andExpect(status().isNotFound());

        verify(userRepository, only()).findOne(anyLong());
    }

    @Before
    public void setUp() {
        Mockito.reset(userRepository);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
}
