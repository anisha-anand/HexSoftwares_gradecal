import java.util.*;

// Student class
class Student {
    String name;
    int studentId;
    ArrayList<Integer> grades;

    // Constructor
    Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }

    // Add grade
    void addGrade(int grade) {
        grades.add(grade);
    }

    // Display grades
    void displayGrades() {
        System.out.println("Grades of " + name + ": " + grades);
    }

    // Calculate average
    double calculateAverage() {
        if (grades.size() == 0) return 0;

        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    // Pass or Fail (assuming passing >= 40)
    String getResult() {
        return calculateAverage() >= 40 ? "Pass" : "Fail";
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Input students
        for (int i = 0; i < n; i++) {
            sc.nextLine(); // consume newline

            System.out.print("\nEnter name: ");
            String name = sc.nextLine();

            System.out.print("Enter student ID: ");
            int id = sc.nextInt();

            Student s = new Student(name, id);

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();

            for (int j = 0; j < subjects; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = sc.nextInt();
                s.addGrade(grade);
            }

            students.add(s);
        }

        // Display data
        double classTotal = 0;

        System.out.println("\n--- Student Details ---");

        for (Student s : students) {
            s.displayGrades();

            double avg = s.calculateAverage();
            classTotal += avg;

            System.out.println("Average: " + avg);
            System.out.println("Result: " + s.getResult());
            System.out.println();
        }

        // Class average
        double classAverage = classTotal / students.size();
        System.out.println("Class Average: " + classAverage);

        sc.close();
    }
}