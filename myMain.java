package com.intershala;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class myMain extends Application {

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void init() throws Exception {
		System.out.println("init");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("start");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();
		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);
		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temprature Convertor Tool");

		primaryStage.show();
	}

	private MenuBar createMenu() {
		//File Menu

		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("New Menu Item is Clicked "));
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});


		fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		MenuItem aboutMenuItem = new MenuItem("About");
		aboutMenuItem.setOnAction(event -> about());
		helpMenu.getItems().addAll(aboutMenuItem);

		//MENU BAR
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);
		return menuBar;

	}

	private void about() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("My First Desktop App");
		alert.setHeaderText("Learning JavaFX");
		alert.setContentText("I am just Beginner but soon  I will be pro and do Awesome Coding ");
		ButtonType yesBtn = new ButtonType("Yes");
		ButtonType noBtn = new ButtonType("No");
		alert.getButtonTypes().setAll(yesBtn, noBtn);
		Optional<ButtonType> clickedBtn = alert.showAndWait();
		if ( clickedBtn.isPresent() && clickedBtn.get() == yesBtn) {
			System.out.println("Yes button is clicked");
		}else{
			System.out.println("No button is clicked");
		}


	}

	@Override
	public void stop() throws Exception {
		System.out.println("Stop");
	}
}

