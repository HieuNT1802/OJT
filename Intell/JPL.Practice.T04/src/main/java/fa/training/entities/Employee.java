package fa.training.entities;

import java.time.LocalDate;

public class Employee {
private  int empId;
private LocalDate birthDate;
private String firstName;
private String lastName;
private String gender;
private LocalDate hireDate;

    public Employee() {
    }

    public Employee(int empId, LocalDate birthDate, String firstName, String lastName, String gender, LocalDate hireDate) {
        this.empId = empId;
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "Employee Id=" + empId +
                "| Birth Date=" + birthDate +
                "| First Name='" + firstName + '\'' +
                "| Last Name='" + lastName + '\'' +
                "| Gender='" + gender + '\'' +
                "| Hire Date=" + hireDate;
    }
}
