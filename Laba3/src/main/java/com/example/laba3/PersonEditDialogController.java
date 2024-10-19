package com.example.laba3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.laba3.Person;

/**
 * Окно для изменения информации об адресате.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

    @FXML
    private TextField NameField;
    @FXML
    private TextField CountryField;
    @FXML
    private TextField Contact_personField;
    @FXML
    private TextField Phone_numberField;
    @FXML
    private TextField AddressField;


    private Stage dialogStage;
    private Person person;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

        NameField.setText(person.getName());
        CountryField.setText(person.getCountry());
        Contact_personField.setText(person.getContact_person());
        Phone_numberField.setText(Integer.toString(person.getPhone_number()));
        AddressField.setText(person.getAddress());
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            person.setName(NameField.getText());
            person.setCountry(CountryField.getText());
            person.setContact_person(Contact_personField.getText());
            person.setPhone_number(Integer.parseInt(Phone_numberField.getText()));
            person.setAddress(AddressField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (NameField.getText() == null || NameField.getText().length() == 0) {
            errorMessage += "No valid first Name!\n";
        }
        if (CountryField.getText() == null || CountryField.getText().length() == 0) {
            errorMessage += "No valid Country!\n";
        }
        if (Contact_personField.getText() == null || Contact_personField.getText().length() == 0) {
            errorMessage += "No valid Contact person!\n";
        }

        if (Phone_numberField.getText() == null || Phone_numberField.getText().length() == 0) {
            errorMessage += "No valid Phone number!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(Phone_numberField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Phone number (must be an integer)!\n";
            }
        }

        if (AddressField.getText() == null || AddressField.getText().length() == 0) {
            errorMessage += "No valid Address!\n";
        }


        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
