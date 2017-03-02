package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.*;


public class StudentStrController {

    @FXML private TextArea textOfWorkStudentLable;
    @FXML private TextArea textOfWorkAddProfessor;
    @FXML private TextArea recensionFieldStudent;
    @FXML private TextArea wrongFieldStudent;
    @FXML private TextArea recensionLableProfessor;
    @FXML private TextArea wrongLableProfessor;
    @FXML private ChoiceBox<?> expektedMark;
    @FXML private Tab Queue;
    @FXML private Tab loginTab;
    @FXML private Tab professorQueueTab;
    @FXML private Tab marksTab;
    @FXML private Tab professorsTab;
    @FXML private Tab watchWarksTab;
    @FXML private Tab addWorkTab;
    @FXML private Tab studentQueueForProfessor;
    @FXML private ChoiceBox<?> Work;
    @FXML private ChoiceBox<?> NumberOfWorks;
    @FXML private TabPane mainTab;
    @FXML private TextField studentName;
    @FXML private TextField studentSurname;
    @FXML private TextField studentSeccondname;
    @FXML private TextField studentNumberOfGrouph;
    @FXML private TextField loginField;
    @FXML private TableView<Professor> tableView;
    @FXML private TableView<Marks> tableOfMarks;
    @FXML private TableView<Student> tableOfQueueOfStudent;
    @FXML private TableView<Student> recensionStudentQueue;
    @FXML private TableView<Student> tableOfQueueProfessor;
    @FXML private TableView<Student> tableOfRecensionProfessor;
    @FXML private TableView<Work> watchWorksNumberStudent;
    @FXML private TableView<Subject> tableSubjectProfessor;
    @FXML private TableView<Work> tableWorkProfessor;
    @FXML private TableView<Subject> watchWorksStudentSubject;
    @FXML private TableColumn<Professor, String> firstNameColumn;
    @FXML private TableColumn<Professor, String> lastNameColumn;
    @FXML private TableColumn<Subject, String> subjectCollomWorks;
    @FXML private TableColumn<Work, String> numberCollomWorksStudent;
    @FXML private TableColumn<Work, String> infoWorksCollomStudent;
    @FXML private TableColumn<Subject, String> subjectNameCollomProfessor;
    @FXML private TableColumn<Work, String> subjectNumberCollomProfessor;
    @FXML private TableColumn<Work, String> subjectInfoCollomProfessor;
    @FXML private TableColumn<Marks, String> subjectCollom;
    @FXML private TableColumn<Marks, String> mark1collom;
    @FXML private TableColumn<Marks, String> mark2collom;
    @FXML private TableColumn<Marks, String> mark3collom;
    @FXML private TableColumn<Marks, String> mark4collom;
    @FXML private TableColumn<Marks, String> mark5collom;
    @FXML private TableColumn<Marks, String> mark6collom;
    @FXML private TableColumn<Marks, String> mark7collom;
    @FXML private TableColumn<Marks, String> mark8collom;
    @FXML private TableColumn<Marks, String> mark9collom;
    @FXML private TableColumn<Marks, String> mark10collom;
    @FXML private TableColumn<Student, String> firstNamePersonInQueueOfProfessor;
    @FXML private TableColumn<Student, String> seccondNAmeOfStudentInQueue;
    @FXML private TableColumn<Student, String> firstNameOfStudentRecensed;
    @FXML private TableColumn<Student, String> seccondNameOfStudentRecensed;
    @FXML private TableColumn<Student, String> firstNameStudentInQueue;
    @FXML private TableColumn<Student, String> seccondNameStudentInQueue;
    @FXML private TableColumn<Student, String> fristNameStudentInQueueSeccond;
    @FXML private TableColumn<Student, String> seccondNameStudentInQueueSeccond;
    @FXML private TableColumn<Student, String> styleCollomProfQueue;
    @FXML private TableColumn<Student, String> subjectStudentCell;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButtonFalse;
    @FXML private Button stayInQueueButton;
    @FXML private Button accaptButtonRecFalse;
    @FXML private Button deccaptButtonFalse;
    @FXML private Button changeDateButtonFalse;
    @FXML private Button accaptDateButtonFalse;
    @FXML private Label nameLableStudent;
    @FXML private Label surnameLableStudent;
    @FXML private Label seccondNamelableStudent;
    @FXML private Label numberOfgrouphLable;
    @FXML private Label nameOfStudentRecensionLable;
    @FXML private Label recomendedMarkLableProfessor;
    @FXML private Label professorName;
    @FXML private Label Surname;
    @FXML private Label Seccondname;
    @FXML private Label AllowTime;
    @FXML private Label TimeToLab;
    @FXML private Label numberOfWorkStudentLable;
    @FXML private Label numberOfWorkProfessor;
    @FXML private Label Name;
    @FXML private Label loginLable;
    @FXML private Label passwordLable;
    @FXML private Label incorrectLogPass;
    @FXML private ChoiceBox<?> realMarkProfessor;

