package Uap;

import java.util.HashMap;

public class Student extends User {
    private HashMap<String, String> courseRecordIds = new HashMap<>();

    public Student(String name, int age) {
        super(name, age, "student");
    }

    @Override
    public void registerFor(String courseRecordId) {
        courseRecordIds.put(courseRecordId, "registered");
    }

    public void attendClass(String courseRecordId) throws InvalidCourseException {
        if (!courseRecordIds.containsKey(courseRecordId)) {
            throw new InvalidCourseException(courseRecordId);
        }
        courseRecordIds.put(courseRecordId, "in-progress");
    }

    public void completeCourse(String courseRecordId) throws InvalidCourseException {
        if (!courseRecordIds.containsKey(courseRecordId)) {
            throw new InvalidCourseException(courseRecordId);
        }
        courseRecordIds.put(courseRecordId, "completed");
    }

    public HashMap<String, String> getCourseRecordIds() {
        return courseRecordIds;
    }
}