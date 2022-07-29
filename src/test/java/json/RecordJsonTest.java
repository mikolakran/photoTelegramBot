package json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RecordJsonTest {

    RecordJson recordJsonIdPerson;
    RecordJson recordJsonIdGroup;

    @BeforeEach
    public void setUp() {
        recordJsonIdPerson = new RecordJson("src/main/resources/id_person_json.js",
                "src/main/resources/id_group_json.js");
    }

    @Test
    void recordGroup() {

    }

    @Test
    void recordPerson() {
    }
}