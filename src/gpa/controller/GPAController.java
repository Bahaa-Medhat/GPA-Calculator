package gpa.controller;

import gpa.model.GPACalculator;
import gpa.view.MainView;
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
}
