package photo_file;

import org.telegram.telegrambots.meta.api.objects.Document;
import org.telegram.telegrambots.meta.api.objects.Update;

public class PhotoDocument {

    private final Update update;
    private final String token;

    public PhotoFile photoFile;
    public Document document;

    public PhotoDocument(Update update, String token) {
        this.update = update;
        this.token = token;
    }


    public void getPhotoDocument(){
         document = getUpdate().getMessage().getDocument();
        if (document !=null){
            String fileId = document.getFileId();
            String fileName = document.getFileName();
            photoFile = new PhotoFile(fileId, fileName, getToken());
            photoFile.uploadFile();
        }
    }

    public Update getUpdate() {
        return update;
    }

    public String getToken() {
        return token;
    }
}
