import java.util.Scanner;

class Student {
    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }
}

public class StudentGradeTracker {
    private Student[] students;
    private int studentCount;

    public StudentGradeTracker(int capacity) {
        this.students = new Student[capacity];
        this.studentCount = 0;
    }

    // Add a new student
    public void addStudent(String name, int grade) {
        if (studentCount >= students.length) {
            System.out.println("Cannot add more students. Capacity reached.");
            return;
        }
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            return;
        }
        students[studentCount++] = new Student(name, grade);
        System.out.println("Added student: " + name + " with grade: " + grade);
    }

    // Calculate the average grade
    public double calculateAverage() {
        if (studentCount == 0) {
            System.out.println("No students available to calculate average.");
            return 0;
        }
        int total = 0;
        for (int i = 0; i < studentCount; i++) {
            total += students[i].getGrade();
        }
        return (double) total / studentCount;
    }

    // Find the highest grade
    public int findHighestGrade() {
        if (studentCount == 0) {
            System.out.println("No students available to find the highest grade.");
            return 0;
        }
        int highest = Integer.MIN_VALUE;
        for (int i = 0; i < studentCount; i++) {
            highest = Math.max(highest, students[i].getGrade());
        }
        return highest;
    }

    // Find the lowest grade
    public int findLowestGrade() {
        if (studentCount == 0) {
            System.out.println("No students available to find the lowest grade.");
            return 0;
        }
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < studentCount; i++) {
            lowest = Math.min(lowest, students[i].getGrade());
        }
        return lowest;
    }

    // Display all students
    public void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + students[i].getName() + ", Grade: " + students[i].getGrade());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of students: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        StudentGradeTracker tracker = new StudentGradeTracker(capacity);

        while (true) {
            System.out.println("\n--- Student Grade Tracker Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Calculate Average Grade");
            System.out.println("4. Find Highest Grade");
            System.out.println("5. Find Lowest Grade");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student grade (0-100): ");
                    int grade = scanner.nextInt();
                    tracker.addStudent(name, grade);
                    break;
                case 2:
                    tracker.displayStudents();
                    break;
                case 3:
                    System.out.println("Average Grade: " + tracker.calculateAverage());
                    break;
                case 4:
                    System.out.println("Highest Grade: " + tracker.findHighestGrade());
                    break;
                case 5:
                    System.out.println("Lowest Grade: " + tracker.findLowestGrade());
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
