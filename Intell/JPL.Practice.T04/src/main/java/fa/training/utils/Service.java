package fa.training.utils;

import java.time.DateTimeException;
import java.time.LocalDate;

import fa.training.utils.ScannerUtil;
import fa.training.utils.ValidatorUtil;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;
public class Service {
    public static LocalDate inputDate() {
        String date;
        while (true) {
            date = ScannerUtil.getInstance().nextLine();
            try {
                return ValidatorUtil.stringToLocalDate(date);
            } catch (DateTimeException e) {
                System.out.println("Date must be correct format");
            }
        }
    }
    public static int getChoice(List<String> options) {
        int number;
        for (String i : options) {
            System.out.println(i);
        }
        System.out.print("Please choose an option : ");
        number = Integer.parseInt(ScannerUtil.getInstance().nextLine());
        return number;
    }
}
