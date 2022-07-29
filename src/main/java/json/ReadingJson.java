package json;

import org.json.JSONObject;
import person.PersonReading;

import java.io.*;
import java.util.Objects;

public class ReadingJson implements PersonReading {
    private String name;
    private String fileName;
    private String object;

    public ReadingJson() {
    }

    public ReadingJson(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    public ReadingJson(String name, String fileName, String object) {
        this.name = name;
        this.fileName = fileName;
        this.object = object;
    }

    public String reading(String command, String fileName) {
        if (command!=null&&fileName!=null){
            setName(command);
            setFileName(fileName);
        }
        JSONObject jsonObject = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileName()));
            String s;
            while ((s = bufferedReader.readLine())!=null){
                jsonObject = new JSONObject(s);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) Objects.requireNonNull(jsonObject).get(getName());
    }

    public String readingObject(String object,String name,String fileName) {
        if (object!=null&&name!=null&&fileName!=null){
            setObject(object);
            setName(name);
            setFileName(fileName);
        }
        JSONObject jsonObject = null;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(getFileName()))){
            String s;
            while ((s = bufferedReader.readLine())!=null){
                jsonObject = new JSONObject(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (String) Objects.requireNonNull(jsonObject).getJSONObject(getObject()).get(getName());
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        return fileName;
    }

    public String getObject() {
        return object;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
