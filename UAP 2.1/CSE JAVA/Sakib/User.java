package uap;

import java.util.Random;

public abstract class User {
    private String id;
    private String name;
    private int age;
    private String role;

    
    public User(String name, int age, String role) {
        this.id = generateID(role);
        this.name = name;
        this.age = age;
        this.role = role;
    }

    private String generateID(String role) {
        Random random = new Random();
        int randomNumber = random.nextInt(9999);
        String prefix="";
        if (role.equals("admin")) {
            prefix = "a-";
        } else if (role.equals("instructor")) {
            prefix = "i-";
        } else if (role.equals("student")) {
            prefix = "s-";
        }
        return prefix + randomNumber;
    }

    
    public abstract void registerFor(String courseRecordId);

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


    public String toString() {
        return "User{" + "id='" + id  + ", name='" + name  + ", age=" + age + ", role='" + role + '}';

    }
}