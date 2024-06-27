package gpa.view;

import gpa.controller.GPAController;
import gpa.model.Course;
import gpa.model.GPACalculator;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
		window.setStyle("-fx-background-color: linear-gradient(to bottom, #ffffff, #f0f0f0); " + "-fx-padding: 20px;");

		title = new Label("GPA Calculator");
		title.setStyle("-fx-font-size: 36px; " + "-fx-font-weight: bold; " + "-fx-text-fill: #333333; "
				+ "-fx-padding: 20px; " + "-fx-background-color: #ffffff; " + "-fx-border-color: #cccccc; "
				+ "-fx-border-width: 2px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");

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
		addCourseButton.setStyle("-fx-background-color: #4caf50; " + "-fx-text-fill: white; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		addCourseButton.setOnAction(event -> addCourse());

		calculateGPAButton = new Button("Calculate GPA");
		calculateGPAButton.setStyle("-fx-background-color: #2196f3; " + "-fx-text-fill: white; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		calculateGPAButton.setOnAction(event -> {
			GPAController controller = new GPAController(model, this);
			controller.handleCalculateGPA();
		});

		buttonField.getChildren().addAll(addCourseButton, calculateGPAButton);

		gpaLabel = new Label();
		gpaLabel.setStyle("-fx-font-size: 24px; " + "-fx-font-weight: bold; " + "-fx-text-fill: #333333; "
				+ "-fx-padding: 16px; " + "-fx-background-color: #ffffff; " + "-fx-border-color: #cccccc; "
				+ "-fx-border-width: 2px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");

		window.getChildren().addAll(title, courseFieldsContainer, buttonField, gpaLabel);
		window.setAlignment(Pos.TOP_CENTER);

		Scene scene = new Scene(window, 450, 600);
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

		fields.getChildren().addAll(courseNameField, gradeField, creditHoursField);
		fields.setAlignment(Pos.TOP_CENTER);
		courseFieldsContainer.getChildren().add(fields);
	}

	private void addCourse() {
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

		addCourseFields();
	}

	public void displayGPA(String gpa) {
		gpaLabel.setText(gpa);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
