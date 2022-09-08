import java.io.IOException;

public class FileHandlerTest {
    
    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler();
        System.out.println("\nWrite to file: ");
        fh.writeToFile();
        System.out.println("\nRead from file: ");
        fh.readFromFile();
        System.out.println("\nGet GPA: ");
        fh.getGpa();
    }
}
