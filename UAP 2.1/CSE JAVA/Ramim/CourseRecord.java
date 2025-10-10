package Uap;

import java.time.LocalDate;
import java.util.HashSet;

public class CourseRecord {
    private static int nextId = 1;

    private String id;
    private String courseId;
    private String instructorId;
    private LocalDate startDate;
    private int duration;
    private LocalDate endDate;
    private HashSet<String> registeredStudentIds = new HashSet<>();

    public CourseRecord(String courseId, String instructorId, LocalDate startDate, int duration) {
        this.id = "CR" + nextId++;
        this.courseId = courseId;
        this.instructorId = instructorId;
        this.startDate = startDate;
        this.duration = duration;
        
    }

    public String getId() {
        return id;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getInstructorId() {
        return instructorId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public HashSet<String> getRegisteredStudentIds() {
        return registeredStudentIds;
    }

    public void addStudent(String studentId) throws Exception {
        if (registeredStudentIds.contains(studentId)) {
            throw new Exception("Student already registered for this course.");
        }
        registeredStudentIds.add(studentId);
    }

    
    
}
