package gpa.model;

import java.util.ArrayList;

public class GPACalculator {
	private ArrayList<Course> courses;

	public GPACalculator() {
		this.courses = new ArrayList<Course>();
	}

	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public void removeCourse() {
		courses.remove(courses.size() - 1);
	}

	public double courseGrade(String gpa) {
		double grade = 0;
		switch(gpa) {
		case "A+": grade = 100;break;
		case "A": grade = 93.9;break;
		case "A-": grade = 89.9;break;
		case "B+": grade = 85.9;break;
		case "B": grade = 81.9;break;
		case "B-": grade = 77.9;break;
		case "C+": grade = 73.9;break;
		case "C": grade = 69.9;break;
		case "C-": grade = 64.9;break;
		case "D+": grade = 59.9;break;
		case "D": grade = 54.9;break;
		default: grade = 49.9;
		}
		return grade;
	}

	public String calculateGPA() {
		String result = "Your GPA is ";
		double totalGrade = 0;
		int totalCreditHours = 0;
		double gpaGrade = 0;
		double gpa = 0;
		String gpaLetter = "";


		for (Course course : courses) {
			totalCreditHours += course.getCreditHours();
			totalGrade += courseGrade(course.getGrade()) * course.getCreditHours();
		}

		gpaGrade = totalGrade / totalCreditHours;

		if (gpaGrade >= 94 && gpaGrade <= 100) {
			gpa = 0.7;
			gpaLetter = "A+";
		} else if (gpaGrade >= 90 && gpaGrade <= 93.9) {
			gpa = 1.0;
			gpaLetter = "A";
		} else if (gpaGrade >= 86 && gpaGrade <= 89.9) {
			gpa = 1.3;
			gpaLetter = "A-";
		} else if (gpaGrade >= 82 && gpaGrade <= 85.9) {
			gpa = 1.7;
			gpaLetter = "B+";
		} else if (gpaGrade >= 78 && gpaGrade <= 81.9) {
			gpa = 2.0;
			gpaLetter = "B";
		} else if (gpaGrade >= 74 && gpaGrade <= 77.9) {
			gpa = 2.3;
			gpaLetter = "B-";
		} else if (gpaGrade >= 70 && gpaGrade <= 73.9) {
			gpa = 2.7;
			gpaLetter = "C+";
		} else if (gpaGrade >= 65 && gpaGrade <= 69.9) {
			gpa = 3.0;
			gpaLetter = "C";
		} else if (gpaGrade >= 60 && gpaGrade <= 64.9) {
			gpa = 3.3;
			gpaLetter = "C-";
		} else if (gpaGrade >= 55 && gpaGrade <= 59.9) {
			gpa = 3.7;
			gpaLetter = "D+";
		} else if (gpaGrade >= 50 && gpaGrade <= 54.9) {
			gpa = 4.0;
			gpaLetter = "D";
		} else if (gpaGrade >= 0 && gpaGrade <= 49.9) {
			gpa = 5.0;
			gpaLetter = "F";
		} else
			gpaLetter = "X";

		return result + gpa + " [" + String.format("%.3f",gpaGrade) + "% (" + gpaLetter + ") " + "]";
	}
}
