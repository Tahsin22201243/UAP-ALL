package Uap.app;

import Uap.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
	
	    private static Scanner scanner = new Scanner(System.in);
	    private static CourseManagementSystem cms = new CourseManagementSystem("MyCourseManagementSystem");
	    public static void main(String[] args) {
	    	
	    	
	    	cms.addUser("a-123", "admin");
	        cms.addUser("i-456", "instructor");
	        cms.addUser("s-789", "student");
     

    
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.println("Welcome to Course Management System");
            System.out.println("Please enter your User ID (Type 'exit' to quit):");
            String userId = scanner.nextLine();
            String role = scanner.nextLine().toLowerCase();
           
            if (userId.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                loggedIn = true;
                continue;
            }

            
            if (cms.isAdmin(userId)) {
                System.out.println("Logged in as Admin.");
                adminMenu();
                loggedIn = true;
                continue;
            }

            
            if (cms.isInstructor(userId)) {
                System.out.println("Logged in as Instructor.");
                instructorMenu();
                loggedIn = true;
                continue;
            }

            
            if (cms.isStudent(userId)) {
                System.out.println("Logged in as Student.");
                studentMenu();
                loggedIn = true;
                continue;
            }

            
            System.out.println("Invalid User ID. Please try again.");
            }
        }
    

    private static void adminMenu() {
        boolean isAdminLoggedIn = false;
        while (!isAdminLoggedIn) {
            System.out.println("Admin Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Add Instructor");
            System.out.println("3. Add Student");
            System.out.println("4. Offer a Course");
            System.out.println("5. View List of Courses");
            System.out.println("6. View List of Offered Courses");
            System.out.println("7. View List of Students");
            System.out.println("8. View List of Instructors");
            System.out.println("9. View Details of a Course");
            System.out.println("10. View Details of an Offered Course");
            System.out.println("11. View Details of a Student");
            System.out.println("12. View Details of an Instructor");
            System.out.println("13. View Enrolled Students of an Offered Course");
            System.out.println("14. View Registered Courses for a Student");
            System.out.println("15. View Instructed Courses for an Instructor");
            System.out.println("16. Register Student for Course");
            System.out.println("17. Search for Course");
            System.out.println("18. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    addInstructor();
                    break;
                case 3:
                    addStudent();
                    break;
                case 4:
                    offerCourse();
                    break;
                case 5:
                  viewCourses();
                    break;
                case 6:
                   viewOfferedCourses();
                    break;
                case 7:
                    viewStudents();
                    break;
                case 8:
                   viewInstructors();
                    break;
                case 9:
                    viewCourseDetails();
                    break;
                case 10:
                    viewOfferedCourseDetails();
                    break;
                case 11:
                    viewStudentDetails();
                    break;
                case 12:
                    viewInstructorDetails();
                    break;
                case 13:
                    viewEnrolledStudents();
                    break;
                case 14:
                    viewRegisteredCourses();
                    break;
                case 15:
                    viewInstructedCourses();
                    break;
                case 16:
                    registerStudentForCourse();
                    break;
                case 17:
                   searchForCourse();
                    break;
                case 18:
                    isAdminLoggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    
	private static void addCourse() {
        System.out.println("Enter Course Title and topics:");
        String title = scanner.nextLine();
        String courseId = cms.addCourse(title);
        System.out.println("Course added successfully. Course ID: " + courseId);
    }

    private static void addInstructor() {
        System.out.println("Enter Instructor Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Instructor Age:");
        int age = Integer.parseInt(scanner.nextLine());
        String instructorId = cms.addInstructor(name, age);
        System.out.println("Instructor added successfully. Instructor ID: " + instructorId);
    }

    private static void addStudent() {
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        System.out.println("Enter Student Age:");
        int age = Integer.parseInt(scanner.nextLine());
        String studentId = cms.addStudent(name, age);
        System.out.println("Student added successfully. Student ID: " + studentId);
    }

    private static void offerCourse() {
        System.out.println("Enter Course ID:");
        String courseId = scanner.nextLine();
        System.out.println("Enter Instructor ID:");
        String instructorId = scanner.nextLine();
        System.out.println("Enter Start Date (YYYY-MM-DD):");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter Duration (in months):");
        int duration = Integer.parseInt(scanner.nextLine());
        try {
            cms.offerCourse(courseId, instructorId, startDate.toString(), duration);
            System.out.println("Course offered successfully.");
        } catch (Exception e) {
            System.out.println("Error offering course: " + e.getMessage());
        }
    }

    private static void viewCourses() {
        ArrayList<Course> courses = Uap.CourseManagementSystem.getCourses();
        System.out.println("List of Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void viewOfferedCourses() {
        ArrayList<CourseRecord> courseRecords = cms.getCourseRecords();
        System.out.println("List of Offered Courses:");
        for (CourseRecord record : courseRecords) {
            System.out.println(record);
        }
    }
    
    private static void viewStudents() {
        ArrayList<Student> students = cms.getStudents();
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void viewInstructors() {
        ArrayList<User> users = cms.getUsers();
        System.out.println("List of Instructors:");
        for (User user : users) {
            if (user instanceof Instructor) {
                System.out.println(user);
            }
        }
    }
    

    private static void viewCourseDetails() {
        System.out.println("Enter Course ID:");
        String courseId = scanner.nextLine();
        try {
            Course course = cms.findCourse(courseId);
            System.out.println("Course Details:");
            System.out.println(course);
        } catch (InvalidCourseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewOfferedCourseDetails() {
        System.out.println("Enter Offered Course ID:");
        String recordId = scanner.nextLine();
        try {
            CourseRecord record = cms.findCourseRecord(recordId);
            System.out.println("Offered Course Details:");
            System.out.println(record);
        } catch (InvalidCourseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudentDetails() {
        System.out.println("Enter Student ID:");
        String studentId = scanner.nextLine();
        try {
            User user = cms.findUser(studentId);
            if (user instanceof Student) {
                System.out.println("Student Details:");
                System.out.println(user);
            } else {
                System.out.println("Error: User is not a student.");
            }
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewInstructorDetails() {
        System.out.println("Enter Instructor ID:");
        String instructorId = scanner.nextLine();
        try {
            User user = cms.findUser(instructorId);
            if (user instanceof Instructor) {
                System.out.println("Instructor Details:");
                System.out.println(user);
            } else {
                System.out.println("Error: User is not an instructor.");
            }
        } catch (InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewEnrolledStudents() {
        System.out.println("Enter Offered Course ID:");
        String recordId = scanner.nextLine();
        try {
            CourseRecord record = cms.findCourseRecord(recordId);
            ArrayList<Student> students = cms.getStudents(recordId);
            System.out.println("Enrolled Students for Offered Course " + recordId + ":");
            for (Student student : students) {
                System.out.println(student);
            }
        } catch (InvalidCourseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewRegisteredCourses() {
        System.out.println("Enter Student ID:");
        String studentId = scanner.nextLine();
        try {
            ArrayList<CourseRecord> records = cms.getRegisteredCourses(studentId);
            System.out.println("Registered Courses for Student " + studentId + ":");
            for (CourseRecord record : records) {
                System.out.println(record);
            }
        } catch (NotAvailableException | InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewInstructedCourses() {
        System.out.println("Enter Instructor ID:");
        String instructorId = scanner.nextLine();
        try {
            ArrayList<CourseRecord> records = cms.getInstructedCourses(instructorId);
            System.out.println("Instructed Courses for Instructor " + instructorId + ":");
            for (CourseRecord record : records) {
                System.out.println(record);
            }
        } catch (NotAvailableException | InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void registerStudentForCourse() {
        System.out.println("Enter Student ID:");
        String studentId = scanner.nextLine();
        System.out.println("Enter Offered Course ID:");
        String recordId = scanner.nextLine();
        try {
            cms.registerStudent(studentId, recordId);
            System.out.println("Student " + studentId + " registered successfully for Offered Course " + recordId);
        } catch (InvalidCourseException | InvalidUserException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchForCourse() {
        System.out.println("Enter Course Title to search:");
        String title = scanner.nextLine();
        try {
            ArrayList<Course> courses = cms.searchForCourse(title);
            System.out.println("Matching Courses:");
            for (Course course : courses) {
                System.out.println(course);
            }
        } catch (NotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
    

    private static void instructorMenu() {
        System.out.println("Instructor Menu:");
        System.out.println("1. Search for course");
        System.out.println("2. View list of conducted courses");
        System.out.println("3. View list of enrolled students for a specific course");
        System.out.println("4. Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
              searchForCourse();
                break;
            case 2:
               viewConductedCourses();
                break;
            case 3:
                viewEnrolledStudents();
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice.");
        }

        instructorMenu(); // Re-display the menu after an operation
    }
    

    private static void studentMenu() {
        System.out.println("Student Menu:");
        System.out.println("1. Sign up");
        System.out.println("2. Search for course");
        System.out.println("3. View list of enrolled courses");
        System.out.println("4. Register for a course");
        System.out.println("5. Attend class of an enrolled course");
        System.out.println("6. Complete an enrolled course");
        System.out.println("7. Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
              signUp();
                break;
            case 2:
               searchForCourse();
                break;
            case 3:
               viewEnrolledCourses();
                break;
            case 4:
              registerForCourse();
                break;
            case 5:
               attendClass();
                break;
            case 6:
               completeCourse();
                break;
            case 7:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice.");
        }

        studentMenu(); 
    }
}

