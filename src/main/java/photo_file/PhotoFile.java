package photo_file;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class PhotoFile {
    private  String id;
    private  String name;
    private  String token;

    private  URL url = null;

    public PhotoFile() {
    }

    public PhotoFile(String id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public void uploadFile() {
        try {
            url = new URL("https://api.telegram.org/bot"+getToken()+"/getFile?file_id="+getId());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String getFile = bufferedReader.readLine();

            JSONObject jsonObject = new JSONObject(getFile);
            JSONObject path = jsonObject.getJSONObject("result");
            String file_path = path.getString("file_path");

            File file = new File("photoTelegramBot/src/main/resources/upload_file/"+getName());
            InputStream inputStream = new URL("https://api.telegram.org/file/bot"+getToken()+"/"+file_path).openStream();

            FileUtils.copyInputStreamToFile(inputStream,file);

            bufferedReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteFile(){
        File file = new File("photoTelegramBot/src/main/resources/upload_file");
        boolean delete = false;
        if (file.isDirectory()){
            for (File file1: Objects.requireNonNull(file.listFiles())){
                delete = file1.delete();
            }
        }
        return delete;
    }

    public boolean deleteFileName(String nameFile){
        File file = new File("photoTelegramBot/src/main/resources/upload_file/"+nameFile);
        boolean delete = false;
        if (file.isFile()){
            delete = file.delete();
        }
        return delete;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
