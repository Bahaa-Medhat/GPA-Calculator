package gpa.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showCourseWorkCalculatorView();
    }

    public void showCourseWorkCalculatorView() {
        CourseWorkCalculatorView courseWorkCalculatorView = new CourseWorkCalculatorView();
        Scene scene = courseWorkCalculatorView.getScene(this);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Course Work Calculator");
        primaryStage.show();
    }

    public void showMainView() {
        MainView mainView = new MainView();
        Scene scene = mainView.getScene(this);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GPA Calculator");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
