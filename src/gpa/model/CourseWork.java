package gpa.model;

public class CourseWork {
    private int numberOfSections;
    private String[] sections;
    private double[] grades;
    private double[] weight;
    
    public CourseWork(int numberOfSections) {
        this.setNumberOfSections(numberOfSections);
        this.setSections(new String[numberOfSections]);
        this.setGrades(new double[numberOfSections]);
        this.setWeight(new double[numberOfSections]);
    }

    public int getNumberOfSections() {
        return numberOfSections;
    }

    public void setNumberOfSections(int numberOfSections) {
        this.numberOfSections = numberOfSections;
    }

    public String[] getSections() {
        return sections;
    }

    public void setSections(String[] sections) {
        this.sections = sections;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public double[] getWeight() {
        return weight;
    }

    public void setWeight(double[] weight) {
        this.weight = weight;
    }
    
    public String calculateCourseWork() {
        String result = "";
        double totalGrade = 0;
        double totalWeight = 0;
        
        for (int i = 0; i < numberOfSections; i++) {
            totalGrade += grades[i] * weight[i];
            totalWeight += weight[i];
        }
        
        result += totalGrade + "/" + totalWeight; 
        
        return result;
    }
    
}
