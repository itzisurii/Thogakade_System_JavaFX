package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.EmployeeManagementDTO;
import model.dto.ItemManagementDTO;
import model.dto.SupplierManagementDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeManagementController implements Initializable {

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
    private TableView<EmployeeManagementDTO> tblEmployeeManagement;

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
        String id = txtId.getText();
        String name = txtName.getText();
        String nic = txtNIC.getText();
        String dob = txtDOB.getText();
        String position = txtPosition.getText();
        double salary = Double.parseDouble(txtSalary.getText());

        EmployeeManagementDTO newItem = new EmployeeManagementDTO(id, name, nic, dob, position, salary);
        employeeManagementDTOS.add(newItem);

        tblEmployeeManagement.setItems(employeeManagementDTOS);
        tblEmployeeManagement.refresh();

        ActionEvent actionEvent;
        btnClearActionOn(event);
    }

    @FXML
    Stage stage =  new Stage();
    void btnBackToDashboardOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void btnClearActionOn(ActionEvent event) {
        txtId.setText("");
        txtName.setText("");
        txtNIC.setText("");
        txtDOB.setText("");
        txtPosition.setText("");
        txtSalary.setText("");
    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {
        EmployeeManagementDTO selectedItem = tblEmployeeManagement.getSelectionModel().getSelectedItem();
        employeeManagementDTOS.remove(selectedItem);
        tblEmployeeManagement.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        EmployeeManagementDTO selectedItem = tblEmployeeManagement.getSelectionModel().getSelectedItem();

        selectedItem.setId(txtId.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setNic(txtNIC.getText());
        selectedItem.setDob(txtDOB.getText());
        selectedItem.setPosition(txtPosition.getText());
        selectedItem.setSalary(Double.parseDouble(txtSalary.getText()));

        tblEmployeeManagement.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        tblEmployeeManagement.setItems(employeeManagementDTOS);

        tblEmployeeManagement.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if(newValue != null){
                txtId.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtNIC.setText(newValue.getNic());
                txtDOB.setText(String.valueOf(newValue.getDob()));
                txtPosition.setText(String.valueOf(newValue.getPosition()));
                txtSalary.setText(String.valueOf(newValue.getSalary()));
            }
        });
    }
}
