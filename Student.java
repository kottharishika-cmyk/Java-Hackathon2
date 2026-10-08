import java.util.Scanner;

class student{
    
    private String studentName;
    private int rollNumber;
    private int marks;
    private String courseName;
    private int courseCredits;

   
    public student(String studentName, int rollNumber, int marks, String courseName, int courseCredits) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.marks = marks;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    
    public double calculateFee() {
        return courseCredits * 1500; 
    }

   
    public boolean checkEligibility() {
        return marks >= 50;
    }

    
    public double calculateScholarship() {
        if (marks >= 85) {
            return 20; 
        } else if (marks >= 70) {
            return 10; 
        } else {
            return 0; 
        }
    }

    
    public double calculateFinalFee() {
        double totalFee = calculateFee();
        double scholarshipPercent = calculateScholarship();
        double scholarshipAmount = (scholarshipPercent / 100) * totalFee;
        return totalFee - scholarshipAmount;
    }

    
    public void displayDetails() {
        System.out.println("\n--- Student Course Registration Details ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);

        if (checkEligibility()) {
            double totalFee = calculateFee();
            double scholarshipPercent = calculateScholarship();
            double scholarshipAmount = (scholarshipPercent / 100) * totalFee;
            double finalFee = calculateFinalFee();

            System.out.println("Eligibility: Eligible for registration");
            System.out.println("Total Fee: Rs. " + totalFee);
            System.out.println("Scholarship: " + scholarshipPercent + "% (Rs. " + scholarshipAmount + ")");
            System.out.println("Final Fee after Scholarship: Rs. " + finalFee);
        } else {
            System.out.println("Eligibility: Not eligible for registration (Marks below 50)");
        }
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        int marks = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        
        student student = new student(name, roll, marks, course, credits);

        
        student.displayDetails();

        sc.close();
    }
}
