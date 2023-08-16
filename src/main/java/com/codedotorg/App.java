package com.codedotorg;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        ByteBud chat = new ByteBud(primaryStage, 400, 450);
        chat.startApp();
    }

}