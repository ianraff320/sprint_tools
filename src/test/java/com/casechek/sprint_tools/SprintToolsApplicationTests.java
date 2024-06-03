package com.casechek.sprint_tools;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SprintToolsApplicationTests {
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnSprintDetailsWhenDataIsSaved() {
		ResponseEntity<String> response = restTemplate.getForEntity("/capacitycalcs/full stack alchemists",
				String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext documentContext = JsonPath.parse(response.getBody());
		String teamName = documentContext.read("$.teamName");
		assertThat(teamName).isEqualTo("full stack alchemists");

		Integer daysInSprint = documentContext.read("$.daysInSprint");
		assertThat(daysInSprint).isEqualTo(9);

		Integer holidays = documentContext.read("$.holidays");
		assertThat(holidays).isEqualTo(0);

		Integer developerCount = documentContext.read("$.developerCount");
		assertThat(developerCount).isEqualTo(5);

		Integer ptoTotal = documentContext.read("$.ptoTotal");
		assertThat(ptoTotal).isEqualTo(10);

		Double averageVelocity = documentContext.read("$.averageVelocity");
		assertThat(averageVelocity).isEqualTo(22.0F);
	}

	@Test
	void shouldNotReturnSprintDetailsWithAnUnknownId() {
		ResponseEntity<String> response = restTemplate.getForEntity("/capacitycalcs/swiftkeys", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	}

	@Test
	void shouldCreateNewSprintDetails() {
		CapacityCalculator newCapacityCalculator = new CapacityCalculator("full stack alchemists",
				9, 0, 5, 0, 22.0F);
		ResponseEntity<Void> createResponse = restTemplate.postForEntity("/capacitycalcs", newCapacityCalculator,
				Void.class);

		assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);

		URI locationOfNewCapacityCalculator = createResponse.getHeaders().getLocation();
		ResponseEntity<String> getResponse = restTemplate.getForEntity(locationOfNewCapacityCalculator, String.class);
		assertThat(getResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}