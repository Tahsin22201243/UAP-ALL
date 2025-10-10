package Uap;

import java.util.Random;

public abstract class User {
    protected String id;
    protected String name;
    protected int age;
    protected String role;

    public User(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
        generateID();
    }

    private void generateID() {
        Random random = new Random();
        int randomNum = random.nextInt(9000) + 1000;
        String prefix ;
        if (role.equals("admin")) {
            prefix = "a-";
            
        } else if (role.equals("instructor")) {
            prefix = "i-";
            
        } else {
            prefix = "s-";
           
        }
        id = prefix + randomNum;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }

    public abstract void registerFor(String courseRecordId);

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Role: " + role;
    }
}