import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FileHandlerController {

    FileHandler fh = new FileHandler();

    @FXML
    private TextArea displayArea;

    @FXML
    private TextField gradeInput;

    @FXML
    void addGradeButtonPressed(ActionEvent event) {
        fh.grade = Double.parseDouble(gradeInput.getText());
        fh.grades.add(fh.grade);
        gradeInput.clear();
        displayArea.setText(null);
        displayArea.appendText("Grades added: " + fh.grades);
    }

    @FXML
    void calculateButtonPressed(ActionEvent event) throws IOException {
        displayArea.setText(null);
        fh.writeToFileFX();
        fh.getGpa();
        displayArea.setText("Your grades are: " + fh.readFromFileFX() + "\n\nYour GPA is: (" + fh.yourGpa + ") " + fh.yourGrade + "\n");
    }

    @FXML
    void okButtonPressed(ActionEvent event) {
        displayArea.setText(null);
        displayArea.setText("Goodbye!");
        System.exit(1);
    }
}

