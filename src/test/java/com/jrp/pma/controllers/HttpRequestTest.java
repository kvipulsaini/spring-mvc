//package com.jrp.pma.controllers;
//
//import com.pma.PmaApplication;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.assertEquals;
//@ContextConfiguration(classes= PmaApplication.class)
//@RunWith(SpringRunner.class)
//@DataJpaTest
////@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class HttpRequestTest {
//    @LocalServerPort
//    private int port = 8085;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Test
//    public void homePageReturnsVersionNumberCorrectly_thenSuccess(){
//        String renderedHtml = this.restTemplate.getForObject("http://localhost:"+port+"/", String.class);
//        assertEquals(renderedHtml.contains("3.0.0"),true);
//    }
//
//}
