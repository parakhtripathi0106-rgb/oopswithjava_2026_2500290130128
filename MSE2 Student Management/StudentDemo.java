
import java.util.ArrayList;
import java.util.List;

class Student {

    // Data members
    private int studentId;
    private String studentName;
    private String email;
    private String courseName;
    private double programmingScore;
    private double mathematicsScore;
    private List<String> technicalSkills;

    // Constructor
    Student(int studentId, String studentName, String email,
            String courseName, double programmingScore,
            double mathematicsScore, List<String> technicalSkills) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.courseName = courseName;
        this.programmingScore = programmingScore;
        this.mathematicsScore = mathematicsScore;
        this.technicalSkills = new ArrayList<>(technicalSkills);
    }

    // Getters and Setters

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(double programmingScore) {
        this.programmingScore = programmingScore;
    }

    public double getMathematicsScore() {
        return mathematicsScore;
    }

    public void setMathematicsScore(double mathematicsScore) {
        this.mathematicsScore = mathematicsScore;
    }

    public List<String> getTechnicalSkills() {
        return new ArrayList<>(technicalSkills);
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = new ArrayList<>(technicalSkills);
    }

    // Method to add a technical skill
    public void addSkill(String skill) {
        technicalSkills.add(skill);
    }

    // Method to calculate average score
    public double calculateAverage() {
        return (programmingScore + mathematicsScore) / 2;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Email: " + email);
        System.out.println("Course Name: " + courseName);
        System.out.println("Programming Score: " + programmingScore);
        System.out.println("Mathematics Score: " + mathematicsScore);
        System.out.println("Technical Skills: " + technicalSkills);
        System.out.println("Average Score: " + calculateAverage());
    }
}

public class StudentDemo {
    public static void main(String[] args) {

        List<String> skills = new ArrayList<>();

        skills.add("Java");
        skills.add("Python");
        skills.add("HTML");
        skills.add("CSS");

        Student s1 = new Student(
            101,
            "Parakh",
            "parakh@gmail.com",
            "B.Tech IT",
            88.5,
            92.0,
            skills
        );

        s1.displayDetails();

        // Updating student email using setter
        s1.setEmail("student@gmail.com");

        // Adding one more skill
        s1.addSkill("JavaScript");

        System.out.println("\nAfter Updating Details:");
        s1.displayDetails();
    }
}
