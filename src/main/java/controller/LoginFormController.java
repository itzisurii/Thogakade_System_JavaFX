package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtPassword;

    Stage stage = new Stage();
    @FXML
    void btnSignInOnAction(ActionEvent event) {
        String username = txtEmail.getText();
        String password = txtPassword.getText();

        if(username.equals("Admin")){
            if(password.equals("1234")){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.show();
                txtEmail.clear();
                txtPassword.clear();
            }else{
                System.out.println("Invalid Password");
                txtEmail.clear();
                txtPassword.clear();
            }
        }else{
            System.out.println("Invalid Username");
            txtEmail.clear();
            txtPassword.clear();
        }
    }

}
