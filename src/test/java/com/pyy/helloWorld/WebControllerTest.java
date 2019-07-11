//package com.pyy.helloWorld;
//
//import com.pyy.helloWorld.web.WebController;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//@SpringBootTest
//public class WebControllerTest {
//    private MockMvc mockMvc;
//
//    @Before
//    public void setUp() throws Exception {
//        mockMvc = MockMvcBuilders.standaloneSetup( new WebController() ).build();
//    }
//
//    @Test
//    public void getUser() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/getUser").accept(MediaType.APPLICATION_JSON_UTF8))
//                .andDo(print());
//    }
//
//    @Test
//    public void getUsers() throws Exception {
//        String resultString = mockMvc.perform(MockMvcRequestBuilders.post("/getUsers"))
//                .andReturn().getResponse().getContentAsString();
//        System.out.println("result = "+resultString);
//    }
//
//    @Test
//    public void saveUser() throws Exception{
//        mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
//        .param("name","")
//        .param("age","1222")
//        .param("pass","test"))
//
//                .andDo(print());
//
//    }
//
//}
