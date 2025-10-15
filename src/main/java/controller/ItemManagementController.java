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
import model.dto.ItemManagementDTO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ItemManagementController implements Initializable {

    ObservableList <ItemManagementDTO> itemManagementDTOS = FXCollections.observableArrayList(
            new ItemManagementDTO("I001", "Light", "Food", 12, 12000),
            new ItemManagementDTO("I002", "Noodles", "Soup", 15, 20000)
    );

    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQuantityOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableView<ItemManagementDTO> tblItemManagement;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtDescription;

    @FXML
    private TextField txtItemCode;

    @FXML
    private TextField txtQutOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    void btnAddActionOn(ActionEvent event) {
        String code = txtItemCode.getText();
        String description = txtDescription.getText();
        String category = txtCategory.getText();
        int qtyOnHand = Integer.parseInt(txtQutOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());

        ItemManagementDTO newItem = new ItemManagementDTO(code, description, category, qtyOnHand, unitPrice);
        itemManagementDTOS.add(newItem);

        tblItemManagement.setItems(itemManagementDTOS);
        tblItemManagement.refresh();

        ActionEvent actionEvent;
        btnClearActionOn(event);
    }

    @FXML
    void btnClearActionOn(ActionEvent event) {
        txtItemCode.setText("");
        txtDescription.setText("");
        txtQutOnHand.setText("");
        txtUnitPrice.setText("");
        txtCategory.setText("");
    }

    @FXML
    void btnDeleteActionOn(ActionEvent event) {
        ItemManagementDTO selectedItem = tblItemManagement.getSelectionModel().getSelectedItem();
        itemManagementDTOS.remove(selectedItem);
        tblItemManagement.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemManagementDTO selectedItem = tblItemManagement.getSelectionModel().getSelectedItem();

        selectedItem.setCode(txtItemCode.getText());
        selectedItem.setDescription(txtDescription.getText());
        selectedItem.setCategory(txtCategory.getText());
        selectedItem.setQtyOnHand(Integer.parseInt(txtQutOnHand.getText()));
        selectedItem.setUnitPrice(Double.parseDouble(txtUnitPrice.getText()));

        tblItemManagement.refresh();
    }

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colQuantityOnHand.setCellValueFactory(new PropertyValueFactory<>("qtyOnHand"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));

        tblItemManagement.setItems(itemManagementDTOS);

        tblItemManagement.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue)->{
            if(newValue != null){
                txtItemCode.setText(newValue.getCode());
                txtDescription.setText(newValue.getDescription());
                txtCategory.setText(newValue.getCategory());
                txtQutOnHand.setText(String.valueOf(newValue.getQtyOnHand()));
                txtUnitPrice.setText(String.valueOf(newValue.getUnitPrice()));
            }
        });
    }
}
