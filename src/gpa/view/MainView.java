package gpa.view;

import gpa.controller.GPAController;
import gpa.model.Course;
import gpa.model.GPACalculator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application {
	GPACalculator model;
	Label title;
	VBox courseFieldsContainer;
	Button addCourseButton;
	Button calculateGPAButton;
	Label gpaLabel;

	public void start(Stage primaryStage) throws Exception {
		model = new GPACalculator();

		VBox window = new VBox();
		window.setSpacing(10);
		window.setStyle("-fx-background-color: royalblue; " + "-fx-padding: 20px;");

		title = new Label("GPA Calculator");
		title.setStyle(
				"-fx-font-size: 36px; " + "-fx-font-weight: bold; " + "-fx-text-fill: white; " + "-fx-padding: 20px; ");

		courseFieldsContainer = new VBox();
		courseFieldsContainer.setSpacing(10);
		courseFieldsContainer
				.setStyle("-fx-padding: 10px; " + "-fx-background-color: #f9f9f9; " + "-fx-border-color: #dddddd; "
						+ "-fx-border-width: 1px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");
		addCourseFields();

		HBox buttonField = new HBox();
		buttonField.setSpacing(10);
		buttonField.setAlignment(Pos.TOP_CENTER);

		addCourseButton = new Button("Add Course");
		addCourseButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; " + "-fx-font-weight: bold; "
				+ "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		addCourseButton.setOnAction(event -> addCourse());

		calculateGPAButton = new Button("Calculate GPA");
		calculateGPAButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		calculateGPAButton.setOnAction(event -> {
			GPAController controller = new GPAController(model, this);
			controller.handleCalculateGPA();
		});

		buttonField.getChildren().addAll(addCourseButton, calculateGPAButton);

		gpaLabel = new Label();
		gpaLabel.setStyle("-fx-font-size: 24px; " + "-fx-font-weight: bold; " + "-fx-text-fill: beige; "
				+ "-fx-padding: 16px; " + "-fx-background-radius: 5px;");

		window.getChildren().addAll(title, courseFieldsContainer, buttonField, gpaLabel);
		window.setAlignment(Pos.TOP_CENTER);

		Scene scene = new Scene(window, 600, 600);
		primaryStage.setScene(scene);
		primaryStage.setTitle("GPA Calculator");
		primaryStage.show();
	}

	private void addCourseFields() {
		HBox fields = new HBox();
		fields.setSpacing(10);

		TextField courseNameField = new TextField();
		courseNameField.setPromptText("Course Name");
		courseNameField.setStyle(
				"-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; " + "-fx-border-color: #cccccc; "
						+ "-fx-border-width: 1px; " + "-fx-background-radius: 5px; " + "-fx-padding: 5px;");

		TextField gradeField = new TextField();
		gradeField.setPromptText("Grade");
		gradeField.setStyle(
				"-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; " + "-fx-border-color: #cccccc; "
						+ "-fx-border-width: 1px; " + "-fx-background-radius: 5px; " + "-fx-padding: 5px;");

		TextField creditHoursField = new TextField();
		creditHoursField.setPromptText("Credit Hours");
		creditHoursField.setStyle(
				"-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; " + "-fx-border-color: #cccccc; "
						+ "-fx-border-width: 1px; " + "-fx-background-radius: 5px; " + "-fx-padding: 5px;");

		Button edit = new Button("Edit");
		edit.setStyle("-fx-background-color: red; " + "-fx-text-fill: white; " + "-fx-font-weight: bold; ");
		GPAController controller = new GPAController(model, this);
		controller.handleEditButton(edit, courseNameField, gradeField, creditHoursField);

		fields.getChildren().addAll(courseNameField, gradeField, creditHoursField, edit);
		fields.setAlignment(Pos.TOP_CENTER);
		courseFieldsContainer.getChildren().add(fields);
	}

	private void addCourse() {
		try {
			HBox lastFields = (HBox) courseFieldsContainer.getChildren()
					.get(courseFieldsContainer.getChildren().size() - 1);
			
			TextField courseNameField = (TextField) lastFields.getChildren().get(0);
			TextField gradeField = (TextField) lastFields.getChildren().get(1);
			TextField creditHoursField = (TextField) lastFields.getChildren().get(2);

			String courseName = courseNameField.getText();
			String grade = gradeField.getText().toUpperCase();
			int creditHours = Integer.parseInt(creditHoursField.getText());

			Course course = new Course(courseName, grade, creditHours);
			model.addCourse(course);
			
			if(model.getCourses().size() > 1) {
				HBox beforeLastFields = (HBox) courseFieldsContainer.getChildren()
						.get(courseFieldsContainer.getChildren().size() - 2);
				beforeLastFields.getChildren().get(3).setDisable(true);;
			}
			addCourseFields();
		} catch (NumberFormatException e) {
			showAlert("Invalid Credit Hours", "Please enter a valid credit hours");
		}

	}

	public void displayGPA(String gpa) {
		gpaLabel.setText(gpa);
	}

	public void showAlert(String title, String message) {
	    Alert alert = new Alert(AlertType.WARNING);
	    alert.setTitle(title);
	    alert.setHeaderText(null);
	    alert.setContentText(message);

	    // Style the dialog pane
	    DialogPane dialogPane = alert.getDialogPane();
	    dialogPane.setStyle(
	        "-fx-background-color: gold; " +
	        "-fx-border-color: black; " +
	        "-fx-border-width: 2px; " +
	        "-fx-border-radius: 5px; " +
	        "-fx-background-radius: 5px;"
	    );

	    Node content = dialogPane.lookup(".content");
	    if (content != null) {
	        content.setStyle(
	            "-fx-text-fill: black; " +
	            "-fx-font-weight: bold; " +
	            "-fx-padding: 10px;"
	        );
	    }

	    Node buttonBar = dialogPane.lookup(".button-bar");
	    if (buttonBar != null) {
	        buttonBar.setStyle(
	            "-fx-background-color: #FFD700; " +
	            "-fx-padding: 10px;"
	        );
	    }

	    alert.showAndWait();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
