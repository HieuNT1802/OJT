package fa.training.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;

public class ValidationUtils {

	public static boolean isPhoneNumber(String phone) {

		phone = phone.trim();
		if (phone.length() < 8 || phone.length() > 13) {
			return false;
		}
		if (!Character.isDigit(phone.charAt(0)) && !phone.startsWith("+")) {
			return false;
		}
		for (int i = 1; i < phone.length() - 1; i++) {
			if (!Character.isDigit(phone.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDate(String pattern, String date) {
		try {
			LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

	public static boolean isEmail(String email) {
		String emailRegex =  "^(.+)@(\\S+)$";
		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	public static boolean isMatched(String pattern, String string){
		Pattern pat = Pattern.compile(pattern);
		if (string == null)
			return false;
		return pat.matcher(string).matches();
	}

}
