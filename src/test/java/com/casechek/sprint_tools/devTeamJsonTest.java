package com.casechek.sprint_tools;

import com.casechek.sprint_tools.persistence.entity.DevTeam;
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
    private JacksonTester<DevTeam> json;

    @Test
    void devTeamSerializationTest() throws IOException {
        DevTeam devTeam = new DevTeam("full stack alchemists", 9,
                0, 5, 10, 22.0F);
        assertEquals(devTeam.getHolidays(), 0);
        assertThat(json.write(devTeam)).isStrictlyEqualToJson("/expected_team_data.json");
        assertThat(json.write(devTeam)).hasJsonPathStringValue("@.teamName");
        assertThat(json.write(devTeam)).extractingJsonPathStringValue("@.teamName")
                .isEqualTo("full stack alchemists");
        assertThat(json.write(devTeam)).hasJsonPathNumberValue("@.daysInSprint");
        assertThat(json.write(devTeam)).extractingJsonPathNumberValue("@.daysInSprint")
                .isEqualTo(9);
        assertThat(json.write(devTeam)).hasJsonPathNumberValue("@.holidays");
        assertThat(json.write(devTeam)).extractingJsonPathNumberValue("@.holidays")
                .isEqualTo(0);
        assertThat(json.write(devTeam)).hasJsonPathNumberValue("@.developerCount");
        assertThat(json.write(devTeam)).extractingJsonPathNumberValue("@.developerCount")
                .isEqualTo(5);
        assertThat(json.write(devTeam)).hasJsonPathNumberValue("@.ptoTotal");
        assertThat(json.write(devTeam)).extractingJsonPathNumberValue("@.ptoTotal")
                .isEqualTo(10);
        assertThat(json.write(devTeam)).hasJsonPathNumberValue("@.averageVelocity");
        assertThat(json.write(devTeam)).extractingJsonPathNumberValue("@.averageVelocity")
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
                .isEqualTo(new DevTeam("full stack alchemists", 9,
                        0, 5, 10, 22.0F));
        assertThat(json.parseObject(expected).getTeamName()).isEqualTo("full stack alchemists");
        assertThat(json.parseObject(expected).getDaysInSprint()).isEqualTo(9);
    }
}