/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skolasem;

import Entity.Predmet;
import Entity.Student;
import Entity.Zapocet;
import Entity.Zkouska;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Filip
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TableView<Student> tableStudent;
    @FXML

    private TableColumn<Student, String> ColumnId;
    @FXML
    private TableColumn<Student, String> ColumnJmeno;
    @FXML
    private TableColumn<Student, String> ColumnPrijmeni;
    @FXML
    private TableColumn<Student, String> ColumnAdresa;
    @FXML
    private TableColumn<Student, Integer> ColumnRC;
    @FXML
    private Button btnLoad;

    @FXML
    private TableColumn<Predmet, String> ColumnId2;
    @FXML
    private TableView<Predmet> tablePredmet;
    @FXML
    private TableColumn<Predmet, String> ColumnNazev;
    @FXML
    private TableColumn<Predmet, String> ColumnKod;
    @FXML
    private Button btnLoadp;

    @FXML
    private TableColumn<Zkouska, String> ColumnId3;

    @FXML
    private TableView<Zkouska> tableZkouska;
    @FXML
    private TableColumn<Zkouska, String> ColumnDatum;
    @FXML
    private Label label1;
    @FXML
    private Button btnLoadz;

    @FXML
    private TableView<Zapocet> tableZapocet;
    @FXML
    private TableColumn<Zapocet, String> ColumnZapocteno;
    @FXML
    private Button btnLoadzap;
    @FXML
    private Label label2;

    @FXML
    private Button btnDelS;
    @FXML
    private TextField txtJmeno;
    @FXML
    private TextField txtPrijmeni;
    @FXML
    private TextField txtAdresa;
    @FXML
    private TextField txtRc;
    @FXML
    private Button btnAddS;

    @FXML
    private TextField txtNazev;
    @FXML
    private TextField txtKod;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Button btnAddP;

    @FXML
    private TextField txtDatum;
    @FXML
    private TextField txtZapocet;

    @FXML
    private Button btnAddP1;
    @FXML
    private Button btnAddP2;
    @FXML
    private Button btnSearchS;

    private ObservableList<Student> data;
    private ObservableList<Predmet> datap;
    private ObservableList<Zkouska> dataz;
    private ObservableList<Zapocet> datazap;
    private dbconnection dc;
    @FXML
    private Button btnSearchS1;
    @FXML
    private Button btnSearchS2;
    @FXML
    private Button btnSearchS3;
    @FXML
    private Button btnLoad1;
    @FXML
    private TableColumn<Zapocet, String> ColumnZapocteno1;
    @FXML
    private TableColumn<Zapocet, String> ColumnZapocteno2;
    @FXML
    private TextField txtZapocet2;
    @FXML
    private TextField txtZapocet3;
    @FXML
    private TableColumn<Zkouska, String> ColumnIdPZ;
    @FXML
    private TextField txtDatum1;
    @FXML
    private Button btnLoad100;
    @FXML
    private TextField txtStudentZkouska2;
    @FXML
    private TextField txtStudentZkouska1;
    @FXML
    private Button btnAddP21;
    @FXML
    private Button btnAddP11;
    @FXML
    private Button btnLoadzap1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dc = new dbconnection();
        loadDataFromPredmets(null);
        loadDataFromStudents(null);
        loadDataFromZkouskas(null);
       loadDataFromZapocets(null);
    }

    @FXML
    private void loadDataFromStudents(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student");
            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        ColumnJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        ColumnPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        ColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        ColumnRC.setCellValueFactory(new PropertyValueFactory<>("RC"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);

    }

    @FXML
    private void loadDataFromPredmets(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            datap = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM predmet");
            while (rs.next()) {
                datap.add(new Predmet(rs.getInt(1), rs.getString(2), rs.getString(3)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnNazev.setCellValueFactory(new PropertyValueFactory<>("Nazev"));
        ColumnKod.setCellValueFactory(new PropertyValueFactory<>("Kod"));
        ColumnId2.setCellValueFactory(new PropertyValueFactory<>("id"));

        tablePredmet.setItems(null);
        tablePredmet.setItems(datap);

    }

    @FXML
    private void loadDataFromZkouskas(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            dataz = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM zkouska");
            while (rs.next()) {
                dataz.add(new Zkouska(rs.getInt(1), rs.getInt(3), rs.getString(2)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnDatum.setCellValueFactory(new PropertyValueFactory<>("Datum"));
        ColumnId3.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColumnIdPZ.setCellValueFactory(new PropertyValueFactory<>("Predmet_ID"));

        tableZkouska.setItems(null);
        tableZkouska.setItems(dataz);

    }

    @FXML
    private void loadDataFromZapocets(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            datazap = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM zapocet");
            while (rs.next()) {
                datazap.add(new Zapocet(rs.getInt(1), rs.getInt(4), rs.getInt(3), rs.getString(2)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnZapocteno.setCellValueFactory(new PropertyValueFactory<>("Zapocteno"));
        ColumnZapocteno1.setCellValueFactory(new PropertyValueFactory<>("Student_ID"));
        ColumnZapocteno2.setCellValueFactory(new PropertyValueFactory<>("Predmet_ID"));

        tableZapocet.setItems(null);
        tableZapocet.setItems(datazap);

    }

    @FXML
    private void handleDeleteStudent(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();

            int pst = conn.createStatement().executeUpdate("delete FROM student where RC = '" + RC + "'");
            loadDataFromStudents(null);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }

    @FXML
    private void handleAddStudent(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();
            int pst = conn.createStatement().executeUpdate("insert into student(Jmeno, Prijmeni, Adresa, RC) Values('" + Jmeno + "','" + Prijmeni + "','" + Adresa + "','" + RC + "')");
            loadDataFromStudents(null);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }

    @FXML
    private void handleAddPredmet(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            String Nazev = txtNazev.getText();
            String Kod = txtKod.getText();

            int pst = conn.createStatement().executeUpdate("insert into predmet(Nazev, Kod) Values('" + Nazev + "','" + Kod + "')");
            loadDataFromPredmets(null);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }

    @FXML
    private void handleAddZkouska(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            String Datum = txtDatum.getText();
            int Predmet_ID = Integer.parseInt(txtDatum1.getText());
            int pst = conn.createStatement().executeUpdate("insert into Zkouska(Datum, Predmet_ID) Values('" + Datum + "','" + Predmet_ID + "')");
            loadDataFromZkouskas(null);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }

    @FXML
    private void handleAddZapocet(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            String Zapocteno = txtZapocet.getText();
            int Student_ID = Integer.parseInt(txtZapocet2.getText());
            int Predmet_ID = Integer.parseInt(txtZapocet3.getText());
            int pst = conn.createStatement().executeUpdate("insert into Zapocet(Zapocteno, Student_ID, Predmet_ID) Values('" + Zapocteno + "','" + Student_ID + "','" + Predmet_ID + "')");
            loadDataFromZapocets(null);
        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }//int Student_ID = Integer.parseInt(txtZapocet1.getText());

    @FXML
    private void handleSearchStudents(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student where Prijmeni = '" + Prijmeni + "'");

            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        ColumnPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        ColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        ColumnRC.setCellValueFactory(new PropertyValueFactory<>("RC"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);

    }

    @FXML
    private void handleSearchStudentsA(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student where Adresa = '" + Adresa + "'");

            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        ColumnPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        ColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        ColumnRC.setCellValueFactory(new PropertyValueFactory<>("RC"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);
    }

    @FXML
    private void handleSearchStudentsR(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student where RC = '" + RC + "'");

            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        ColumnPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        ColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        ColumnRC.setCellValueFactory(new PropertyValueFactory<>("RC"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);
    }

    @FXML
    private void handleSearchStudentsJ(ActionEvent event) {
        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            String Jmeno = txtJmeno.getText();
            String Prijmeni = txtPrijmeni.getText();
            String Adresa = txtAdresa.getText();
            String RC = txtRc.getText();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM student where Jmeno = '" + Jmeno + "'");

            while (rs.next()) {
                data.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        ColumnJmeno.setCellValueFactory(new PropertyValueFactory<>("Jmeno"));
        ColumnPrijmeni.setCellValueFactory(new PropertyValueFactory<>("Prijmeni"));
        ColumnAdresa.setCellValueFactory(new PropertyValueFactory<>("Adresa"));
        ColumnRC.setCellValueFactory(new PropertyValueFactory<>("RC"));

        tableStudent.setItems(null);
        tableStudent.setItems(data);

    }

    public boolean showStudentDetails(Student student) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(SkolaSem.class.getResource("student.fxml"));
            AnchorPane page = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Náhled studenta");
            dialogStage.initModality(Modality.WINDOW_MODAL);

            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            StudentController controller = loader.getController();
            controller.setStudent(student);
            controller.loadData();
            controller.loadData2();
            // potom upravit
            dialogStage.showAndWait();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    @FXML
    private void handleStudentDetails(ActionEvent event) {

        Student selectedIndex = tableStudent.getSelectionModel().getSelectedItem();
        showStudentDetails(selectedIndex);
    }

    @FXML
    private void handleAddStudentZkouska(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            int Student_ID = Integer.parseInt(txtStudentZkouska1.getText());
            int Zkousky_ID = Integer.parseInt(txtStudentZkouska2.getText());
            int pst = conn.createStatement().executeUpdate("insert into Student_has_Zkousky(Student_ID, Zkousky_ID) Values('" + Student_ID + "','" + Zkousky_ID + "')");

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

    }

    @FXML
    private void handleUpdateZapocet(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            String Zapocteno = txtZapocet.getText();
            //pridat id zapoctu z textfieldu
            int Student_ID = Integer.parseInt(txtZapocet2.getText());
            int Predmet_ID = Integer.parseInt(txtZapocet3.getText());

            int pst = conn.createStatement().executeUpdate("update zapocet SET Zapocteno = '" + Zapocteno + "'  WHERE Student_ID =   " + Student_ID + " and Predmet_ID =  " + Predmet_ID + "");

            loadDataFromZapocets(null);

        } catch (SQLException ex) {
            System.out.println("Error" + ex);//

        }
    }

    @FXML
    private void handleUpdateZkouska(ActionEvent event) {

        try {
            java.sql.Connection conn = dc.Connect();
            String Datum = txtDatum.getText();
            //pridat id zkousky z textfieldu
            int Predmet_ID = Integer.parseInt(txtDatum1.getText());
            int pst = conn.createStatement().executeUpdate("update zkouska SET datum = '" + Datum + "'  WHERE Predmet_ID =   " + Predmet_ID + "");
            loadDataFromZkouskas(null);
            handleAddZkouska(null);

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        

        }
    


}
