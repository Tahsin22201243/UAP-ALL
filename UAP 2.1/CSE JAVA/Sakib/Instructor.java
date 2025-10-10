package uap;

import java.util.ArrayList;

public class Instructor extends User {
    private ArrayList<String> courseRecordIds = new ArrayList<>();

    public Instructor(String name, int age) {
        super(name, age, "instructor");
    }

    @Override
    public void registerFor(String courseRecordId) {
        courseRecordIds.add(courseRecordId);
    }

    public ArrayList<String> getCourseRecordIds() {
        return courseRecordIds;
    }
}