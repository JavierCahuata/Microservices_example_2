package com.cahuata.review;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
//import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.context.WebApplicationContext;

import com.cahuata.review.model.entity.Review;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReviewServiceApplicationTests {

	private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void test01add() throws Exception {
         String uri = "/add"; 
 
         Review review = new Review(1L,"a good doctor with the child 1", "41257930", 4.5 ,new Date());	
         // Review(Long doctorId, String review_des, String patientDni, Double rate, Date createAt)      		                        
         
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         ObjectMapper objectMapper = new ObjectMapper();
                        
         String inputJson = objectMapper.writeValueAsString(review);
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
      	         .contentType(MediaType.APPLICATION_JSON_VALUE)
      	         .content(inputJson)).andReturn();
         
         int status = mvcResult.getResponse().getStatus();
         System.out.println("status" + status);
         assertEquals(200, status);
         
         
         String content = mvcResult.getResponse().getContentAsString();
         assertTrue(content.length()>0);
         
     }
    
    @Test
    public void test02findAll() throws Exception {
         String uri = "/review/list";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Review[] reviewlist = objectMapper.readValue(content, Review[].class);                 
         assertTrue(reviewlist.length > 0);
         assertNotNull(mvcResult.getResponse().getContentAsString());

     }
    
    @Test
    public void test03findById() throws Exception {
         String uri = "/review/find/1";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Review review = objectMapper.readValue(content, Review.class);
         assertTrue(review.getId()==1);
     }
    @Test
    public void test04findByDoctorId() throws Exception {
         String uri = "/review/findByDoctorId/1";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Review[] reviewlist = objectMapper.readValue(content, Review[].class);                 
         assertTrue(reviewlist.length > 0);
         assertNotNull(mvcResult.getResponse().getContentAsString());
     }
    
    @Test
    public void test05findByPatientDni() throws Exception {
         String uri = "/review/findByPatientDni/41257930";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Review[] reviewlist = objectMapper.readValue(content, Review[].class);                 
         assertTrue(reviewlist.length > 0);
         assertNotNull(mvcResult.getResponse().getContentAsString());

     }
}
