package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final String FULL_VALIDATE = "^[a-zA-Z0-9\\s+]+$";
    public static final String NUMBER_VALIDATOR = "^[0-9\\s+]+$";
    public static final String DOUBLE_VALIDATOR = "^(-?\\d+\\.?\\d*)$";

    public static boolean isDouble(String value) {
        Pattern pattern = Pattern.compile(DOUBLE_VALIDATOR);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean isNumber(String value) {
        Pattern pattern = Pattern.compile(NUMBER_VALIDATOR);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static LocalDate stringToLocalDate(String value) {
        return LocalDate.parse(value, DATE_FORMAT);
    }

    public static boolean isValue(String value) {
        Pattern pattern = Pattern.compile(FULL_VALIDATE);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }
}
