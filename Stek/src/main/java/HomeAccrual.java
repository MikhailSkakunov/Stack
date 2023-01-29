import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
