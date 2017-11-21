package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.event.*;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private ImageView imageEmail;
    @FXML
    private ImageView imageID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldSurname;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldID;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonSignUp;
    @FXML
    private ComboBox<String> comboBoxCountry = new ComboBox<>();
    @FXML
    private ComboBox<String> comboBoxCity = new ComboBox<>();
    private ObservableList<String> listCountry = FXCollections.observableArrayList("Armenia", "Russia", "Brazil", "United States", "Andorra", "Argentina");
    private ObservableList<String> listCity = FXCollections.observableArrayList("Yerevan", "Moscow", "Brazil", "Washington", "Andorra", "Buenos Aires");



    /*
    \ewoidheiuhieu2heiudhieuwdhjeiwudhiedhiehniehn
     */


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setComboBoxCountry(listCountry);
        setComboBoxCity(listCity);
    }

    public void setComboBoxCountry(ObservableList<String> listCountry) {
        listCountry.sorted();
        this.comboBoxCountry.setItems(listCountry);
    }


    public void setComboBoxCity(ObservableList<String> listCity) {
        listCity.sorted();
        this.comboBoxCity.setItems(listCity);
    }

    public void signUpevent(ActionEvent event)
    {
        AnchorPane root=new AnchorPane();
        Stage stage=new Stage();
        root.setStyle("-fx-background-color: white");
        stage.setTitle("Registration successed");
        stage.setScene(new Scene(root,320,240));
        Label label=new Label("Congratulations");
        label.setLayoutX(root.getLayoutX()/2);
        label.setLayoutY(root.getLayoutY()/2);
        label.setStyle("-fx-font-size: 36px; -fx-text-fill: lightgreen");
        Label label1=new Label("You've Successfully Signed Up");
        label1.setLayoutX(label.getLayoutX());
        label1.setLayoutY(label.getLayoutY()+100);
        label1.setStyle("-fx-font-size: 20px; -fx-text-fill: black");
        root.getChildren().addAll(label,label1);
        ((Node)(event.getSource())).getScene().getWindow().hide();
        stage.show();
    }


    public void eventTextFieldEmail(KeyEvent event) {
            if(event.getCode()== KeyCode.ENTER) {
                getImageEmail().setVisible(true);
                getImageID().setVisible(true);
                if (textFieldEmail.getText().contains("@mail.ru") || textFieldEmail.getText().contains("@gmail.com") && textFieldEmail.getText().length()>3) {
                    imageEmail.setImage(new Image("sample/images/Accept-icon.png"));
                    textFieldID.setText(textFieldEmail.getText()+"_user");
                    imageID.setImage(new Image("sample/images/Lock-Lock-icon.png"));
                }
                else
                    imageEmail.setImage(new Image("sample/images/Close-2-icon.png"));
            }
    }



    public void newMethod(){

    }



    public void ecentReestButton(ActionEvent event)
    {
        this.getTextFieldEmail().setText("");
        this.getTextFieldID().setText("");
        this.getTextFieldName().setText("");
        this.getTextFieldSurname().setText("");
        this.getImageID().setVisible(false);
        this.getImageEmail().setVisible(false);
    }

    public TextField getTextFieldName() {
        return textFieldName;
    }

    public TextField getTextFieldSurname() {
        return textFieldSurname;
    }

    public TextField getTextFieldEmail() {
        return textFieldEmail;
    }

    public TextField getTextFieldID() {
        return textFieldID;
    }

    public ImageView getImageEmail() {
        return imageEmail;
    }

    public ImageView getImageID() {
        return imageID;
    }

}
