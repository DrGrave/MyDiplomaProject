package sample;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Cursor;

import java.util.Collections;

/**
 * Created by Vadim on 04.10.2016.
 */
public class Professor {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty seccondName;
    private final StringProperty time;
    private final StringProperty timetosdat;



    ObservableList cursors = FXCollections.observableArrayList(
    );
   ObservableList work = FXCollections.observableArrayList();

    public Professor() {
        this(null, null, null, null, null, null, null);
    }
    public Professor(String firstName, String lastName, String seccondName, ObservableList cursor, ObservableList work , String time, String timetosdat) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.seccondName = new SimpleStringProperty(seccondName);
        this.cursors = cursor;
        this.work = work;
        this.time = new SimpleStringProperty(time);
        this.timetosdat = new SimpleStringProperty(timetosdat);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getTimetosdat() {
        return timetosdat.get();
    }

    public StringProperty timetosdatProperty() {
        return timetosdat;
    }

    public void setTimetosdat(String timetosdat) {
        this.timetosdat.set(timetosdat);
    }

    public ObservableList getWork() {
        return work;
    }

    public void setWork(ObservableList work) {
        this.work = work;
    }

    public ObservableList getCursors() {
        return cursors;
    }

    public void setCursors(ObservableList cursors) {
        this.cursors = cursors;
    }

    public String getSeccondName() {
        return seccondName.get();
    }

    public StringProperty seccondNameProperty() {
        return seccondName;
    }

    public void setSeccondName(String seccondName) {
        this.seccondName.set(seccondName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

}
