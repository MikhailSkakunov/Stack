package model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;


public class Subscriber {

     @CsvBindByPosition(position = 0)
     @CsvBindByName(column = "id", required = true)
     private int id;

     @CsvBindByPosition(position = 1)
     @CsvBindByName(column = "lastName", required = true)
     private String lastName;

     @CsvBindByPosition(position = 2)
     @CsvBindByName(column = "streetName", required = true)
     private String streetName;

     @CsvBindByPosition(position = 3)
     @CsvBindByName(column = "houseNumber", required = true)
     private int houseNumber;

     @CsvBindByPosition(position = 4)
     @CsvBindByName(column = "apartmentNumber", required = true)
     private int apartmentNumber;

     @CsvBindByPosition(position = 5)
     @CsvBindByName(column = "accrualType", required = true)
     private int accrualType;

     @CsvBindByPosition(position = 6)
     @CsvBindByName(column = "previousValue", required = true)
     private int previousValue;

     @CsvBindByPosition(position = 7)
     @CsvBindByName(column = "presentValue", required = true)
     private int presentValue;

     public Subscriber() {
     }

     public Subscriber(int id, String lastName, String streetName, int houseNumber,
                        int apartmentNumber, int accrualType, int previousValue,
                       int presentValue) {
          this.id = id;
          this.lastName = lastName;
          this.streetName = streetName;
          this.houseNumber = houseNumber;
          this.apartmentNumber = apartmentNumber;
          this.accrualType = accrualType;
          this.previousValue = previousValue;
          this.presentValue = presentValue;
     }


     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getStreetName() {
          return streetName;
     }

     public void setStreetName(String streetName) {
          this.streetName = streetName;
     }

     public int getHouseNumber() {
          return houseNumber;
     }

     public void setHouseNumber(int houseNumber) {
          this.houseNumber = houseNumber;
     }

     public int getApartmentNumber() {
          return apartmentNumber;
     }

     public void setApartmentNumber(int apartmentNumber) {
          this.apartmentNumber = apartmentNumber;
     }

     public int getAccrualType() {
          return accrualType;
     }

     public void setAccrualType(int accrualType) {
          this.accrualType = accrualType;
     }

     public int getPreviousValue() {
          return previousValue;
     }

     public void setPreviousValue(int previousValue) {
          this.previousValue = previousValue;
     }

     public int getPresentValue() {
          return presentValue;
     }

     public void setPresentValue(int presentValue) {
          this.presentValue = presentValue;
     }

     @Override
     public String toString() {
          return "Subscribers{" +
                  "id='" + id + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", streetName='" + streetName + '\'' +
                  ", houseNumber='" + houseNumber + '\'' +
                  ", apartmentNumber='" + apartmentNumber + '\'' +
                  ", accrualType='" + accrualType + '\'' +
                  ", previousValue='" + previousValue + '\'' +
                  ", presentValue='" + presentValue + '\'' +
                  '}';
     }
}
