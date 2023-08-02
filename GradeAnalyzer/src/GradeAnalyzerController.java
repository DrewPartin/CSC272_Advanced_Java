import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class GradeAnalyzerController {

    GradeAnalyzer ga = new GradeAnalyzer();
    String fileName = "D:/GitRepos/CSC272_Advanced_Java/GradeAnalyzer/grades.txt";

    @FXML
    private TextArea display;

    @FXML
    void initializeButtonPressed(ActionEvent event) throws IOException {
        ga.readGrades(fileName);
        ga.calculateMean();
        ga.calculateStandardDeviation();
    }

    @FXML
    void calculateCurvedGradesButtonPressed(ActionEvent event) {
        display.clear();
        try {
            ga.assignCurvedLetterGrades();
        }
        catch (IOException e) {
            display.setText("Error reading file");
            e.printStackTrace();
        }
        for (int i = 0; i < ga.getGrades().size(); i++) {
            display.appendText(ga.getGrades().get(i) + "  " + ga.getLetterGrades().get(i) + System.lineSeparator());
        }
    }

    @FXML
    void calculateGradesButtonPressed(ActionEvent event) {
        display.clear();
        try {
            ga.assignLetterGrades();
        }
        catch (IOException e) {
            display.setText("Error reading file");
            e.printStackTrace();
        }
        for (int i = 0; i < ga.getGrades().size(); i++) {
            display.appendText(ga.getGrades().get(i) + "  " + ga.getLetterGrades().get(i) + System.lineSeparator());
        }
    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        System.exit(0);
    }

}

