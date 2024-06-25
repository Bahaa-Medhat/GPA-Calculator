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
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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

		VBox components = new VBox();
		components.setSpacing(10);

		title = new Label("GPA Calculator");
		title.setStyle("-fx-font-size: 36px; " + "-fx-font-weight: bold; " + "-fx-text-fill: #333333; "
				+ "-fx-padding: 20px; " + "-fx-background-color: #f0f0f0; " + "-fx-border-color: #cccccc; "
				+ "-fx-border-width: 2px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");

		courseFieldsContainer = new VBox();
		courseFieldsContainer.setSpacing(10);
		addCourseFields();

		HBox buttonField = new HBox();
		buttonField.setSpacing(10);

		addCourseButton = new Button("Add Course");
		addCourseButton.setOnAction(event -> addCourse());

		calculateGPAButton = new Button("Calculate GPA");
		calculateGPAButton.setOnAction(event -> {
			GPAController controller = new GPAController(model, this);
			controller.handleCalculateGPA();
		});

		buttonField.getChildren().addAll(addCourseButton, calculateGPAButton);

		gpaLabel = new Label();

		components.getChildren().addAll(title, courseFieldsContainer, buttonField, gpaLabel);

		StackPane window = new StackPane();
		window.getChildren().add(components);
		StackPane.setAlignment(components, Pos.CENTER);

		Scene scene = new Scene(window, 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("GPA Calculator");
	}

	private void addCourseFields() {
		HBox fields = new HBox();
		fields.setSpacing(10);

		TextField courseNameField = new TextField();
		courseNameField.setPromptText("Course Name");

		TextField gradeField = new TextField();
		gradeField.setPromptText("Grade");

		TextField creditHoursField = new TextField();
		creditHoursField.setPromptText("Credit Hours");

		fields.getChildren().addAll(courseNameField, gradeField, creditHoursField);
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
