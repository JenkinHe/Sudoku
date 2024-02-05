package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        uiImpl= new UserInterfaceImpl(stage);
        try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e){
            e.printStackTrace();
            throw e;
        }
    }
    public static void main(String[] args) {
        launch();
    }

}