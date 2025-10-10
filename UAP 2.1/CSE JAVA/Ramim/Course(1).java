package Uap;

import java.util.ArrayList;

public class Course {
    private String id;
    private String title;
    private ArrayList<String> topics = new ArrayList<>();
    private String latestSessionId;

    public Course(String title) {
        this.id = "C" + title.hashCode();
        this.title = title;
    }

    public Course(String title, ArrayList<String> topics) {
        this(title);
        this.topics = topics;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
    	
        return title;
    }

    public ArrayList<String> getTopics() {
        return topics;
    }

    public void setLatestSessionId(String latestSessionId) {
        this.latestSessionId = latestSessionId;
    }

    public void setTopics(ArrayList<String> topics) {
        this.topics = topics;
    }

    public void addTopics(String... topics) {
        for (String topic : topics) {
            this.topics.add(topic);
        }
    }

    public int noOfClasses() {
        return topics.size();
    }
}