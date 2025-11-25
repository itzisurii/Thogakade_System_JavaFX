package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.dto.ItemManagementDTO;
import model.dto.SupplierManagementDTO;

import java.net.URL;
import java.util.ResourceBundle;

public class SupplierManagementController implements Initializable {

    ObservableList<SupplierManagementDTO> supplierManagementDTOS = FXCollections.observableArrayList(
            new SupplierManagementDTO("S001", "Soap", "Company name", "Akkarapanaha", "Negombo", "Western", 11900, "0769975582", "email@gmail.com"),
            new SupplierManagementDTO("S002", "Soap", "Company name", "Akkarapanaha", "Negombo", "Western", 11900, "0769975582", "email@gmail.com"),
            new SupplierManagementDTO("S003","Soap", "Company name", "Akkarapanaha", "Negombo", "Western", 11900, "0769975582", "email@gmail.com" )
    );


    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colCompanyName;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPhone;

    @FXML
    private TableColumn<?, ?> colPostalCode;

    @FXML
    private TableColumn<?, ?> colProvince;

    @FXML
    private TableView<SupplierManagementDTO> tblSupplierManagement;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtCompanyName;

    @FXML
    private TextField txtSupID;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtPostalCode;

    @FXML
    private TextField txtProvince;

    @FXML
    void btnAddActionOn(ActionEvent event) {
        String id = txtSupID.getText();
        String name = txtName.getText();
        String companyName = txtCompanyName.getText();
        String address = txtAddress.getText();
        String city = txtCity.getText();
        String province = txtProvince.getText();
        int postalCode = Integer.parseInt(txtPostalCode.getText());
        String phone = txtPhone.getText();
        String email = txtEmail.getText();

        SupplierManagementDTO newSupplier = new SupplierManagementDTO(id, name, companyName, address, city, province, postalCode, phone, email);
        supplierManagementDTOS.add(newSupplier);


    }

    @FXML
    void btnBackToDashboardOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearActionOn(ActionEvent event) {
        txtSupID.setText("");
        txtName.setText("");
        txtCompanyName.setText("");
        txtAddress.setText("");
        txtCity.setText("");
        txtProvince.setText("");
        txtPostalCode.setText("");
        txtProvince.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {
        SupplierManagementDTO selectedItem = tblSupplierManagement.getSelectionModel().getSelectedItem();
        supplierManagementDTOS.remove(selectedItem);
        tblSupplierManagement.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        SupplierManagementDTO selectedItem = tblSupplierManagement.getSelectionModel().getSelectedItem();

        selectedItem.setId(txtSupID.getText());
        selectedItem.setName(txtName.getText());
        selectedItem.setCompanyName(txtCompanyName.getText());
        selectedItem.setAddress(txtAddress.getText());
        selectedItem.setCity(txtCity.getText());
        selectedItem.setProvince(txtProvince.getText());
        selectedItem.setPostalCode(Integer.parseInt(txtPostalCode.getText()));
        selectedItem.setPhone(txtPhone.getText());
        selectedItem.setEmail(txtEmail.getText());

        tblSupplierManagement.refresh();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCompanyName.setCellValueFactory(new PropertyValueFactory<>("companyName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
        colProvince.setCellValueFactory(new PropertyValueFactory<>("province"));
        colPostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        tblSupplierManagement.setItems(supplierManagementDTOS);

        tblSupplierManagement.getSelectionModel().selectedItemProperty().addListener((observer, oldvalue, newValue)->{
            if(newValue != null){
                txtSupID.setText(newValue.getId());
                txtName.setText(newValue.getName());
                txtCompanyName.setText(newValue.getCompanyName());
                txtAddress.setText(newValue.getAddress());
                txtCity.setText(newValue.getCity());
                txtProvince.setText(newValue.getProvince());
                txtPostalCode.setText(String.valueOf(newValue.getPostalCode()));
                txtPhone.setText(String.valueOf(newValue.getPhone()));
                txtEmail.setText(newValue.getEmail());
            }
        });
    }
}
