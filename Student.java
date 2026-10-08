import java.util.Scanner;

public class Student {

    String studentName;
    int rollNumber;
    double marks;
    String courseName;
    int courseCredits;

    Student(String name, int roll, double m, String course, int credits) {
        studentName = name;
        rollNumber = roll;
        marks = m;
        courseName = course;
        courseCredits = credits;
    }

    double calculateFee() {
        return courseCredits * 1500;
    }

    boolean checkEligibility() {
        return marks >= 50;
    }

    double calculateScholarship() {
        if (marks >= 85)
            return calculateFee() * 0.20;
        else if (marks >= 70)
            return calculateFee() * 0.10;
        else
            return 0;
    }

    double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }

    void displayDetails() {
        System.out.println("\nStudent Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Credits: " + courseCredits);
        System.out.println("Course Fee: Rs." + calculateFee());
        System.out.println("Scholarship: Rs." + calculateScholarship());
        System.out.println("Final Fee: Rs." + calculateFinalFee());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        System.out.print("Enter Course Credits: ");
        int credits = sc.nextInt();

        Student s = new Student(name, roll, marks, course, credits);

        if (s.checkEligibility()) {
            System.out.println("\nStudent is Eligible for Registration");
            s.displayDetails();
        } else {
            System.out.println("\nStudent is Not Eligible for Registration");
        }

        sc.close();
    }
}