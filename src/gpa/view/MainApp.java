package gpa.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private Stage courseWorkStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		showMainView();
	}

	public void showCourseWorkCalculatorView() {
		if (courseWorkStage != null)
			courseWorkStage.close();

		courseWorkStage = new Stage();
		CourseWorkCalculatorView courseWorkCalculatorView = new CourseWorkCalculatorView();
		Scene scene = courseWorkCalculatorView.getScene(this);
		courseWorkStage.setScene(scene);
		courseWorkStage.setTitle("Course Work Calculator");
		courseWorkStage.show();

	}

	public void showMainView() {
		MainView mainView = new MainView();
		Scene scene = mainView.getScene(this);
		primaryStage.setScene(scene);
		primaryStage.setTitle("GPA Calculator");
		primaryStage.show();
	}
	
	public void closeCourseWorkView() {
		courseWorkStage.close();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
