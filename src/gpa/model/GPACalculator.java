package gpa.model;

import java.util.ArrayList;

public class GPACalculator {
	ArrayList<Course> courses;
	
	public GPACalculator(){
		this.courses = new ArrayList<Course>();
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public String gpaLetter(double gpa) {
		String letter = "";
		
		if(gpa >= 0.7 && gpa <= 0.99)
			letter = "A+";
		else if(gpa >= 1.0 && gpa <= 1.29)
			letter = "A";
		else if(gpa >= 1.3 && gpa <= 1.69)
			letter = "A-";
		else if(gpa >= 1.7 && gpa <= 1.99)
			letter = "B+";
		else if(gpa >= 2.0 && gpa <= 2.29)
			letter = "B";
		else if(gpa >= 2.3 && gpa <= 2.69)
			letter = "B-";
		else if(gpa >= 2.7 && gpa <= 2.99)
			letter = "C+";
		else if(gpa >= 3.0 && gpa <= 3.29)
			letter = "C";
		else if(gpa >= 3.3 && gpa <= 3.69)
			letter = "C-";
		else if(gpa >= 3.7 && gpa <= 3.99)
			letter = "D+";
		else if(gpa >= 4.0 && gpa <= 4.99)
			letter = "D";
		else if(gpa >= 5.0 && gpa <= 6.00)
			letter = "F";
		else
			letter = "X";
		
		return letter;
	}
	
	public String calculateGPA() {
		String result = "Your GPA is ";
		double totalGrade = 0;
		int totalCreditHours = 0;
		double gpa = 0;
		String gpaLetter = "";
		
		for (Course course : courses) {
			totalCreditHours += course.getCreditHours();
			totalGrade += course.getGrade()*course.getCreditHours();
		}
		
		gpa = totalGrade / totalCreditHours;
		gpaLetter = gpaLetter(gpa);
		
		return result + gpa + "[" + gpaLetter + "]";
	}
}
