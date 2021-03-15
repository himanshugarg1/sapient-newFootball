package com.sapient.football;

import com.sapient.football.api.client.APIFootball;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class FootballApplicationTests {

	@Test
	void contextLoads() {
	}

//	@InjectMocks
//	RestTemplate restTemplate;

	@Test
	public void testAPIFootbool() {
		APIFootball api = new APIFootball(new RestTemplate());
		System.out.println(api.getStandings("148"));

	}

}
