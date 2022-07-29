package person;

import json.ReadingJson;
import json.RecordJson;


public class UserPerson {
    private String namePerson;
    private String idPerson;
    private String groupNamePerson;
    private String groupIdPerson;


    public PersonRecord personRecord = new RecordJson(
            "photoTelegramBot/src/main/resources/id_person_json.js",
            "photoTelegramBot/src/main/resources/id_group_json.js");

    public PersonReading personReading = new ReadingJson();

    public UserPerson() {
    }

    public UserPerson(PersonRecord personRecord, PersonReading personReading) {
        this.personRecord = personRecord;
        this.personReading = personReading;
    }


    public String getNamePerson() {
        return personReading.readingObject("person_id", idPerson, personRecord.getFileNamePerson());
    }

    public void setNameIdPerson(String namePerson, String idPerson) {
        personRecord.recordPerson(namePerson, idPerson);
        this.namePerson = namePerson;
        this.idPerson = idPerson;
    }

    public String getIdPerson() {
        return personReading.readingObject("person_id", namePerson, personRecord.getFileNamePerson());
    }


    public String getGroupNamePerson() {
        return personReading.readingObject("group_id", groupIdPerson, personRecord.getFileNameGroup());
    }

    public void setGroupNameIdPerson(String groupNamePerson, String groupIdPerson) {
        personRecord.recordGroup(groupNamePerson, groupIdPerson);
        this.groupNamePerson = groupNamePerson;
        this.groupIdPerson = groupIdPerson;
    }

    public String getGroupIdPerson() {
        return personReading.readingObject("group_id", groupNamePerson, personRecord.getFileNameGroup());
    }

}
