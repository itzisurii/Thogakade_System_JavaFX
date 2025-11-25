package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.dto.EmployeeManagementDTO;
import model.dto.ItemManagementDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {

    ObservableList<EmployeeManagementDTO> employeeManagementDTOS = FXCollections.observableArrayList(
            new EmployeeManagementDTO("E001", "john", "200567990", "2005-03-08", "Head", 120000),
            new EmployeeManagementDTO("E002", "Ariana", "200577990", "2004-09-04", "Chief", 130000)
    );

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colNIC;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPosition;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableView<?> tblItemManagement;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNIC;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    void btnAddActionOn(ActionEvent event) {

    }

    @FXML
    void btnBackToDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearActionOn(ActionEvent event) {

    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
