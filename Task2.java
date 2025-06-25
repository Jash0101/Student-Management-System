
import java.util.*;

class Student {

    int id;
    String name;
    int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public void viewStudent() {
        System.out.println(this.id + " " + this.name + " " + this.marks);
    }
}

public class Task2 {

    //view the whole studentlist
    static void viewStudentList(List<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students in the list");
            return;
        }
        for (Student s : studentList) {
            s.viewStudent();
        }
    }

    //add student to the list
    static void addStudent(List<Student> studentList, Scanner sc) {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        int marks = sc.nextInt();

        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);

        System.out.println("Student added successfully.");
    }

    //update/change the data of a student from the list
    static void updateStudent(ArrayList<Student> studentList, Scanner sc) {
        System.out.println("Enter the student ID to update: ");
        int id = sc.nextInt();
        boolean isFound = false;

        for (Student s : studentList) {
            if (s.id == id) {
                System.out.print("Enter new name: ");
                s.name = sc.next();
                sc.nextLine();
                System.out.print("Enter new marks: ");
                s.marks = sc.nextInt();

                System.out.println("Student updated successfully.");
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            System.out.println("Student ID not found!");
        }
    }

    //remove student from the list
    static void removeStudent(ArrayList<Student> studentList, Scanner sc) {
        System.out.println("Enter the student ID to remove:");
        int id = sc.nextInt();
        boolean isFound = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).id == id) {
                studentList.remove(i);
                System.out.println("Student removed successfully");
                isFound = true;
                break;
            }
        }
        if(!isFound) {
            System.out.println("Student ID not found!");
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View student list");
            System.out.println("2. Add student");
            System.out.println("3. Update student");
            System.out.println("4. Remove student");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewStudentList(studentList);
                    break;
                case 2:
                    addStudent(studentList, sc);
                    break;
                case 3:
                    updateStudent(studentList, sc);
                    break;
                case 4:
                    removeStudent(studentList, sc);
                    break;
                case 5:
                    System.out.println("Exited.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
