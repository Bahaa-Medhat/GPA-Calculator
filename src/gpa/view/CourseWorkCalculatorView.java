package gpa.view;

import gpa.model.CourseWork;
import gpa.model.GPACalculator;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CourseWorkCalculatorView {
	private CourseWork model;
	private Spinner<Integer> numberOfSections;
	private VBox sectionField;
	private Button calculateCourseWorkButton;
	private Button addSectionsButton;
	private Label courseWorkLabel;
	private Spinner<String> totalGrade;
	private Button calculateFinalExamButton;
	private Label finalExamLabel;

	public Scene getScene(MainApp mainApp) {
		GridPane window = new GridPane();
		window.setVgap(10);
		window.setHgap(10);
		window.setStyle("-fx-background-color: royalblue; " + "-fx-padding: 20px;");

		sectionField = new VBox();
		sectionField.setSpacing(10);
		sectionField.setStyle("-fx-padding: 10px; " + "-fx-background-color: #f9f9f9; " + "-fx-border-color: #dddddd; "
				+ "-fx-border-width: 1px; " + "-fx-border-radius: 5px; " + "-fx-background-radius: 5px;");

		numberOfSections = new Spinner<>(1, 10, 1);
		addSectionsButton = new Button("Add Sections");
		addSectionsButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; " + "-fx-font-weight: bold; "
				+ "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		addSectionsButton.setOnAction(e -> {
			model = new CourseWork((int) numberOfSections.getValue());
			addSectionFields();
			addSectionsButton.setDisable(true);
		});

		calculateCourseWorkButton = new Button("Calculate Course Work");
		calculateCourseWorkButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		calculateCourseWorkButton.setOnAction(e -> courseWorkLabel.setText("Course Work: " + calculateCourseWork()));

		courseWorkLabel = new Label("Course Work:");
		courseWorkLabel.setStyle("-fx-font-size: 24px; " + "-fx-font-weight: bold; " + "-fx-text-fill: beige; "
				+ "-fx-padding: 16px; " + "-fx-background-radius: 5px;");

		totalGrade = new Spinner<String>();
		SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(
				FXCollections.observableArrayList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"));
		totalGrade.setValueFactory(valueFactory);

		calculateFinalExamButton = new Button("Calculate Final Exam Grade");
		calculateFinalExamButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		calculateFinalExamButton
				.setOnAction(e -> finalExamLabel.setText("Final Exam: " + calculateFinalExamGrade(totalGrade.getValue())+ "%"));

		finalExamLabel = new Label("Final Exam:");
		finalExamLabel.setStyle("-fx-font-size: 24px; " + "-fx-font-weight: bold; " + "-fx-text-fill: beige; "
				+ "-fx-padding: 16px; " + "-fx-background-radius: 5px;");

		Button switchToMainViewButton = new Button("Switch to GPA Calculator");
		switchToMainViewButton.setStyle("-fx-background-color: gold; " + "-fx-text-fill: black; "
				+ "-fx-font-weight: bold; " + "-fx-padding: 10px 20px; " + "-fx-background-radius: 5px;");
		switchToMainViewButton.setOnAction(e -> mainApp.closeCourseWorkView());

		window.add(numberOfSections, 0, 0);
		window.add(addSectionsButton, 1, 0);
		window.add(sectionField, 0, 1, 2, 1);
		window.add(calculateCourseWorkButton, 0, 2);
		window.add(totalGrade, 0, 4);
		window.add(calculateFinalExamButton, 1, 4);
		window.add(courseWorkLabel, 0, 6, 2, 1);
		window.add(finalExamLabel, 0, 7, 2, 1);
		window.add(switchToMainViewButton, 1, 8);

		return new Scene(window, 600, 600);
	}

	private void addSectionFields() {
		sectionField.getChildren().clear();
		for (int i = 0; i < numberOfSections.getValue(); i++) {
			HBox fields = new HBox();
			fields.setSpacing(10);

			TextField sectionNameField = new TextField();
			sectionNameField.setPromptText("Section Name");
			sectionNameField.setStyle("-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; "
					+ "-fx-border-color: #cccccc; " + "-fx-border-width: 1px; " + "-fx-background-radius: 5px; "
					+ "-fx-padding: 5px;");

			TextField gradeField = new TextField();
			gradeField.setPromptText("Grade");
			gradeField.setStyle("-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; "
					+ "-fx-border-color: #cccccc; " + "-fx-border-width: 1px; " + "-fx-background-radius: 5px; "
					+ "-fx-padding: 5px;");

			TextField weightField = new TextField();
			weightField.setPromptText("Weight");
			weightField.setStyle("-fx-prompt-text-fill: #aaaaaa; " + "-fx-background-color: #ffffff; "
					+ "-fx-border-color: #cccccc; " + "-fx-border-width: 1px; " + "-fx-background-radius: 5px; "
					+ "-fx-padding: 5px;");

			fields.getChildren().addAll(sectionNameField, gradeField, weightField);
			fields.setAlignment(Pos.TOP_CENTER);

			sectionField.getChildren().add(fields);
		}
	}

	private String calculateCourseWork() {
		String[] sections = new String[model.getNumberOfSections()];
		double[] grades = new double[model.getNumberOfSections()];
		double[] weights = new double[model.getNumberOfSections()];

		for (int i = 0; i < model.getNumberOfSections(); i++) {
			HBox field = (HBox) sectionField.getChildren().get(i);

			TextField sectionNameField = (TextField) field.getChildren().get(0);
			TextField gradeField = (TextField) field.getChildren().get(1);
			TextField weightField = (TextField) field.getChildren().get(2);

			sections[i] = sectionNameField.getText();
			grades[i] = Double.parseDouble(gradeField.getText());
			weights[i] = Double.parseDouble(weightField.getText());
		}

		model.setSections(sections);
		model.setGrades(grades);
		model.setWeight(weights);

		return model.calculateCourseWork();
	}

	private String calculateFinalExamGrade(String grade) {
		GPACalculator calculator = new GPACalculator();
		double totalGrade = calculator.courseGrade(grade);
		
		double finalExam = 0;
		double finalWeight = 100;
		double[] weights = model.getWeight();
		for (int i = 0; i < model.getNumberOfSections(); i++) {
			finalWeight -= weights[i];
		}

		double courseWork = Double.parseDouble(model.calculateCourseWork().substring(0, 4));
		finalExam = (totalGrade - courseWork) / finalWeight;

		return String.format("%.3f",finalExam * 100);
	}
}
