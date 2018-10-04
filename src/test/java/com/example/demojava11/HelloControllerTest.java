package com.example.demojava11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class HelloControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void hello() {
        String response = restTemplate.getForObject("/", String.class);
        assertThat(response).isEqualTo("Hello Java 11!");
    }
}