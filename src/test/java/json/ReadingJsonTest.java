package json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ReadingJsonTest {

    public  ReadingJson readingJson;

    @BeforeEach
    public void setUp() {
         readingJson = new ReadingJson("1062143182","src/main/resources/id_person_json.js","person_id");
    }

    @ParameterizedTest
    @ValueSource(strings = {"command","command2","command3","command4","command5"})
    void reading(String command) {
        ReadingJson readingJson = new ReadingJson(command,"src/main/resources/json.js");
        assertNotNull(readingJson.reading(readingJson.getName(),readingJson.getFileName()));
    }

    @Test
    void readingObject() {
        assertNotNull(readingJson.readingObject(readingJson.getObject(),
                readingJson.getName(),readingJson.getFileName()));
    }

    @Test
    void getName() {
        assertEquals("1062143182",readingJson.getName());
    }

    @Test
    void getName2() {
        readingJson.setName("mikolakran");
        assertEquals("mikolakran",readingJson.getName());
    }

    @Test
    void getFileName() {
        assertEquals("src/main/resources/id_person_json.js",readingJson.getFileName());
    }

    @Test
    void getFileName2() {
        readingJson.setFileName("123dad");
        assertEquals("123dad",readingJson.getFileName());
    }

    @Test
    void getObject() {
        assertEquals("person_id",readingJson.getObject());
    }

    @Test
    void getObject2() {
        readingJson.setObject("id");
        assertEquals("id",readingJson.getObject());
    }
}