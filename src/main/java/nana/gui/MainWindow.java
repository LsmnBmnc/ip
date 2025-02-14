package nana.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import nana.logic.Nana;

public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Nana nana;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/nana/gui/User.jpg.png"));
    private Image nanaImage = new Image(this.getClass().getResourceAsStream("/nana/gui/Nana.jpg.png"));

    @FXML
    public void initialize() {
        dialogContainer.heightProperty().addListener((observable) -> scrollPane.setVvalue(1.0));

        userInput.setOnAction((event) -> {
            handleUserInput();
        });
    }

    /** Injects the Duke instance */
    public void setNana(Nana n) {
        nana = n;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = nana.getResponse(input);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage),
                DialogBox.getNanaDialog(response, nanaImage)
        );
        userInput.clear();
    }
}