    private ObservableList marks = FXCollections.observableArrayList('1', '2', '3', '4', '5', '6', '7', '8', '9', "10");
    private Student iStudent;
    private Main main;
    private Professor iProfessor;

    @FXML
    void loginButton(ActionEvent event) {
        iStudent = new Student();
        iProfessor = new Professor();
        int prof = main.ifIPRofessor(loginField.getText(), passwordField.getText());
        if (prof == 0){
        iStudent = (Student) main.login(loginField.getText(), passwordField.getText());
            if (iStudent != null){
                initializeMarksTable(main.getMarks(iStudent));
                enableVisibleStudent(true, iStudent);
                initializeProfessorQueue();
                initializeWatchWorksList();
                incorrectLogPass.setVisible(true);
            }
        } if (prof == 1) {
            iProfessor = (Professor) main.login(loginField.getText(), passwordField.getText());
            if (iProfessor != null){
                enableVisibleProffesor(true, iProfessor);
                professorQueueInitialize(iProfessor);
                professorAddWorkInitialize(iProfessor);
                incorrectLogPass.setVisible(true);
            }
        }else {
            incorrectLogPass.setVisible(true);
        }


    }

    private void professorQueueInitialize(Professor iProfessor){
        tableOfQueueProfessor.setItems(main.getStudentsListInQueue());
        seccondNAmeOfStudentInQueue.setCellValueFactory(
                cellData -> cellData.getValue().seccondNameStudentProperty()
        );

        firstNamePersonInQueueOfProfessor.setCellValueFactory(
                cellData -> cellData.getValue().firstNameStudentProperty()
        );
        tableOfQueueProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setSirdColllomStudentInQueueProfessor(newValue));

    }

    private void setSirdColllomStudentInQueueProfessor(Student student) {
        tableOfRecensionProfessor.getItems().clear();
        tableOfRecensionProfessor.setItems(main.getStudentsForRecensionQueue(student));
        seccondNameOfStudentRecensed.setCellValueFactory(
                callData -> callData.getValue().seccondNameStudentProperty()
        );
        firstNameOfStudentRecensed.setCellValueFactory(
                cellData -> cellData.getValue().firstNameStudentProperty()
        );
        tableOfRecensionProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setRecensionForStudentCheckProfessor(newValue));
    }

    private void setRecensionForStudentCheckProfessor(Student newValue) {
        nameOfStudentRecensionLable.setText(tableOfRecensionProfessor.selectionModelProperty().getName());
        recensionLableProfessor.setText("gwf");
        wrongLableProfessor.setText("fwe");
        recomendedMarkLableProfessor.setText("10");
    }

    private void professorAddWorkInitialize(Professor iProfessor) {
        tableSubjectProfessor.setItems(main.getSubjectListForProfessor(iProfessor));
        subjectNameCollomProfessor.setCellValueFactory(
                cellData -> cellData.getValue().subjectNameProperty());
        tableSubjectProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showWorksForSubjectProfessor(newValue)
        );
    }

    private void showWorksForSubjectProfessor(Subject iSubject) {
        tableWorkProfessor.setItems(main.getWorksForStudent(iSubject));
        subjectNumberCollomProfessor.setCellValueFactory(
                cellData -> cellData.getValue().nomberOfWorkProperty());
        subjectInfoCollomProfessor.setCellValueFactory(
                cellData -> cellData.getValue().infoOfWorkProperty());
        tableWorkProfessor.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showWorksInfoProfessor(newValue)
        );
    }

    private void showWorksInfoProfessor(Work iWork) {
        textOfWorkAddProfessor.setText(iWork.getTextOfWork());
        numberOfWorkProfessor.setText(iWork.getIdOfWork());
    }

    private void enableVisibleProffesor(boolean b, Professor iProfessor) {
        addWorkTab.setDisable(false);
        professorQueueTab.setDisable(false);
        loginButtonFalse.setVisible(false);
        loginField.setVisible(false);
        loginLable.setVisible(false);
        seccondNamelableStudent.setVisible(true);
        passwordField.setVisible(false);
        passwordLable.setVisible(false);
        nameLableStudent.setVisible(true);
        surnameLableStudent.setVisible(true);
        studentName.setVisible(true);
        studentName.setText(iProfessor.getFirstName());
        studentSeccondname.setVisible(true);
        studentSeccondname.setText(iProfessor.getSeccondName());
        studentSurname.setVisible(true);
        studentSurname.setText(iProfessor.getLastName());
        studentNumberOfGrouph.setText(iProfessor.getTime());
        loginTab.setText("Owerwiew");
        mainTab.getTabs().add(professorQueueTab);
        mainTab.getTabs().add(addWorkTab);
    }

    @FXML
    void changeDateButton(ActionEvent event) {

    }

    @FXML
    void accaptDateButton(ActionEvent event) {

    }

    @FXML
    void deceptButton(ActionEvent event) {
        // leave from queue
        deccaptButtonFalse.setDisable(true);
        accaptButtonRecFalse.setDisable(false);
    }

    @FXML
    void infoOfQueue(ActionEvent event) {

    }

    @FXML
    void accaptRecButton(ActionEvent event) {
        String recension = recensionFieldStudent.getText();
        String wrong = wrongFieldStudent.getText();
        int mark = Integer.parseInt(expektedMark.getSelectionModel().getSelectedItem().toString());

        if (recension.isEmpty() || wrong.isEmpty() || recension.equals("Yuo must write recension") || wrong.equals("You must write wrong")){
            if (recension.isEmpty() || recension.equals("Yuo must write recension")){
                recensionFieldStudent.setText("Yuo must write recension");
            }
            if (wrong.isEmpty() || wrong.equals("You must write wrong")){
                wrongFieldStudent.setText("You must write wrong");
            }
        }else {
            main.sendMyRecensionToServer(tableOfQueueOfStudent.getSelectionModel().getSelectedItem(), recension, wrong, mark);
            accaptButtonRecFalse.setDisable(true);
            deccaptButtonFalse.setDisable(false);
        }

    }

    @FXML
    void leaveFromQueue(ActionEvent event) {
        Queue.setDisable(true);
        stayInQueueButton.setDisable(false);
        //updateBD
    }

    @FXML
    void stayInQueue(ActionEvent event) {
        if (professorName.getText() != null) {
            Queue.setDisable(false);
            SingleSelectionModel<Tab> selectionModel = mainTab.getSelectionModel();
            selectionModel.select(Queue);
            String name = " " + Name.getText() + " " + Surname.getText();
            professorName.setText(name);
            stayInQueueButton.setDisable(true);
            expektedMark.setItems(marks);
            setFirstCollomStudentInQueue(main.getStudentsListInQueue());
        }
        else {

        }
    }
    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public StudentStrController() {
    }
    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        mainTab.getTabs().remove(professorQueueTab);
        mainTab.getTabs().remove(addWorkTab);
        mainTab.getTabs().remove(professorsTab);
        mainTab.getTabs().remove(marksTab);
        mainTab.getTabs().remove(watchWarksTab);
        mainTab.getTabs().remove(Queue);
    }
    /**
     * @param mainApp
     */
    public void setMainApp(Main mainApp) {
        this.main = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка

    }
    /**
     * Заполняет все текстовые поля, отображая подробности об адресате.
     * Если указанный адресат = null, то все текстовые поля очищаются.
     *
     * @param person — адресат типа Person или null
     */

    private void showPersonDetails(Professor person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.

            Name.setText(person.getFirstName());
            Seccondname.setText(person.getLastName());
            Surname.setText(person.getSeccondName());
            Work.setItems(person.getCursors());
            NumberOfWorks.setItems(person.getWork());
            AllowTime.setText(person.getTime());
            TimeToLab.setText(person.getTimetosdat());
        } else {
            // Если Person = null, то убираем весь текст.
            Name.setText("");
            Seccondname.setText("");
        }
    }

    private void enableVisibleStudent(boolean isOk, Student student){
        if (isOk = true){

            loginButtonFalse.setVisible(false);
            loginField.setVisible(false);
            loginLable.setVisible(false);
            passwordField.setVisible(false);
            passwordLable.setVisible(false);
            nameLableStudent.setVisible(true);
            surnameLableStudent.setVisible(true);
            seccondNamelableStudent.setVisible(true);
            studentNumberOfGrouph.setVisible(true);
            numberOfgrouphLable.setVisible(true);
            studentName.setVisible(true);
            studentName.setText(student.getFirstNameStudent());
            studentSeccondname.setVisible(true);
            studentSeccondname.setText(student.getSeccondNameStudent());
            studentSurname.setVisible(true);
            studentSurname.setText(student.getLastNameStudent());
            studentNumberOfGrouph.setText(student.getNumberOfGrouph());
            changeDateButtonFalse.setVisible(true);
            accaptDateButtonFalse.setVisible(true);
            accaptDateButtonFalse.setDisable(true);
            professorsTab.setDisable(false);
            marksTab.setDisable(false);
            watchWarksTab.setDisable(false);
            loginTab.setText("Owerwiew");
            mainTab.getTabs().add(Queue);
            mainTab.getTabs().add(professorsTab);
            mainTab.getTabs().add(marksTab);
            mainTab.getTabs().add(watchWarksTab);
        }else {
            //do sumsing if wrong
        }
    }

    private void initializeMarksTable(ObservableList<Marks> list){
        tableOfMarks.setItems(list);
        subjectCollom.setCellValueFactory(
                cellData -> cellData.getValue().subjectNameProperty()
        );
        mark1collom.setCellValueFactory(
                cellData -> cellData.getValue().firstMarkProperty()
        );
        mark2collom.setCellValueFactory(
                cellData -> cellData.getValue().seccondMarkProperty()
        );
        mark3collom.setCellValueFactory(
                cellData -> cellData.getValue().sirdMarkProperty()
        );
        mark4collom.setCellValueFactory(
                cellData -> cellData.getValue().fourthMarkProperty()
        );
        mark5collom.setCellValueFactory(
                cellData -> cellData.getValue().fifthMarkProperty()
        );
        mark6collom.setCellValueFactory(
                cellData -> cellData.getValue().sixMarkProperty()
        );
        mark7collom.setCellValueFactory(
                cellData -> cellData.getValue().sevenMArkProperty()
        );
        mark8collom.setCellValueFactory(
                cellData -> cellData.getValue().eightMarkProperty()
        );
        mark9collom.setCellValueFactory(
                cellData -> cellData.getValue().nineMarkProperty()
        );
        mark10collom.setCellValueFactory(
                cellData -> cellData.getValue().tenMarkProperty()
        );
    }

    private void setFirstCollomStudentInQueue(ObservableList<Student> studentList){
        tableOfQueueOfStudent.setItems(studentList);
        seccondNameStudentInQueue.setCellValueFactory(
                callData -> callData.getValue().seccondNameStudentProperty()
        );
        firstNameStudentInQueue.setCellValueFactory(
                cellData -> cellData.getValue().firstNameStudentProperty()
        );
        tableOfQueueOfStudent.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setSirdColllomStudentInQueue(newValue));

    }

    private void setSirdColllomStudentInQueue(Student student){
        //getData by studentID
        accaptButtonRecFalse.setDisable(false);
        deccaptButtonFalse.setDisable(true);

        recensionStudentQueue.getItems().clear();
        recensionStudentQueue.setItems(main.getStudentsForRecensionQueue(student));
        seccondNameStudentInQueueSeccond.setCellValueFactory(
                callData -> callData.getValue().seccondNameStudentProperty()
        );
        fristNameStudentInQueueSeccond.setCellValueFactory(
                cellData -> cellData.getValue().firstNameStudentProperty()
        );
        recensionStudentQueue.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> setRecensionForStudentCheck(newValue));
    }

    private void setRecensionForStudentCheck(Student student){
        accaptButtonRecFalse.setDisable(true);// если ид студента совпадает с вашим то посволить редактировани
        //если вашего ид нет в списке позволить создать рецензию.
//        if (students.contains(studentID)){
//            if (students.)
        recensionFieldStudent.setText("fff");
        recensionFieldStudent.setDisable(true);
        wrongFieldStudent.setText("wqwqe");
        wrongFieldStudent.setDisable(true);
//        }else {
//
//        }
    }

    private void initializeProfessorQueue(){
        tableView.setItems(main.getProfessorsQueue());
        // Инициализация таблицы адресатов с двумя столбцами.
        firstNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(
                cellData -> cellData.getValue().lastNameProperty());

        // Очистка дополнительной информации об адресате.
        showPersonDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    @FXML
    void InLastProfessorWork(ActionEvent event) {

    }

    @FXML
    void accaptProfessorWork(ActionEvent event) {

    }

    @FXML
    void deceptProfessorWork(ActionEvent event) {

    }

    @FXML
    void stayInQueueFromWatchWorks(ActionEvent event) {

    }

    private void initializeWatchWorksList(){
        watchWorksStudentSubject.setItems(main.getSubjectListForStudent(iStudent));
        subjectCollomWorks.setCellValueFactory(
                cellData -> cellData.getValue().subjectNameProperty());
        watchWorksStudentSubject.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showWorksForSubject(newValue)
        );
    }

    private void showWorksForSubject(Subject subject){
        watchWorksNumberStudent.setItems(main.getWorksForStudent(subject));
        numberCollomWorksStudent.setCellValueFactory(
                cellData -> cellData.getValue().nomberOfWorkProperty());
        infoWorksCollomStudent.setCellValueFactory(
                cellData -> cellData.getValue().infoOfWorkProperty());
        watchWorksNumberStudent.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue)-> showWorksInfo(newValue)
        );
    }

    private void showWorksInfo(Work work){
        textOfWorkStudentLable.setText(work.getTextOfWork());
        numberOfWorkStudentLable.setText(work.getNomberOfWork());
    }



}