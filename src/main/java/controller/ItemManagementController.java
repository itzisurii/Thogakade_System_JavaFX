package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ItemManagementController {

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
    private TableView<?> tblItemManagement;

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

}
