package controller;

import javafx.beans.Observable;
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
import model.dto.CustomerManagementDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CustomerManagementController implements Initializable {

    ObservableList <CustomerManagementDTO> customerManagementDTOS = FXCollections.observableArrayList( //customerManagementDTOS is a observerList that holds CustomerManagementDTO objects
            new CustomerManagementDTO("C001", "Miss", "Isu", "2005-03-08", 150000.00, "Akkarapanaha","Negombo", "Western Province", "100234"),
            new CustomerManagementDTO("C002", "Miss", "Hiranya", "2007-05-02", 170000.00, "Hirana","Panadura", "Western Province", "100568")
    );
    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableView<CustomerManagementDTO> tblCustomerManagement;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCusID;

    @FXML
    private TextField txtDOB;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    private TextField txtSalary;

    @FXML
    private TextField txtTitle;

    Stage stage = new Stage();
    @FXML
    void btnBackToDashboardOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
    }

    @FXML
    void btnAddActionOn(ActionEvent event) {
        String id = txtCusID.getText();
        String title = txtTitle.getText();
        String name = txtName.getText();
        String dob = txtDOB.getText();
        double salary = Double.parseDouble(txtSalary.getText());
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        String postalCode = txtPostalCode.getText();

        CustomerManagementDTO newCustomer = new CustomerManagementDTO(id, title, name, dob, salary, address, city,province, postalCode);
        customerManagementDTOS.add(newCustomer);

        tblCustomerManagement.setItems(customerManagementDTOS);
        tblCustomerManagement.refresh();

        ActionEvent actionEvent;
        btnClearActionOn(event);
    }

    @FXML
    void btnClearActionOn(ActionEvent event) {
        txtCusID.setText("");
        txtTitle.setText("");
        txtName.setText("");
        txtDOB.setText("");
        txtSalary.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {
        CustomerManagementDTO selectedCustomer = tblCustomerManagement.getSelectionModel().getSelectedItem();
        customerManagementDTOS.remove(selectedCustomer);
        tblCustomerManagement.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        CustomerManagementDTO selectedCustomer = tblCustomerManagement.getSelectionModel().getSelectedItem();

        selectedCustomer.setId(txtCusID.getText());
        selectedCustomer.setTitle(txtTitle.getText());
        selectedCustomer.setName(txtName.getText());
        selectedCustomer.setDob(txtDOB.getText());
        selectedCustomer.setSalary(Double.parseDouble(txtSalary.getText()));
        selectedCustomer.setAddress(txtAddress.getText());
        selectedCustomer.setCity(txtCity.getText());
        selectedCustomer.setProvince(txtProvince.getText());
        selectedCustomer.setPostalCode(txtPostalCode.getText());

        tblCustomerManagement.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("dob"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));

        tblCustomerManagement.setItems(customerManagementDTOS);

        tblCustomerManagement.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if(newValue != null){
                txtCusID.setText(newValue.getId());
                txtTitle.setText(newValue.getTitle());
                txtName.setText(newValue.getName());
                txtDOB.setText(newValue.getDob());
                txtSalary.setText(String.valueOf(newValue.getSalary()));
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(newValue.getPostalCode());
            }
        });
    }
}
