package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Vadim on 07.10.2016.
 */
public class Student {
    private final StringProperty firstNameStudent;
    private final StringProperty lastNameStudent;
    private final StringProperty seccondNameStudent;
    private final StringProperty studentID;
    private final StringProperty numberOfGrouph;



    public Student() {
        this(null, null, null, null, null);
    }


    public Student(String firstNameStudent, String lastNameStudent, String seccondNameStudent, String studentID, String numberOfGrouph){
        this.firstNameStudent = new SimpleStringProperty(firstNameStudent);
        this.lastNameStudent = new SimpleStringProperty(seccondNameStudent);
        this.seccondNameStudent = new SimpleStringProperty(lastNameStudent);
        this.studentID = new SimpleStringProperty(studentID);
        this.numberOfGrouph = new SimpleStringProperty(numberOfGrouph);
    }



    public String getFirstNameStudent() {
        return firstNameStudent.get();
    }

    public StringProperty firstNameStudentProperty() {
        return firstNameStudent;
    }

    public void setFirstNameStudent(String firstNameStudent) {
        this.firstNameStudent.set(firstNameStudent);
    }

    public String getLastNameStudent() {
        return lastNameStudent.get();
    }

    public StringProperty lastNameStudentProperty() {
        return lastNameStudent;
    }

    public void setLastNameStudent(String lastNameStudent) {
        this.lastNameStudent.set(lastNameStudent);
    }

    public String getSeccondNameStudent() {
        return seccondNameStudent.get();
    }

    public StringProperty seccondNameStudentProperty() {
        return seccondNameStudent;
    }

    public void setSeccondNameStudent(String seccondNameStudent) {
        this.seccondNameStudent.set(seccondNameStudent);
    }

    public String getStudentID() {
        return studentID.get();
    }

    public StringProperty studentIDProperty() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID.set(studentID);
    }

    public String getNumberOfGrouph() {
        return numberOfGrouph.get();
    }

    public StringProperty numberOfGrouphProperty() {
        return numberOfGrouph;
    }

    public void setNumberOfGrouph(String numberOfGrouph) {
        this.numberOfGrouph.set(numberOfGrouph);
    }
}
