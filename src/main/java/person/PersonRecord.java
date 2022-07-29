package person;

public interface PersonRecord {
    void recordGroup(String idGroupName, String idGroup);
    void recordPerson(String idName, String idPerson);
    String getFileNamePerson();
    String getFileNameGroup();
}
