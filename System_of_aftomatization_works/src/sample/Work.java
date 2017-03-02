package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Vadim on 10.10.2016.
 */
public class Work {
    private StringProperty textOfWork;
    private StringProperty nomberOfWork;
    private StringProperty infoOfWork;
    private StringProperty idOfWork;

    public Work(){ this(null, null, null, null);}

    public Work(String textOfWork, String nomberOfWork, String infoOfWork, String idOfWork){
        this.textOfWork = new SimpleStringProperty(textOfWork);
        this.nomberOfWork = new SimpleStringProperty(nomberOfWork);
        this.infoOfWork = new SimpleStringProperty(infoOfWork);
        this.idOfWork = new SimpleStringProperty(idOfWork);
    }

    public String getTextOfWork() {
        return textOfWork.get();
    }

    public StringProperty textOfWorkProperty() {
        return textOfWork;
    }

    public void setTextOfWork(String textOfWork) {
        this.textOfWork.set(textOfWork);
    }

    public String getNomberOfWork() {
        return nomberOfWork.get();
    }

    public StringProperty nomberOfWorkProperty() {
        return nomberOfWork;
    }

    public void setNomberOfWork(String nomberOfWork) {
        this.nomberOfWork.set(nomberOfWork);
    }

    public String getInfoOfWork() {
        return infoOfWork.get();
    }

    public StringProperty infoOfWorkProperty() {
        return infoOfWork;
    }

    public void setInfoOfWork(String infoOfWork) {
        this.infoOfWork.set(infoOfWork);
    }

    public String getIdOfWork() {
        return idOfWork.get();
    }

    public StringProperty idOfWorkProperty() {
        return idOfWork;
    }

    public void setIdOfWork(String idOfWork) {
        this.idOfWork.set(idOfWork);
    }
}
