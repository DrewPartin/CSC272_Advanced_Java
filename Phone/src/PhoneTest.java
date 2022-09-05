import java.util.Scanner;
import java.util.NoSuchElementException;

public class PhoneTest {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Phone application = new Phone();
        System.out.print("Enter a 7-digit phone number (digits 1 and 0 do not have letters): ");

        try { 
            application.calculate(scanner.nextInt());
            scanner.close();
        }
        catch (NoSuchElementException elementException) { System.err.println("Error inputting data"); }
    }
}
