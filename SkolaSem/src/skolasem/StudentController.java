/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skolasem;

import Entity.Student;
import Entity.StudentInfo;
import Entity.StudentInfo2;
import Entity.Zapocet;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Filip
 */
public class StudentController implements Initializable {

    @FXML
    private TableView<StudentInfo> popup;
    @FXML
    private TableColumn<StudentInfo, String> Zapocet;
   
    @FXML
    private TableColumn<StudentInfo, String>Nazev;
    
    private Student student;
  private dbconnection dc;
   private ObservableList<StudentInfo> data;
   private ObservableList<StudentInfo2> data2;
   
    @FXML
    private TableView<StudentInfo2> popup2;
    @FXML
    private TableColumn<StudentInfo2, String> Nazev2;
    
     @FXML
    private TableColumn<StudentInfo2, String> Zkouska;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         dc = new dbconnection();
         
    }    

    void setStudent(Student student) {
        this.student=student;
    }
    
    /*
    SELECT Datum, Nazev
    FROM Zkouska 
    JOIN Student_has_Zkousky ON Zkouska.id = Student_has_Zkousky.Zkousky_ID
    JOIN Predmet ON Predmet.ID = Zkouska.Predmet_ID 
    WHERE Student_has_Zkousky.Student_ID = + student.getId()
    
    */
    
    public void loadData() {

        try {
            java.sql.Connection conn = dc.Connect();
            data = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Nazev, Zapocteno FROM zapocet JOIN predmet on predmet.ID = zapocet.Predmet_ID where Student_ID = " + student.getId());
            while (rs.next()) {
                data.add(new StudentInfo(rs.getString(1),rs.getString(2)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        Nazev.setCellValueFactory(new PropertyValueFactory<>("Nazev"));
        Zapocet.setCellValueFactory(new PropertyValueFactory<>("Zapocet"));

        popup.setItems(null);
        popup.setItems(data);

    }
    
    
    public void loadData2() {

        try {
            java.sql.Connection conn = dc.Connect();
            data2 = FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Nazev, Datum FROM Zkouska JOIN Student_has_Zkousky ON Zkouska.id = Student_has_Zkousky.Zkousky_ID JOIN Predmet ON Predmet.ID = Zkouska.Predmet_ID WHERE Student_has_Zkousky.Student_ID = " + student.getId()); 
   
   
  
   
            
            while (rs.next()) {
                data2.add(new StudentInfo2(rs.getString(1),rs.getString(2)));

            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);

        }

        Nazev2.setCellValueFactory(new PropertyValueFactory<>("Nazev"));
        Zkouska.setCellValueFactory(new PropertyValueFactory<>("Zkouska"));

        popup2.setItems(null);
        popup2.setItems(data2);

    }
    
    
}
