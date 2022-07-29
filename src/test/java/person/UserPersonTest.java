package person;

import json.ReadingJson;
import json.RecordJson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserPersonTest {

    UserPerson userPerson;

    @BeforeEach
    void setUp() {
        PersonReading personReading = new ReadingJson();
        PersonRecord personRecord = new RecordJson(
                "src/main/resources/id_person_json.js",
                "src/main/resources/id_group_json.js");
        userPerson = new UserPerson(personRecord,personReading);
        userPerson.setNameIdPerson("mikolaradfar","1062143182");
        userPerson.setGroupNameIdPerson("TelegrabWzaim","-1001369022257");
    }

    @Test
    void getNamePerson() {
        assertEquals("mikolaradfar",userPerson.getNamePerson());
    }

    @Test
    void getIdPerson() {
        assertEquals("1062143182",userPerson.getIdPerson());
    }

    @Test
    void getGroupNamePerson() {
        assertEquals("TelegrabWzaim",userPerson.getGroupNamePerson());
    }

    @Test
    void getGroupIdPerson() {
        assertEquals("-1001369022257",userPerson.getGroupIdPerson());
    }
}