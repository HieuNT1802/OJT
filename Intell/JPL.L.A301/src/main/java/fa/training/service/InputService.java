package fa.training.service;

import fa.training.exception.MyOwnRuntimeException;
import fa.training.utils.ScannerUtil;
import fa.training.utils.ValidatorUtil;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class InputService {

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

    public static String createStringValue() {
        String value;
        while (true) {
            value = ScannerUtil.getInstance().nextLine();
            if (ValidatorUtil.isValue(value)) break;
            System.out.println("Invalid input! enter again : ");
        }
        return value;
    }

    public static int createIntValue() {
        String value;
        while (true) {
            value = ScannerUtil.getInstance().nextLine();
            if (ValidatorUtil.isNumber(value)) break;
            System.out.print("Invalid input! enter again : ");
        }
        return Integer.parseInt(value);
    }

    public static double createDoubleValue() {
        String value;
        while (true) {
            value = ScannerUtil.getInstance().nextLine();
            if (ValidatorUtil.isDouble(value)) break;
            System.out.print("Invalid input! enter again : ");
        }
        return Double.parseDouble(value);
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
