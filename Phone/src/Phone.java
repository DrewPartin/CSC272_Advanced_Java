import java.io.*;
import java.util.Scanner;

public class Phone {
    String phoneNumber;
    String[][] letters = {{"0"}, {"1"}, {"A","B","C"}, {"D","E","F"}, {"G","H","I"}, {"J","K","L"}, {"M","N","O"}, {"P","Q","R","S"}, {"T","U","V"}, {"W","X","Y","Z"}};
    private ObjectOutputStream output;
    PrintStream printStream;
    char[] word = new char[7];

    public void calculate(int n) throws Exception {
        phoneNumber = String.valueOf(n);
        try {
            output = new ObjectOutputStream(new FileOutputStream ("NumberCombinations.txt"));
            printStream = new PrintStream(output);
            char[] stringToChars = phoneNumber.toCharArray();
            int[] numbers = new int[stringToChars.length];
            for (int c = 0; c < stringToChars.length; c++) {
                numbers[c] = Integer.parseInt(String.valueOf(stringToChars[c]));
            }
            
            System.out.print("Would you like the file to contain spaces between lines? (y/n): ");
            Scanner ans = new Scanner(System.in);
            String answer = ans.next().toLowerCase();
            if (answer.equals("y")) {
                System.out.println("The file will contain spaces between lines.");
            }
            else if (answer.equals("n")) {
                System.out.println("The file will not contain spaces between lines.");
            }
            else {
                System.out.println("Invalid response. File will default to not containing spaces between lines.");
            }
            ans.close();

            for (int i = 0; i < letters[numbers[0]].length; i++) {
                word[0] = letters[numbers[0]][i].charAt(0);
                for (int j = 0; j < letters[numbers[1]].length; j++) {
                    word[1] = letters[numbers[1]][j].charAt(0);
                    for (int k = 0; k < letters[numbers[2]].length; k++) {
                        word[2] = letters[numbers[2]][k].charAt(0);
                        for (int l = 0; l < letters[numbers[3]].length; l++) {
                            word[3] = letters[numbers[3]][l].charAt(0);
                            for (int m = 0; m < letters[numbers[4]].length; m++) {
                                word[4] = letters[numbers[4]][m].charAt(0);
                                for (int o = 0; o < letters[numbers[5]].length; o++) {
                                    word[5] = letters[numbers[5]][o].charAt(0);
                                    for (int p = 0; p < letters[numbers[6]].length; p++) {
                                        word[6] = letters[numbers[6]][p].charAt(0);
                                        printStream.println(word);
                                        if (answer.equals("y")) {
                                            printStream.printf("%n");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("Word combinations written to file: NumberCombinations.txt\n");
            System.exit(1);
        }

        catch (Exception exception) {
            System.err.println( "Error writing to file");
            System.exit(1);
        }
    }
}
