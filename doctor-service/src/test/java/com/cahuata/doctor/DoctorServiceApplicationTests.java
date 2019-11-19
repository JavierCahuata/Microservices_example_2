package com.cahuata.doctor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cahuata.doctor.model.entity.Doctor;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DoctorServiceApplicationTests {
//ejecutar siguiente comando para la zona horaria de mysql SET GLOBAL time_zone = '+5:30'
	private MockMvc mvc;

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void test01add() throws Exception {
         String uri = "/add"; 
 
         Doctor review = new Doctor("Javier doctor 1", "callao", "pediatrics");	      		                        
         
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
         String uri = "/list";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Doctor[] doctorist = objectMapper.readValue(content, Doctor[].class);                 
         assertTrue(doctorist.length > 0);
         assertNotNull(mvcResult.getResponse().getContentAsString());

     }
    
    @Test
    public void test03findById() throws Exception {
         String uri = "/find/1";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Doctor doctor = objectMapper.readValue(content, Doctor.class);
         assertTrue(doctor.getId()==1);
     }
    @Test
    public void test04findByCityAndSpecialty() throws Exception {
         String uri = "/findByCityAndSpecialty/callao/pediatrics";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Doctor[] reviewlist = objectMapper.readValue(content, Doctor[].class);                 
         assertTrue(reviewlist.length > 0);
         assertNotNull(mvcResult.getResponse().getContentAsString());
     }
    
    @Test
    public void test05findByPatientDni() throws Exception {
         String uri = "/findByDoctorId/1/with-rating";
         mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
         
         MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                     .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

         int status = mvcResult.getResponse().getStatus();
         assertEquals(200, status);
         String content = mvcResult.getResponse().getContentAsString();
         ObjectMapper objectMapper = new ObjectMapper();
         Doctor doctor = objectMapper.readValue(content, Doctor.class);
         assertTrue(doctor.getId()==1);
     }

}
