package json;

import org.json.JSONObject;
import person.PersonRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class RecordJson implements PersonRecord {
    private JSONObject jsonObject = null;
    private JSONObject jsonObject1 = null;
    private String fileNamePerson;
    private String fileNameGroup;

    public RecordJson(String fileNamePerson) {
        this.fileNamePerson = fileNamePerson;
    }

    public RecordJson(String fileNamePerson, String fileNameGroup) {
        this.fileNamePerson = fileNamePerson;
        this.fileNameGroup = fileNameGroup;
    }

    public void recordGroup(String idGroupName, String idGroup){
        jsonObject = new JSONObject();
        jsonObject.put(idGroupName, idGroup);
        jsonObject.put(idGroup, idGroupName);
        jsonObject1 = new JSONObject();
        jsonObject1.put("group_id",jsonObject);
        try {
            Files.write(Path.of(fileNameGroup), jsonObject1.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recordPerson(String idName, String idPerson){
        jsonObject = new JSONObject();
        jsonObject.put(idName, idPerson);
        jsonObject.put(idPerson, idName);
        jsonObject1 = new JSONObject();
        jsonObject1.put("person_id",jsonObject);
        try {
            Files.write(Path.of(fileNamePerson), jsonObject1.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getFileNamePerson() {
        return fileNamePerson;
    }

    @Override
    public String getFileNameGroup() {
        return fileNameGroup;
    }
}
