package com.casechek.sprint_tools;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
class CapacityCalculatorJsonTest {

    @Autowired
    private JacksonTester<CapacityCalculator> json;

    @Test
    void capacityCalculatorSerializationTest() throws IOException {
        CapacityCalculator capacityCalculator = new CapacityCalculator("full stack alchemists", 9,
                0, 5, 10, 22.0F);
        assertEquals(capacityCalculator.holidays(), 0);
        assertThat(json.write(capacityCalculator)).isStrictlyEqualToJson("/expected_team_data.json");
        assertThat(json.write(capacityCalculator)).hasJsonPathStringValue("@.teamName");
        assertThat(json.write(capacityCalculator)).extractingJsonPathStringValue("@.teamName")
                .isEqualTo("full stack alchemists");
        assertThat(json.write(capacityCalculator)).hasJsonPathNumberValue("@.daysInSprint");
        assertThat(json.write(capacityCalculator)).extractingJsonPathNumberValue("@.daysInSprint")
                .isEqualTo(9);
        assertThat(json.write(capacityCalculator)).hasJsonPathNumberValue("@.holidays");
        assertThat(json.write(capacityCalculator)).extractingJsonPathNumberValue("@.holidays")
                .isEqualTo(0);
        assertThat(json.write(capacityCalculator)).hasJsonPathNumberValue("@.developerCount");
        assertThat(json.write(capacityCalculator)).extractingJsonPathNumberValue("@.developerCount")
                .isEqualTo(5);
        assertThat(json.write(capacityCalculator)).hasJsonPathNumberValue("@.ptoTotal");
        assertThat(json.write(capacityCalculator)).extractingJsonPathNumberValue("@.ptoTotal")
                .isEqualTo(10);
        assertThat(json.write(capacityCalculator)).hasJsonPathNumberValue("@.averageVelocity");
        assertThat(json.write(capacityCalculator)).extractingJsonPathNumberValue("@.averageVelocity")
                .isEqualTo(22.0);
    }

    @Test
    void capacityCalculatorDeserializationTest() throws IOException {
        String expected = """
                {
                  "teamName": "full stack alchemists",
                  "daysInSprint": 9,
                  "holidays": 0,
                  "developerCount": 5,
                  "ptoTotal": 10,
                  "averageVelocity": 22.0
                }
                """;
        assertThat(json.parse(expected))
                .isEqualTo(new CapacityCalculator("full stack alchemists", 9,
                        0, 5, 10, 22.0F));
        assertThat(json.parseObject(expected).teamName()).isEqualTo("full stack alchemists");
        assertThat(json.parseObject(expected).daysInSprint()).isEqualTo(9);
    }
}