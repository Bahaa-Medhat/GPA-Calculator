package gpa.controller;

import gpa.model.Course;
import gpa.model.GPACalculator;
import gpa.view.MainView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GPAController {
	private GPACalculator model;
	private MainView view;

	public GPAController(GPACalculator model, MainView view) {
		this.model = model;
		this.view = view;
	}

	public void handleCalculateGPA() {
		String gpa = model.calculateGPA();
		view.displayGPA(gpa);
	}
	
	public void handleEditButton(Button edit, TextField courseNameField, TextField gradeField, TextField creditHoursField) {
		edit.setOnAction(e -> {
			try {
				if(!courseNameField.getText().equals(""))
					model.removeCourse();
				String courseName = courseNameField.getText();
				String grade = gradeField.getText().toUpperCase();
				int creditHours = Integer.parseInt(creditHoursField.getText());

				Course course = new Course(courseName, grade, creditHours);
				model.addCourse(course);
			} catch (IndexOutOfBoundsException e1) {
				view.showAlert("Invalid Action", "Cannot edit an empty course");
			} catch (NumberFormatException e2) {
				view.showAlert("Invalid Action", "Cannot edit an empty course");
			}
		});
	}
}
