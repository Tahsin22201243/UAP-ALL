package Uap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CourseManagementSystem {
    private String name;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();
    private ArrayList<CourseRecord> courseRecords = new ArrayList<>();
    private Map<String, String> userRoles;
    

    public CourseManagementSystem(String name) {
        this.name = name;
        this.userRoles = new HashMap<>();
    }
    public void addUser(String userId, String role) {
        userRoles.put(userId, role.toLowerCase());
    }

    
    public boolean isAdmin(String userId) {
        String role = userRoles.get(userId);
        return role != null && role.equalsIgnoreCase("admin");
    }

    
    public boolean isInstructor(String userId) {
        String role = userRoles.get(userId);
        return role != null && role.equalsIgnoreCase("instructor");
    }

    
    public boolean isStudent(String userId) {
        String role = userRoles.get(userId);
        return role != null && role.equalsIgnoreCase("student");
    }

    public String getName() {
        return name;
    }

    public String addCourse(String title) {
        Course course = new Course(title);
        courses.add(course);
        return course.getId();
    }

    public String addCourse(String title, ArrayList<String> topics) {
        Course course = new Course(title, topics);
        courses.add(course);
        return course.getId();
    }

    private String addUser(String name, int age, String role) {
        User user;
        switch (role) {
            case "admin":
                user = new Admin(name, age);
                break;
            case "instructor":
                user = new Instructor(name, age);
                break;
            case "student":
                user = new Student(name, age);
                break;
            default:
                throw new IllegalArgumentException("Invalid role: " + role);
        }
        users.add(user);
        return user.getId();
    }

    public String addAdmin(String name, int age) {
        return addUser(name, age, "admin");
    }

    public String addInstructor(String name, int age) {
        return addUser(name, age, "instructor");
    }

    public String addStudent(String name, int age) {
        return addUser(name, age, "student");
    }

    public String signUp(String name, int age) {
        return addStudent(name, age);
    }

    public CourseRecord findCourseRecord(String recordId) throws InvalidCourseException {
        for (CourseRecord record : courseRecords) {
            if (record.getId().equals(recordId)) {
                return record;
            }
        }
        throw new InvalidCourseException(recordId);
    }

    public User findUser(String userId) throws InvalidUserException {
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        throw new InvalidUserException(userId);
    }

    public Course findCourse(String courseId) throws InvalidCourseException {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return course;
            }
        }
        throw new InvalidCourseException(courseId);
    }

    public void offerCourse(Course course, Instructor instructor, LocalDate startDate, int duration) {
        CourseRecord record = new CourseRecord(course.getId(), instructor.getId(), startDate, duration);
        course.setLatestSessionId(record.getId());
        courseRecords.add(record);
        instructor.registerFor(record.getId());
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Student) {
                students.add((Student) user);
            }
        }
        return students;
    }

    public ArrayList<Student> getStudents(String courseRecordId) {
        ArrayList<Student> students = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Student) {
                Student student = (Student) user;
                if (student.getCourseRecordIds().containsKey(courseRecordId)) {
                    students.add(student);
                }
            }
        }
        return students;
    }

    public ArrayList<Course> getCourses(String title) throws NotAvailableException {
        ArrayList<Course> matchedCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().contains(title)) {
                matchedCourses.add(course);
            }
        }
        if (matchedCourses.isEmpty()) {
            throw new NotAvailableException("No courses found with title: " + title);
        }
        return matchedCourses;
    }

    public ArrayList<CourseRecord> getOfferedCourses(String courseId) throws NotAvailableException {
        ArrayList<CourseRecord> matchedCourseRecords = new ArrayList<>();
        for (CourseRecord record : courseRecords) {
            if (record.getCourseId().equals(courseId)) {
                matchedCourseRecords.add(record);
            }
        }
        if (matchedCourseRecords.isEmpty()) {
            throw new NotAvailableException("No course records found for course ID: " + courseId);
        }
        return matchedCourseRecords;
    }

    public ArrayList<CourseRecord> getOfferedCoursesWithTitle(String courseTitle) throws NotAvailableException {
        ArrayList<Course> matchedCourses = getCourses(courseTitle);
        ArrayList<CourseRecord> allCourseRecords = new ArrayList<>();
        for (Course course : matchedCourses) {
            allCourseRecords.addAll(getOfferedCourses(course.getId()));
        }
        return allCourseRecords;
    }

    public ArrayList<CourseRecord> getRegisteredCourses(User user) throws NotAvailableException {
        ArrayList<CourseRecord> userCourseRecords = new ArrayList<>();
        for (CourseRecord record : courseRecords) {
            if (record.getInstructorId().equals(user.getId()) || user instanceof Student && ((Student) user).getCourseRecordIds().containsKey(record.getId())) {
                userCourseRecords.add(record);
            }
        }
        if (userCourseRecords.isEmpty()) {
            throw new NotAvailableException("No courses found for user: " + user.getId());
        }
        return userCourseRecords;
    }

    public ArrayList<CourseRecord> getRegisteredCourses(String userId) throws NotAvailableException, InvalidUserException {
        User user = findUser(userId);
        return getRegisteredCourses(user);
    }

    public void registerStudent(Student st, CourseRecord record) {
        st.registerFor(record.getId());
    }

    public void registerStudent(Student st, String courseRecordId) throws InvalidCourseException {
        CourseRecord record = findCourseRecord(courseRecordId);
        registerStudent(st, record);
    }

    public void attendClass(Student st, String courseRecordId) throws InvalidCourseException {
        CourseRecord record = findCourseRecord(courseRecordId);
        st.attendClass(courseRecordId);
    }

    public void completeCourse(Student st, String courseRecordId) throws InvalidCourseException {
        CourseRecord record = findCourseRecord(courseRecordId);
        st.completeCourse(courseRecordId);
    }

    public ArrayList<CourseRecord> getInstructedCourses(String instructorId) throws NotAvailableException, InvalidUserException {
        User user = findUser(instructorId);
        if (!(user instanceof Instructor)) {
            throw new InvalidUserException(instructorId + " is not an instructor.");
        }
        return getRegisteredCourses(user);
    }

    public ArrayList<Student> getEnrolledStudents(String courseRecordId) throws NotAvailableException, InvalidCourseException {
        CourseRecord record = findCourseRecord(courseRecordId);
        return getStudents(courseRecordId);
    }

    public ArrayList<CourseRecord> getConductedCourses(String instructorId) throws NotAvailableException, InvalidUserException {
        return getInstructedCourses(instructorId);
    }
    public ArrayList<Course> searchForCourse(String title) throws NotAvailableException {
        ArrayList<Course> matchedCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getTitle().toLowerCase().contains(title.toLowerCase())) {
                matchedCourses.add(course);
            }
        }
        if (matchedCourses.isEmpty()) {
            throw new NotAvailableException("No courses found with title containing: " + title);
        }
        return matchedCourses;
    }
}
