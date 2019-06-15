package pl.itkontekst.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Wojciech Oczkowski on 2019-06-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc()
public class CustomerRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
//    private WebApplicationContext webApplicationContext;


//    @org.junit.Before
//    public void init(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .apply(SecurityMockMvcConfigurers.springSecurity())
//                .build();
//
//    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    public void testGetCustomersByAdmin() throws Exception {
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"lastName\":\"Kowalski\",\"firstName\":\"Jan\"}]"));
    }
    @Test
    @WithMockUser(username = "user",roles = "USER")
    public void testGetCustomersByUser() throws Exception {
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetCustomerById() throws Exception {

    }

    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    public void testSaveCustomer() throws Exception {
        mockMvc.perform(put("/customers")
                .content("{\"id\":2,\"lastName\":\"Nowak\",\"firstName\":\"Jan\"}")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @WithMockUser(username = "admin",roles = "ADMIN")
    public void testSaveCustomerWithoutId() throws Exception {
        mockMvc.perform(put("/customers")
                .content("{\"lastName\":\"Nowak\",\"firstName\":\"Jan\"}")
                .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}