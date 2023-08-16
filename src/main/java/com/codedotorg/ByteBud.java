package com.codedotorg;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ByteBud {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The text box that displays the conversation */
    private TextArea conversation;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Constructs a new ByteBud object with the given Stage window, width and height.
     * Initializes a TextArea for conversation and sets it to wrap text.
     * Creates an input field using the createInputField() method.
     *
     * @param window the Stage window to display the ByteBud conversation
     * @param width the width of the ByteBud conversation window
     * @param height the height of the ByteBud conversation window
     */
    public ByteBud(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        conversation = new TextArea("");
        conversation.setWrapText(true);

        inputField = createInputField();
    }
    
    /**
     * Sets the title of the window to "ByteBud", creates the main scene, adds the
     * stylesheet to the scene, sets the scene to the window, and shows the window.
     */
    public void startApp() {
        window.setTitle("ByteBud");
        
        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the ByteBud application.
     * 
     * @return the main scene
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("ByteBud");
        titleLabel.setId("titleLabel");

        HBox inputLayout = createInputLayout();

        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(titleLabel, conversation, inputLayout);

        Scene mainScene = new Scene(mainLayout, width, height);
        
        return mainScene;
    }

    /**
     * Creates an HBox layout that contains a Label and an input field.
     * The Label displays the text "Type here: ".
     * 
     * @return the HBox layout containing the Label and input field
     */
    public HBox createInputLayout() {
        Label inputLabel = new Label("Type here: ");
        inputLabel.setPadding(new Insets(0, 5, 0, 0));

        HBox tempLayout = new HBox();
        tempLayout.getChildren().addAll(inputLabel, inputField);
        tempLayout.setAlignment(Pos.CENTER);
        
        return tempLayout;
    }

    /**
     * Creates a TextField for user input and sets an action
     * event to update the user and bot responses.
     * 
     * @return the created TextField
     */
    public TextField createInputField() {
        TextField tempField = new TextField();

        tempField.setOnAction(event -> {
            String userInput = tempField.getText();

            updateUserResponse(userInput);
            updateBotResponse(userInput);

            tempField.clear();
        });

        return tempField;
    }

    /**
     * Updates the conversation text with the user's input.
     * 
     * @param userInput the input provided by the user
     */
    public void updateUserResponse(String userInput) {
        conversation.appendText("You: " + userInput + "\n");
    }

    /**
     * Updates the bot response based on the user input.
     * 
     * @param userInput the input provided by the user
     */
    public void updateBotResponse(String userInput) {
        String botResponse = getResponse(userInput);
        conversation.appendText("ByteBud: " + botResponse + "\n");
    }

    /**
     * Processes the user's input and returns a response.
     * The input text is first converted to lower case to ensure case-insensitive matching.
     * If the input text doesn't match any of the predefined phrases, a default message is
     * returned indicating that the bot didn't understand the input.
     *
     * @param inputText The user's input text.
     * @return A string containing the bot's response.
     */
    private String getResponse(String inputText) {
        

        return "";
    }

}
