package fa.training.entities;

public class SalesEmployee extends Employee {
    private int numberOfUnitSales;
    public SalesEmployee(String ssn, String firstName, String lastName, String phone, String birthDate, String email , int numberOfUnitSales) {
        super(ssn, firstName, lastName, phone, birthDate, email);
        this.numberOfUnitSales = numberOfUnitSales;
    }

    public int getNumberOfUnitSales() {
        return numberOfUnitSales;
    }

    public void setNumberOfUnitSales(int numberOfUnitSales) {
        this.numberOfUnitSales = numberOfUnitSales;
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "numberOfUnitSales=" + numberOfUnitSales +
                ", ssn='" + ssn + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    @Override
    public void display() {
        System.out.println(this.toString());
    }
}
