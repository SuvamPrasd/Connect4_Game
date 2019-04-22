package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        controller = loader.getController();
        controller.createPlayground();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Conect Four");
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public MenuBar createMenu(){
        Menu fileMenu = new Menu("File");
        MenuItem newItem = new MenuItem("New");
        newItem.setOnAction(event -> resetGame());

        MenuItem resetItem = new MenuItem("Reset");
        resetItem.setOnAction(event -> resetGame());

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem exitGame = new MenuItem("Exit");
        exitGame.setOnAction(event -> exitGame());
        fileMenu.getItems().addAll(newItem, resetItem, exitGame);

        //help menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutGame = new MenuItem("About Game");
        aboutGame.setOnAction(event -> aboutConnect4());

        SeparatorMenuItem separatorMenuItem1 = new SeparatorMenuItem();
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());
        helpMenu.getItems().addAll(aboutGame, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutMe() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About The Developer");
        alert.setHeaderText("Suvam Prasad");
        alert.setContentText("I love to play this game when i was in childhood. Connect 4 is a pretty awesome game." +
		        " This game includes two player. I made this game for connect four game lover and sure you will" +
		        " be excited after playing this game. Thank You");
        alert.show();
    }

    private void aboutConnect4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About Connect Four");
        alert.setHeaderText("How To Play ?");
        alert.setContentText("Connect Four is a two-player connection game in which the players first " +
		        "choose a color and then take turns dropping one colored disc from the top into seven-column " +
		        ", six-row vertically suspended grid. The pieces fall straight down, occupying the lowest available " +
		        "space within the column. The objective of the game is to be the first to form a horizontal, " +
		        "vertical, or diagonal line of four of one's own discs. The first player can always win " +
		        "by playing the right moves.");
        alert.show();
    }

    private void exitGame() {
        Platform.exit();
        System.exit(0);
    }

    private void resetGame() {
        controller.resetGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
