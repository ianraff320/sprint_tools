package com.casechek.sprint_tools;

import com.casechek.sprint_tools.persistence.entity.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@JsonTest
class devTeamJsonTest {

    @Autowired
    private JacksonTester<Team> json;

    @Test
    void devTeamSerializationTest() throws IOException {
        Team team = new Team("full stack alchemists"
        );
        assertEquals(team.getHolidays(), 0);
        assertThat(json.write(team)).isStrictlyEqualToJson("/expected_team_data.json");
        assertThat(json.write(team)).hasJsonPathStringValue("@.teamName");
        assertThat(json.write(team)).extractingJsonPathStringValue("@.teamName")
                .isEqualTo("full stack alchemists");
        assertThat(json.write(team)).hasJsonPathNumberValue("@.daysInSprint");
        assertThat(json.write(team)).extractingJsonPathNumberValue("@.daysInSprint")
                .isEqualTo(9);
        assertThat(json.write(team)).hasJsonPathNumberValue("@.holidays");
        assertThat(json.write(team)).extractingJsonPathNumberValue("@.holidays")
                .isEqualTo(0);
        assertThat(json.write(team)).hasJsonPathNumberValue("@.developerCount");
        assertThat(json.write(team)).extractingJsonPathNumberValue("@.developerCount")
                .isEqualTo(5);
        assertThat(json.write(team)).hasJsonPathNumberValue("@.ptoTotal");
        assertThat(json.write(team)).extractingJsonPathNumberValue("@.ptoTotal")
                .isEqualTo(10);
        assertThat(json.write(team)).hasJsonPathNumberValue("@.averageVelocity");
        assertThat(json.write(team)).extractingJsonPathNumberValue("@.averageVelocity")
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
                .isEqualTo(new Team("full stack alchemists"
                ));
        assertThat(json.parseObject(expected).getTeamName()).isEqualTo("full stack alchemists");
        assertThat(json.parseObject(expected).getDaysInSprint()).isEqualTo(9);
    }
}