package sample;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controller.StudentStrController;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList predm = FXCollections.observableArrayList(
            "Miapr", "Siammod", "..."
    );
    private ObservableList work = FXCollections.observableArrayList(
            "1" , "2", "3", "4", "5", "6", "7", "8", "9", "10"
    );
    /**
     * Конструктор
     */
    public Main() {
        // В качестве образца добавляем некоторые данные


    }

    /**
     * Возвращает данные в виде наблюдаемого списка адресатов.
     * @return
     */

    public ObservableList<Professor> getProfessorsQueue() {
        ObservableList<Professor> personData = FXCollections.observableArrayList();
        personData.add(new Professor("Hans", "Muster", "re", predm, work, "5", "7"));
        personData.add(new Professor("Ruth", "Mueller", "re", predm, work, "6", "8"));
        personData.add(new Professor("Heinz", "Kurz", "re", predm, work, "7", "1"));
        personData.add(new Professor("Cornelia", "Meier", "re", predm, work, "2", "23"));
        return personData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Organization study process");

        initRootLayout();

        showPersonOverview();
    }

    /**
     * Инициализирует корневой макет.
     */

    private void initRootLayout() {
        try {
            // Загружаем корневой макет из fxml файла.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("fxml/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Отображаем сцену, содержащую корневой макет.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Показывает в корневом макете сведения об адресатах.
     */

    private void showPersonOverview() {
        try {
            // Загружаем сведения об адресатах.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("fxml/Student.fxml"));
            TabPane personOverview = (TabPane) loader.load();

            // Помещаем сведения об адресатах в центр корневого макета.
            rootLayout.setCenter(personOverview);

            // Даём контроллеру доступ к главному приложению.
            StudentStrController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int ifIPRofessor(String login, String password){
        if (login.equals("Petya") & password.equals("123")){

            return  0;
        }else
        if (login.equals("Prof") & password.equals("123")){

            return 1;
        }return 3;

    }


    public Object login(String login, String password){

        if (login.equals("Petya") & password.equals("123")){
        Student student = new Student();
        student.setFirstNameStudent("sda");
        student.setSeccondNameStudent("asdwq");
        student.setLastNameStudent("sadfq");
        student.setStudentID("1234");
            student.setNumberOfGrouph("1234");
       return  student;
        }else
            if (login.equals("Prof") & password.equals("123")){
                Professor professor = new Professor();
                professor.setCursors(predm);
                professor.setFirstName("Vasya");
                professor.setLastName("Mada");
                professor.setSeccondName("sadq");
                professor.setTime("21");
                professor.setTimetosdat("34");
                professor.setWork(work);
             return professor;
            }return null;

    }

    public ObservableList<Marks> getMarks(Student student){
        student.getStudentID();
        if (Integer.parseInt(student.getStudentID()) == 1234){
            ObservableList<Marks> myList = FXCollections.observableArrayList();
            myList.add(new Marks("Siann", "4", "5" ,"6" , "7" ,"8" , "3" ,"1" , "3" ,"8" , "5"));
            myList.add(new Marks("Sdfqw", "4", "5" ,"6" , "7" ,"8" , "3" ,"1" , "3" ,"8" , "5" ));
            return myList;
        }return null;
    }

    private ObservableList<Student> students = FXCollections.observableArrayList();

    public ObservableList<Student> getStudentsForRecensionQueue(Student student){
        student.getStudentID();
        students.add(new Student("asd","sad","asd", "123", "324234"));
        return students;
    }

    public void sendMyRecensionToServer(Student student, String recension, String wrong, int mark){
        students.add(student);
    }
    /**
     * Возвращает главную сцену.
     * @return
     */

    public ObservableList<Student> getStudentsListInQueue(){
        ObservableList<Student> myList = FXCollections.observableArrayList();
        myList.add(new Student("Petr1","Frolow","Hz", "123", "21324"));
        myList.add(new Student("Petr2","Frolow","Hz", "123", "1523"));
        myList.add(new Student("Petr3","Frolow","Hz", "425", "23512"));
        return myList;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ObservableList<Work> getWorksForStudent(Subject subject){
        ObservableList<Work> listOfWorks = FXCollections.observableArrayList();
        listOfWorks.add(new Work("sdfsddfsdfadsdfsdfsdfadsdasdsdfsdadsdasdsdfsdfsdfadsdasdsdfsdfsdfadsdasdsdfsdfsdfadsdasdsdfsd"
                ,"eqweqwe", "wqdqwd", "dqwdqwd"));
        return listOfWorks;
    }

    public ObservableList<Subject> getSubjectListForStudent(Student student){
        ObservableList<Subject> listOfSubject = FXCollections.observableArrayList();
        listOfSubject.add(new Subject("dqwdwq", "sadrqw"));
        return listOfSubject;
    }

    public ObservableList<Subject> getSubjectListForProfessor(Professor iProfessor) {
        ObservableList<Subject> listOfSubject = FXCollections.observableArrayList();
        listOfSubject.add(new Subject("dqwdwq", "sadrqw"));
        return listOfSubject;
    }
}