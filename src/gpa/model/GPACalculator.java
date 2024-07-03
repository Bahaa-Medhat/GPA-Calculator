package gpa.model;

import java.util.ArrayList;

public class GPACalculator {
	private ArrayList<Course> courses;

	public GPACalculator() {
		this.courses = new ArrayList<Course>();
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		courses.add(course);
	}

	public void removeCourse() {
		courses.remove(courses.size() - 1);
	}

	public double courseGrade(String gpa) {
		double grade = 0;
		switch (gpa) {
		case "A+":
			grade = 100;
			break;
		case "A":
			grade = 93.9;
			break;
		case "A-":
			grade = 89.9;
			break;
		case "B+":
			grade = 85.9;
			break;
		case "B":
			grade = 81.9;
			break;
		case "B-":
			grade = 77.9;
			break;
		case "C+":
			grade = 73.9;
			break;
		case "C":
			grade = 69.9;
			break;
		case "C-":
			grade = 64.9;
			break;
		case "D+":
			grade = 59.9;
			break;
		case "D":
			grade = 54.9;
			break;
		default:
			grade = 49.9;
		}
		return grade;
	}

	private double getCourseGpa(Course course) {
		String grade = course.getGrade();
		double gpa = 0;
		switch (grade) {
		case "A+":
			gpa = 0.7;
			break;
		case "A":
			gpa = 1.0;
			break;
		case "A-":
			gpa = 1.3;
			break;
		case "B+":
			gpa = 1.7;
			break;
		case "B":
			gpa = 2.0;
			break;
		case "B-":
			gpa = 2.3;
			break;
		case "C+":
			gpa = 2.7;
			break;
		case "C":
			gpa = 3.0;
			break;
		case "C-":
			gpa = 3.3;
			break;
		case "D+":
			gpa = 3.7;
			break;
		case "D":
			gpa = 4.0;
			break;
		default:
			gpa = 5.0;
		}

		return gpa;
	}

	public String calculateGPA() {
		String result = "Your GPA is ";
		double totalGrade = 0;
		int totalCreditHours = 0;
		double totalGpaGrade = 0;
		double gpaGrade = 0;
		double gpa = 0;
		String gpaLetter = "";

		for (Course course : courses) {
			totalCreditHours += course.getCreditHours();
			totalGrade += courseGrade(course.getGrade()) * course.getCreditHours();
			totalGpaGrade += getCourseGpa(course) * course.getCreditHours();
		}

		gpaGrade = totalGrade / totalCreditHours;

		if (gpaGrade >= 94 && gpaGrade <= 100) {
			gpaLetter = "A+";
		} else if (gpaGrade >= 90 && gpaGrade <= 93.9) {
			gpaLetter = "A";
		} else if (gpaGrade >= 86 && gpaGrade <= 89.9) {
			gpaLetter = "A-";
		} else if (gpaGrade >= 82 && gpaGrade <= 85.9) {
			gpaLetter = "B+";
		} else if (gpaGrade >= 78 && gpaGrade <= 81.9) {
			gpaLetter = "B";
		} else if (gpaGrade >= 74 && gpaGrade <= 77.9) {
			gpaLetter = "B-";
		} else if (gpaGrade >= 70 && gpaGrade <= 73.9) {
			gpaLetter = "C+";
		} else if (gpaGrade >= 65 && gpaGrade <= 69.9) {
			gpaLetter = "C";
		} else if (gpaGrade >= 60 && gpaGrade <= 64.9) {
			gpaLetter = "C-";
		} else if (gpaGrade >= 55 && gpaGrade <= 59.9) {
			gpaLetter = "D+";
		} else if (gpaGrade >= 50 && gpaGrade <= 54.9) {
			gpaLetter = "D";
		} else if (gpaGrade >= 0 && gpaGrade <= 49.9) {
			gpaLetter = "F";
		} else
			gpaLetter = "X";

		gpa = totalGpaGrade / totalCreditHours;
		
		return result + String.format("%.2f", gpa) + " [" + String.format("%.3f", gpaGrade) + "% (" + gpaLetter + ") " + "]";
	}
}
