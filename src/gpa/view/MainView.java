package gpa.view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainView extends Application{

	Label title;
	VBox courseNameField; 
	VBox gradeField;
	VBox creditHoursField;
	Button addCourseButton;
	Button calculateGPAButton;
	Label gpaLabel;
	
	public void start(Stage primaryStage) throws Exception {
		VBox components = new VBox();
		
		title = new Label("GPA Calculator");
		title.setStyle(
	            "-fx-font-size: 36px; " +
	            "-fx-font-weight: bold; " +
	            "-fx-text-fill: #333333; " +  // Dark gray text color
	            "-fx-padding: 20px; " +
	            "-fx-background-color: #f0f0f0; " +  // Light gray background
	            "-fx-border-color: #cccccc; " +  // Light gray border
	            "-fx-border-width: 2px; " +
	            "-fx-border-radius: 5px; " +
	            "-fx-background-radius: 5px;"
	        );
		
		
		HBox fields = new HBox();
		
		courseNameField = new VBox();
		Label courseNameLabel  = new Label("Course Name:");
		setFont(courseNameLabel);
		courseNameField.getChildren().add(courseNameLabel);
		
		gradeField = new VBox();
		Label gradeLabel  = new Label("Grade:");
		setFont(gradeLabel);
		gradeField.getChildren().add(gradeLabel);
		
		creditHoursField = new VBox();
		Label creditHoursLabel  = new Label("Credit Hours:");
		setFont(creditHoursLabel);
		creditHoursField.getChildren().add(creditHoursLabel);
		
		fields.getChildren().addAll(courseNameField, gradeField, creditHoursField);

		
		HBox buttonField = new HBox();
		
		addCourseButton = new Button("Add Course");
		calculateGPAButton = new Button("Calculate GPA");
		
		buttonField.getChildren().addAll(addCourseButton, calculateGPAButton);
		
		
		gpaLabel = new Label();
		
		
		components.getChildren().addAll(title, fields, buttonField, gpaLabel);
		
		
		StackPane window = new StackPane();
		window.getChildren().add(components);
        StackPane.setAlignment(components, Pos.CENTER);
        
		Scene scene = new Scene(window, 1000, 600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("GPA Calculator");
	}

	private void setFont(Label label) {
		label.setStyle(
				"-fx-font-size: 18px; " +
				"-fx-font-weight: normal; " +
				"-fx-text-fill: #666666; " +  // Lighter gray text color
				"-fx-padding: 10px; "
		);
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
