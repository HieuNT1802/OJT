package fa.training.utils;

import java.util.Scanner;

public class ScannerUtil {
    public static Scanner scanner;

    private ScannerUtil() {
    }

    public static Scanner getInstance(){
        if(scanner == null){
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
