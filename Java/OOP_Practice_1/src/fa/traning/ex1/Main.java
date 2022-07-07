package fa.traning.ex1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Department itDept = new Department(
                "IT",
                "CG",
                new ArrayList<>(Arrays.asList(
                        new Employee(0,"Long","HN",6.00000),
                        new Employee(1,"Nam","HN",20.00000),
                        new Employee(2,"Viet","HN",40.00000)
                ))
        );
        itDept.addEmployee(new Employee(4,"Hai","ND",10000));
        itDept.removeEmployee(itDept.findEmployeeById(4));
        System.out.println(itDept);

        System.out.println("Yearly expenditure: " + itDept.getYearlyExpenditure());

    }
}
