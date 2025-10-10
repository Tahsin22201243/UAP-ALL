package Uap;

public class Admin extends User {
    public Admin(String name, int age) {
        super(name, age, "admin");
    }

    @Override
    public void registerFor(String courseRecordId) {
        
    }
}