package command;

import json.ReadingJson;
import org.telegram.telegrambots.meta.api.objects.Update;
import person.UserPerson;

public class CommandPhotoLoadingPhoto {

    private boolean b;

    private  ReadingJson readingJson = new ReadingJson();
    private final String nameFileJson = "src/main/resources/json.js";
    private final String command_loading_photo = readingJson.reading("command2", nameFileJson);


    public void commandLoadingPhoto(Update update,String idPerson){
        if (update.getMessage().getText().equals(command_loading_photo)&&update.getMessage().getFrom().getId().equals(
                Long.parseLong(idPerson)
        )) {
            setB(true);
        }
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }
}

