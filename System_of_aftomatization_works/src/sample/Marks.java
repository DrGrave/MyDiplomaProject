package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Vadim on 07.10.2016.
 */
public class Marks {
    private final StringProperty subjectName;
    private final StringProperty firstMark;
    private final StringProperty seccondMark;
    private final StringProperty sirdMark;
    private final StringProperty fourthMark;
    private final StringProperty fifthMark;
    private final StringProperty sixMark;
    private final StringProperty sevenMArk;
    private final StringProperty eightMark;
    private final StringProperty nineMark;
    private final StringProperty tenMark;

    public Marks(){
        this(null,null,null,null,null,null,null,null,null,null,null);
    }

    public Marks(String subjectName, String firstMark, String seccondMark, String sirdMark, String fourthMark, String fifthMark, String sixMark, String sevenMArk, String eightMark, String nineMark, String tenMark){
        this.subjectName = new SimpleStringProperty(subjectName);
        this.firstMark = new SimpleStringProperty(firstMark);
        this.seccondMark = new SimpleStringProperty(seccondMark);
        this.sirdMark = new SimpleStringProperty(sirdMark);
        this.fourthMark = new SimpleStringProperty(fourthMark);
        this.fifthMark = new SimpleStringProperty(fifthMark);
        this.sixMark = new SimpleStringProperty(sixMark);
        this.sevenMArk = new SimpleStringProperty(sevenMArk);
        this.eightMark = new SimpleStringProperty(eightMark);
        this.nineMark = new SimpleStringProperty(nineMark);
        this.tenMark = new SimpleStringProperty(tenMark);
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

    public String getFirstMark() {
        return firstMark.get();
    }

    public StringProperty firstMarkProperty() {
        return firstMark;
    }

    public void setFirstMark(String firstMark) {
        this.firstMark.set(firstMark);
    }

    public String getSeccondMark() {
        return seccondMark.get();
    }

    public StringProperty seccondMarkProperty() {
        return seccondMark;
    }

    public void setSeccondMark(String seccondMark) {
        this.seccondMark.set(seccondMark);
    }

    public String getSirdMark() {
        return sirdMark.get();
    }

    public StringProperty sirdMarkProperty() {
        return sirdMark;
    }

    public void setSirdMark(String sirdMark) {
        this.sirdMark.set(sirdMark);
    }

    public String getFourthMark() {
        return fourthMark.get();
    }

    public StringProperty fourthMarkProperty() {
        return fourthMark;
    }

    public void setFourthMark(String fourthMark) {
        this.fourthMark.set(fourthMark);
    }

    public String getFifthMark() {
        return fifthMark.get();
    }

    public StringProperty fifthMarkProperty() {
        return fifthMark;
    }

    public void setFifthMark(String fifthMark) {
        this.fifthMark.set(fifthMark);
    }

    public String getSixMark() {
        return sixMark.get();
    }

    public StringProperty sixMarkProperty() {
        return sixMark;
    }

    public void setSixMark(String sixMark) {
        this.sixMark.set(sixMark);
    }

    public String getSevenMArk() {
        return sevenMArk.get();
    }

    public StringProperty sevenMArkProperty() {
        return sevenMArk;
    }

    public void setSevenMArk(String sevenMArk) {
        this.sevenMArk.set(sevenMArk);
    }

    public String getEightMark() {
        return eightMark.get();
    }

    public StringProperty eightMarkProperty() {
        return eightMark;
    }

    public void setEightMark(String eightMark) {
        this.eightMark.set(eightMark);
    }

    public String getNineMark() {
        return nineMark.get();
    }

    public StringProperty nineMarkProperty() {
        return nineMark;
    }

    public void setNineMark(String nineMark) {
        this.nineMark.set(nineMark);
    }

    public String getTenMark() {
        return tenMark.get();
    }

    public StringProperty tenMarkProperty() {
        return tenMark;
    }

    public void setTenMark(String tenMark) {
        this.tenMark.set(tenMark);
    }
}
