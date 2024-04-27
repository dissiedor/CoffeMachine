import java.util.Scanner;

public class ScanUtility {

    static Scanner scanner = new Scanner(System.in);
    public static String scanLine(){
        return scanner.next();
    }

    public static int scanInt(){
        return scanner.nextInt();
    }
}
