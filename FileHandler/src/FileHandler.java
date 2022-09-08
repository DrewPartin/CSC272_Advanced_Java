// Create a java class FileHandler in a program that reads and writes grades data from a text file on disk and performs some simple calculations on that data in the following ways: Use a looping (repetition) construct that allows the user to enter as much grade data as possible with a sentinel to end the loop and write the data to disk and close the file.Use a second looping contruct that allows the user to open and read a disk file and retrieve grades from it.                                                                                                

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {

    double grade;
    List<Double> grades = new ArrayList<Double>();
    String yourGrade;
    double yourGpa;

    public void writeToFile() throws IOException {
        PrintWriter pw = new PrintWriter("grades.txt");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a grade or -1 to quit");
        grade = input.nextDouble();
        while (grade != -1) {
            pw.println(grade);
            System.out.println("Enter next grade or -1 to end.");
            grade = input.nextDouble();
        }
        pw.println();
        pw.close();
        input.close();
    }

    public void writeToFileFX() throws IOException {
        PrintWriter pw = new PrintWriter("grades.txt");
        for (int i = 0; i < grades.size(); i++) {
            pw.println(grades.get(i));
        }
        pw.println();
        pw.close();
    }

    public void readFromFile() throws IOException {
        FileReader fr = new FileReader("grades.txt");
        Scanner input = new Scanner(fr);
        while (input.hasNext()) {
            grade = input.nextDouble();
            System.out.println(grade);
            grades.add(grade);
        }
        input.close();
    }

    public List<Double> readFromFileFX() throws IOException {
        FileReader fr = new FileReader("grades.txt");
        Scanner input = new Scanner(fr);
        while (input.hasNext()) {
            grade = input.nextDouble();
        }
        input.close();
        return grades;
    }

    public void getGpa() {
        double sum = 0;
        double average = 0;
        String[] letterGrades = new String[] { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F" };
        double[] gpa = new double[] { 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0 };
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        average = sum / grades.size();
        if (average >= 95){
            yourGrade = letterGrades[0];
            yourGpa = gpa[0];
        }
        else if (average >= 90){
            yourGrade = letterGrades[1];
            yourGpa = gpa[1];
        }
        else if (average >= 87){
            yourGrade = letterGrades[2];
            yourGpa = gpa[2];
        }
        else if (average >= 83){
            yourGrade = letterGrades[3];
            yourGpa = gpa[3];
        }
        else if (average >= 80){
            yourGrade = letterGrades[4];
            yourGpa = gpa[4];
        }
        else if (average >= 77){
            yourGrade = letterGrades[5];
            yourGpa = gpa[5];
        }
        else if (average >= 73){
            yourGrade = letterGrades[6];
            yourGpa = gpa[6];
        }
        else if (average >= 70){
            yourGrade = letterGrades[7];
            yourGpa = gpa[7];
        }
        else if (average >= 67){
            yourGrade = letterGrades[8];
            yourGpa = gpa[8];
        }
        else if (average >= 63){
            yourGrade = letterGrades[9];
            yourGpa = gpa[9];
        }
        else if (average >= 60){
            yourGrade = letterGrades[10];
            yourGpa = gpa[10];
        }
        else {
            yourGrade = letterGrades[11];
            yourGpa = gpa[11];
        }
        System.out.println("Your GPA is: (" + yourGpa + ") " + yourGrade + "\n");
    }
}
