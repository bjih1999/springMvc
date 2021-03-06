package me.jihyun.springMVC.Controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    public void helloTest() throws Exception {
        mockMvc.perform(get("/hello-security"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    public void helloTestWithoutUser() throws Exception {
        mockMvc.perform(get("/hello-security"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser
    public void myTest() throws Exception {
        mockMvc.perform(get("/my-security"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("my"));

    }

    @Test
    public void myTestWithoutUser() throws Exception {
        mockMvc.perform(get("/my-security"))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }
}