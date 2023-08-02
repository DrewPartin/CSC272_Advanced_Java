import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// a) A standalone Java class called GradeAnalyzer that has methods to reads a set of grades into an internal relevant data structure from a flat file.
// b) Has a public methods that enables the user of this class to calculate (i) mean (m), (ii) standard deviation (s) of the exam scores using Java 8 Streams.
// c) A public method that allows the user to assign letter grades to each exam score (ES) as follows: 
//    ES >= m  +  1.5s =>  A
//    m + .5s =<  ES  < m  + 1.5s =>  B
//    m  - .5s =<  ES  < m  + .5s =>  C
//    m  -  1.5s  ES  =<  m - .5s =>  D
//    ES  < m – 1.5s =>  F
// d) Create a Java FX GUI application that uses GradeAnalyzer class to displays the grade distribution and letter grade for the given set of grades. To get credit you must use a Controller class and .fxml file as taught in class. A sample GUI form is shown on the next page. Use the test data shown to test your program.

public class GradeAnalyzer {
    private List<Integer> grades;
    private List<String> letterGrades;
    private double m;
    private double s;
    String letterGradesFile = "D:/GitRepos/CSC272_Advanced_Java/GradeAnalyzer/letterGrades.txt";
    String curvedGradesFile = "D:/GitRepos/CSC272_Advanced_Java/GradeAnalyzer/curvedGrades.txt";

    public GradeAnalyzer() {
        grades = new ArrayList<>();
        letterGrades = new ArrayList<>();
    }

    public void readGrades(String _fileName) throws IOException {;
        try (BufferedReader reader = new BufferedReader(new FileReader(_fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                grades.add(Integer.parseInt(line));
            }
        }
    }

    public void calculateMean() {
        m = grades.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public void calculateStandardDeviation() {
        double sum = grades.stream().mapToInt(Integer::intValue).mapToDouble(i -> Math.pow(i - m, 2)).sum();
        s = Math.sqrt(sum / (grades.size() - 1));
    }

    public void assignLetterGrades() throws IOException{
        letterGrades.clear();
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) >= 90) {
                letterGrades.add("A");
            } else if (grades.get(i) >= 80) {
                letterGrades.add("B");
            } else if (grades.get(i) >= 70) {
                letterGrades.add("C");
            } else if (grades.get(i) >= 60) {
                letterGrades.add("D");
            } else {
                letterGrades.add("F");
            }
        }
        FileWriter writer = new FileWriter(letterGradesFile, false);
        for (int i = 0; i < grades.size(); i++) {
            writer.write(grades.get(i) + "  " + letterGrades.get(i) + System.lineSeparator());
        }
        writer.close();
    }

    public void assignCurvedLetterGrades() throws IOException {
        letterGrades.clear();
        for (int grade : grades) {
            if (grade >= m + 1.5 * s) {
                letterGrades.add("A");
            } else if (grade >= m + 0.5 * s) {
                letterGrades.add("B");
            } else if (grade >= m - 0.5 * s) {
                letterGrades.add("C");
            } else if (grade >= m - 1.5 * s) {
                letterGrades.add("D");
            } else {
                letterGrades.add("F");
            }
        }
        FileWriter writer = new FileWriter(curvedGradesFile, false);
        for (int i = 0; i < grades.size(); i++) {
            writer.write(grades.get(i) + "  " + letterGrades.get(i) + System.lineSeparator());
        }
        writer.close();
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public List<String> getLetterGrades() {
        return letterGrades;
    }

    public double getMean() {
        return m;
    }

    public double getStdDev() {
        return s;
    }    
}
