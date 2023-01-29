import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class HomeAccrual {
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

    @CsvBindByPosition(position = 7)
    @CsvBindByName(column = "accrual", required = true)
    private double accrual;

    public HomeAccrual() {
    }

    public HomeAccrual(int id, String lastName, String streetName, int houseNumber, int apartmentNumber, double accrual) {
        this.id = id;
        this.lastName = lastName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.accrual = accrual;
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

    public double getAccrual() {
        return accrual;
    }

    public void setAccrual(double accrual) {
        this.accrual = accrual;
    }

    @Override
    public String toString() {
        return "HomeAccrual{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", streetName='" + streetName + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", accrual=" + accrual +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof HomeAccrual)) return false;

        HomeAccrual that = (HomeAccrual) obj;

        if (!Objects.equals(this.streetName, that.streetName)) return false;
        if (!Objects.equals(this.houseNumber, that.houseNumber)) return false;
        return Objects.equals(this.apartmentNumber, that.apartmentNumber);
    }

    @Override
    public int hashCode() {
        int result = lastName != null ? lastName.hashCode() : 0;
        result = 31 * result + (streetName != null ? streetName.hashCode() : 0);
        result = 31 * result + (String.valueOf(houseNumber) != null ? String.valueOf(houseNumber).hashCode() : 0);
        result = 31 * result + (String.valueOf(apartmentNumber) != null ? String.valueOf(apartmentNumber).hashCode() : 0);
        return result;
    }
}
