package com.example.laba3;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Класс-модель для адресата (Person).
 *
 * @author Marco Jakob
 */
public class Person {

    private final StringProperty Name;
    private final StringProperty Country;
    private final StringProperty Contact_person;
    private final IntegerProperty Phone_number;
    private final StringProperty Address;

    /**
     * Конструктор по умолчанию.
     */
    public Person() {
        this(null, null);
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param Name
     * @param Country
     */
    public Person(String Name, String Country) {
        this.Name = new SimpleStringProperty(Name);
        this.Country = new SimpleStringProperty(Country);

        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.Contact_person = new SimpleStringProperty("какой-то человек");
        this.Phone_number = new SimpleIntegerProperty(1234567);
        this.Address = new SimpleStringProperty("какой-то адрес");
    }

    public String getName() {
        return Name.get();
    }

    public void setName(String Name) {
        this.Name.set(Name);
    }

    public StringProperty NameProperty() {
        return Name;
    }

    public String getCountry() {
        return Country.get();
    }

    public void setCountry(String Country) {
        this.Country.set(Country);
    }

    public StringProperty CountryProperty() {
        return Country;
    }

    public String getContact_person() {
        return Contact_person.get();
    }

    public void setContact_person(String Contact_person) {
        this.Contact_person.set(Contact_person);
    }

    public StringProperty Contact_personProperty() {
        return Contact_person;
    }

    public int getPhone_number() {
        return Phone_number.get();
    }

    public void setPhone_number(int Phone_number) {
        this.Phone_number.set(Phone_number);
    }

    public IntegerProperty Phone_numberProperty() {
        return Phone_number;
    }

    public String getAddress() {
        return Address.get();
    }

    public void setAddress(String Address) {
        this.Address.set(Address);
    }

    public StringProperty AddressProperty() {
        return Address;
    }
}