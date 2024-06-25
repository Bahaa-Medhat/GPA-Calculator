package gpa.model;

public class Course {
	private String courseName;
	private double grade;
	private int creditHours;

	public Course(String courseName, int grade, int creditHours) {
		this.setCourseName(courseName);
		this.setGrade(grade);
		this.setCreditHours(creditHours);
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public String displayCourse() {
		return "Course Name: " + courseName + "\n Grade: " + grade + "\n Credit Hours: " + creditHours;
	}

}
