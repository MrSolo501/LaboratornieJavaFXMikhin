package com.example.laba3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import com.example.laba3.MainApp;
import com.example.laba3.Person;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> NameColumn;
    @FXML
    private TableColumn<Person, String> CountryColumn;

    @FXML
    private Label NameLabel;
    @FXML
    private Label CountryLabel;
    @FXML
    private Label Contact_personLabel;
    @FXML
    private Label Phone_numberLabel;
    @FXML
    private Label AddressLabel;

    // Ссылка на главное приложение.
    private MainApp mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public PersonOverviewController() {
    }

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        NameColumn.setCellValueFactory(
                cellData -> cellData.getValue().NameProperty());
        CountryColumn.setCellValueFactory(
                cellData -> cellData.getValue().CountryProperty());

        // Очистка дополнительной информации об адресате.
        showPersonDetails(null);

        // Слушаем изменения выбора, и при изменении отображаем
        // дополнительную информацию об адресате.
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    }

    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */

    public void setMainApp(com.example.laba3.MainApp mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        personTable.setItems(mainApp.getPersonData());
    }

    private void showPersonDetails(Person person) {
        if (person != null) {
            // Заполняем метки информацией из объекта person.
            NameLabel.setText(person.getName());
            CountryLabel.setText(person.getCountry());
            Contact_personLabel.setText(person.getContact_person());
            Phone_numberLabel.setText(Integer.toString(person.getPhone_number()));
            AddressLabel.setText(person.getAddress());

        } else {
            // Если Person = null, то убираем весь текст.
            NameLabel.setText("");
            CountryLabel.setText("");
            Contact_personLabel.setText("");
            Phone_numberLabel.setText("");
            AddressLabel.setText("");
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке удаления.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            personTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Manufacturer Selected");
            alert.setContentText("Please select a Manufacturer in the table.");

            alert.showAndWait();
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке New...
     * Открывает диалоговое окно с дополнительной информацией нового адресата.
     */
    @FXML
    private void handleNewPerson() {
        Person tempPerson = new Person();
        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
        if (okClicked) {
            mainApp.getPersonData().add(tempPerson);
        }
    }

    /**
     * Вызывается, когда пользователь кликает по кнопке Edit...
     * Открывает диалоговое окно для изменения выбранного адресата.
     */
    @FXML
    private void handleEditPerson() {
        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Manufacturer Selected");
            alert.setContentText("Please select a Manufacturer in the table.");

            alert.showAndWait();
        }
    }
}