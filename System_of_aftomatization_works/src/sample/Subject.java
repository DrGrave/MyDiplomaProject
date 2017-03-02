package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Vadim on 10.10.2016.
 */
public class Subject {
    private StringProperty subjectName;
    private StringProperty subjectID;

    public Subject(){ this(null, null);}
    public Subject(String subjectName, String subjectID){
        this.subjectName = new SimpleStringProperty(subjectName);
        this.subjectID = new SimpleStringProperty(subjectID);
    }

    public String getSubjectName() {
        return subjectName.get();
    }

    public StringProperty subjectNameProperty() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName.set(subjectName);
    }

    public String getSubjectID() {
        return subjectID.get();
    }

    public StringProperty subjectIDProperty() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID.set(subjectID);
    }
}
